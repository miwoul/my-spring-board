package org.kitri.myspringboard.controller;

import org.kitri.myspringboard.domain.Users;
import org.kitri.myspringboard.sevice.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("users", new Users());
        return "signup";
    }
//    @PostMapping("/signup")
//    public String signup(@ModelAttribute("users") Users users) {
//        usersService.signup(users);
//        return "redirect:/board/list";
//    }
    @PostMapping("/signup")
    public String signup(Users users) {
        usersService.save(users);
        return "redirect:/login";
    }
}
