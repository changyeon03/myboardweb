package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.BoardDTO;
import dto.ReplyDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.BoardService;
import service.ReplyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    ReplyService replyService;

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void getList(Model model) throws Exception {
        List<BoardDTO> list = boardService.getBoardList();
        model.addAttribute("list", list);
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String getWrite(HttpSession httpSession, Model model) throws Exception {
        Object userName = httpSession.getAttribute("userName");
        model.addAttribute("userName", userName);

        return "/board/write";

    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String postWrite(HttpServletRequest httpServletRequest) throws Exception {
        String title = httpServletRequest.getParameter("title");
        String content = httpServletRequest.getParameter("content");
        String writer = httpServletRequest.getParameter("writer");
        boardService.write(title, content, writer);

        return "redirect:/board/list";
    }

    @RequestMapping(value = "/writeReply", method = RequestMethod.POST)
    public String postWriteReply(@RequestParam("bno") int bno, String writer, String content) throws Exception {
        replyService.writeReply(bno, writer, content);
        return "redirect:/board/view?bno=" + bno;
    }

    @RequestMapping(value = "/modifyReply", method = RequestMethod.GET)
    public void getModifyReply(@RequestParam("rno") int rno, Model model) {
        ReplyDTO replyDTO = replyService.viewReply(rno);
        model.addAttribute(replyDTO);
    }

    @RequestMapping(value = "/modifyReply", method = RequestMethod.POST)
    public String postModifyReply(HttpServletRequest httpServletRequest, ReplyDTO replyDTO) {
        int rno = replyDTO.getRno();
        //int bno = replyDTO.getBno();
        int bno = replyService.getBno(rno);
        String writer = httpServletRequest.getParameter("writer");
        String content = httpServletRequest.getParameter("content");
        replyService.modifyReply(rno, writer, content);
        return "redirect:/board/view?bno=" + bno;
    }

    @RequestMapping(value = "/deleteReply", method = RequestMethod.GET)
    public String getModifyReply(@Param("rno") int rno) {
        int bno = replyService.getBno(rno);
        System.out.println(bno);
        replyService.deleteReply(rno);
        return"redirect:/board/view?bno=" + bno;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
        boardService.upView(bno);
        BoardDTO boardDTO = boardService.view(bno);
        model.addAttribute("view", boardDTO);
        List<ReplyDTO> readReply = replyService.readReply(bno);
        model.addAttribute("readReply", readReply);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelte(@Param("bno") int bno) throws Exception {
        boardService.delete(bno);

        return "redirect:/board/list";
    }

    //작성자만 게시글을 수정하게 하고 싶다
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public void getModify(@RequestParam("bno") int bno, Model model, HttpSession httpSession, BoardDTO writer) throws Exception {
        /*
        Object userName = httpSession.getAttribute("userName");
        Object writerName = writer.getWriter();
        if(writerName == userName) {
            model.addAttribute("msg", null);
        }
        else {
            model.addAttribute("msg", false);
        }
        */
        BoardDTO boardDTO = boardService.view(bno);
        model.addAttribute("modify", boardDTO);
        //model.addAttribute("userName", userName);
    }
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String postModify(HttpServletRequest httpServletRequest, BoardDTO boardDTO) {
        int bno = boardDTO.getBno();
        String title = httpServletRequest.getParameter("title");
        String content = httpServletRequest.getParameter("content");
        String writer = httpServletRequest.getParameter("writer");
        boardService.modify(title, content, writer, bno);

        return "redirect:/board/view?bno=" + bno;
    }
}
