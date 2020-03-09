package hiber.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "admin/list";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/formUser";
    }

    @PostMapping("/saveUser")
    public String saveCustomer(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("userId") Long id,
                                    Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
