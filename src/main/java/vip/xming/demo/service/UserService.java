package vip.xming.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.xming.demo.mapper.UserMapper;
import vip.xming.demo.model.User;
import vip.xming.demo.model.UserExample;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            //添加
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        } else {
            //修改
            user.setGmtModified(System.currentTimeMillis());
            UserExample userExample1 = new UserExample();
            userExample1.createCriteria().andIdEqualTo(users.get(0).getId());
            userMapper.updateByExampleSelective(user, userExample1);
        }
    }
}
