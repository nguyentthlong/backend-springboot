package com.spring.qlda.SpringbootReact.controller;

import com.spring.qlda.SpringbootReact.model.User;
import com.spring.qlda.SpringbootReact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@Controller
public class AppController {

    @Autowired
    private UserRepository repo;

    @GetMapping("")
    public String HomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String SignUpForm(Model model){
        model.addAttribute("user", new User());
        return "signup_form";
    }
    
    // @RequestMapping
    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repo.save(user);
        return "register_success";
    }
    
    @GetMapping("/list_users")
    public String ViewUserList(Model model) {
        List<User> listUsers = repo.findAll();
        model.addAttribute("ViewUserList", listUsers);

        return "index_users";
    }

//    @GetMapping("/list_users")
//
//        List<User> listUsers (){
////        model.addAttribute("ViewUserList", listUsers);
//        return repo.findAll();
//
//    }

}

