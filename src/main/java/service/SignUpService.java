package service;

import dto.UserDTO;

import java.util.List;

public interface SignUpService {

    // 신규유저 가입
    void insertUser(String account, String pw, String nick_name);
    public List<UserDTO> getUserList();
}