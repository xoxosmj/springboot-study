package user.dao;

import org.apache.ibatis.annotations.Mapper;
import user.bean.UserDTO;

import java.util.List;

@Mapper
public interface UserDAO {
    public UserDTO getExistId(String id);

    public void write(UserDTO userDTO);

    List<UserDTO> list();
}
