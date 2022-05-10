package admin.mapper;

import admin.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author WPZ
 * @Date 2022/5/6 16:30
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
