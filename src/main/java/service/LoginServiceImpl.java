package service;

import dto.UserDTO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import repository.UserMapper;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UserMapper userMapper;

    @Override
    public boolean isUser(UserDTO userDTO) {
        String hash = userMapper.getUserPassword(userDTO.getAccount());
        return BCrypt.checkpw(userDTO.getPassword(), hash);
    }
}
