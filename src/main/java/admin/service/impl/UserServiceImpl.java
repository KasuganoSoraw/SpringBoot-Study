package admin.service.impl;

import admin.bean.User;
import admin.mapper.UserMapper;
import admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author WPZ
 * @Date 2022/5/6 16:51
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
