package com.lzc.basicssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/home/{path}", method = RequestMethod.GET)
    public String printHello(@PathVariable("path") String path,
                             @RequestParam(value = "aa") String name, @RequestParam(value = "bb") double age) {
        logger.info("path: " + path + " name: " + name + "age: " + age);

        return "hello";
    }

    //pass the parameters to front-end
    @RequestMapping("/show")
    public ModelAndView showPerson() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "i from mv");
        mv.setViewName("show");
        return mv;
    }

//    @ModelAttribute
//    public void userModel(String loginname, String password, Model model) {
//        logger.debug("usrModel");
//        User user = new User();
//        user.setName(loginname);
//        user.setPsd(password);
//        model.addAttribute("user", user);
//    }

//    public void

    @RequestMapping(value = "/views/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        logger.debug("login: " + username + " psd: " + password);
        return "show";
    }
}
