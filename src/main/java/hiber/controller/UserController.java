package hiber.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUser(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "formUser";
    }

    @PostMapping("/saveUser")
    public String saveCustomer(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("userId") Long id,
                                    Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
