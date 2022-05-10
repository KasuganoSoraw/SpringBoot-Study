package admin.controller;

import admin.bean.User;
import admin.service.UserService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Author WPZ
 * @Date 2022/5/2 15:33
 * @Version 1.0
 */
@Controller
public class TableController {

    @Autowired
    UserService userService;


    @RequestMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes redirectAttributes) {
        userService.removeById(id);
        redirectAttributes.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }

    @RequestMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1")Integer pn,Model model) {
        //从数据库user表中查出数据
//        List<User> users = userService.list();
//        model.addAttribute("users", users);

        Page<User> userPage = new Page<>(pn, 2);
        Page<User> users = userService.page(userPage, null);

//        List<User> records = page.getRecords();

        model.addAttribute("users", users);
        return "table/dynamic_table";

    }

    @RequestMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @RequestMapping("/pricing_table")
    public String pricing_table() {
        return "table/pricing_table";
    }

    @RequestMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

}
