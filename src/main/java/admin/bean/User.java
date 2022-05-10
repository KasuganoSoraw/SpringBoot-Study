package admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

/**
 * @Author WPZ
 * @Date 2022/5/2 14:50
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")
public class User {

    @TableField(exist = false)
    String userName;
    @TableField(exist = false)
    String password;

    //以下是数据库属性
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
