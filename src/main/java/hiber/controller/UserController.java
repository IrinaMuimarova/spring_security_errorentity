package hiber.controller;

import hiber.model.User;
import hiber.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getUser(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "list";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping("/saveUser")
    public String saveCustomer(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:list";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("userId") long id,
                                    Model model) {
        model.addAttribute("customer", userService.getUserById(id));
        return "edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return "redirect:list";
    }
}
