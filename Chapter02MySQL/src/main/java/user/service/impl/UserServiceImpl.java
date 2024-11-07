package user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.dao.UserDAO;
import user.service.UserService;

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
        return "";
    }
}
