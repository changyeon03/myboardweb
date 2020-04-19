package service;

import dto.UserDTO;

public interface LoginService {
    boolean isUser(UserDTO userDTO);
}