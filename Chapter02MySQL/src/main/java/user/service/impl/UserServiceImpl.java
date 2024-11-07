package user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.bean.UserDTO;
import user.dao.UserDAO;
import user.service.UserService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    //생성자 인젝션
    private UserDAO userDAO;
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String getExistId(String id) {
        UserDTO userDTO = userDAO.getExistId(id);
        System.out.println(userDTO);

        if (userDTO != null) {
            return "exist";
        } else return "non_exist";
    }

    @Override
    public void write(UserDTO userDTO) {
        System.out.println(userDTO);
        userDAO.write(userDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userDAO.list();

    }


}
