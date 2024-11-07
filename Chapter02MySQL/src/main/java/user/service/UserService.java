package user.service;

import user.bean.UserDTO;

import java.util.List;

public interface UserService {
    public String getExistId(String id);

    public void write(UserDTO userDTO);

    List<UserDTO> getAllUsers();
}
