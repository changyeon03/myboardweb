package service;

import dto.UserDTO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import repository.UserMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Resource
    UserMapper userMapper;

    public void insertUser(String account, String pw, String nick_name) {
        pw = BCrypt.hashpw(pw, BCrypt.gensalt(10));
        userMapper.insertUser(account, pw, nick_name);
    }

    @Override
    public List<UserDTO> getUserList() {
        return userMapper.getUserList();
    }

}