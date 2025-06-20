package com.frankmoley.lil.admin_web.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String getHome(Model model) {
    return "index";
  }

  @GetMapping("/login")
  public String getLoginPage() {
    return "login";
  }
}