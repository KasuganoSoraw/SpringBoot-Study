package admin.controller;

import admin.bean.City;
import admin.bean.User;
import admin.service.CityService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author WPZ
 * @Date 2022/5/2 14:18
 * @Version 1.0
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CityService cityService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city) {
        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @RequestMapping("/city")
    public City getById(@RequestParam("id") Long id) {
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDB() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from employees", Long.class);
        log.info("记录总数{}", aLong);
        return aLong.toString();
    }

    /**
     * 去登陆页
     * @return
     */
    @RequestMapping({"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "账号密码错误");
            //回到登录页面
            return "login";
        }

    }

    /**
     * 真正去main页面，解决重复提交
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        String s = operations.get("/main.html");
        String s1 = operations.get("/sql");

        model.addAttribute("mainCount", s);
        model.addAttribute("sqlCount", s1);
        return "main";
    }
}
