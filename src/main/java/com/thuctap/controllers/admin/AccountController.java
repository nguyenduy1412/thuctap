package com.thuctap.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thuctap.models.Users;
import com.thuctap.service.UserService;





@Controller
@RequestMapping("/admin")
public class AccountController {
	@Autowired
	private UserService userService;
	@GetMapping("/account")
    public String index(Model model) {
		List<Users> list=userService.findAllUsers();
		model.addAttribute("list", list);
        return "admin/account/index";
    }
}
