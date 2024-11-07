package user.service;

import user.bean.UserDTO;

public interface UserService {
    public String getExistId(String id);

    void write(UserDTO userDTO);
}
