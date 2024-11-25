package com.thuctap.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.thuctap.models.Brand;
import com.thuctap.models.Category;
import com.thuctap.models.Color;
import com.thuctap.models.Size;
import com.thuctap.models.Users;
import com.thuctap.service.BrandService;
import com.thuctap.service.CategoryService;
import com.thuctap.service.ColorService;
import com.thuctap.service.SizeService;
import com.thuctap.service.UserService;

@Controller
@RequestMapping("/admin")
public class ColorController {
	@Autowired
	private ColorService colorService;
	@GetMapping("/color")
    public String index(Model model) {
		List<Color> list=colorService.findAll();
		model.addAttribute("list", list);
        return "admin/color/index";
    }
	@GetMapping("/color/add")
    public String add(Model model) {
    	Color color=new Color();
    	
    	model.addAttribute("color", color);
    	return "admin/color/add";
    }
    @PostMapping("/color/add")
    public String save(Model model,@ModelAttribute("color") Color color) {
    	
    	if(this.colorService.create(color)) {
    		return "redirect:/admin/color";
    	}
    	else {
    		return "admin/color/add";
    	}
    }
    @GetMapping("color/edit/{id}")
    public String edit(Model model,@PathVariable("id") Integer id) {
    	Color color =this.colorService.findById(id);
    	model.addAttribute("color",color);
    	return "admin/color/edit";
    }
    @PostMapping("color/edit")
    public String update(@ModelAttribute("color") Color color) {
    	
    	if(this.colorService.create(color)) {
    		return "redirect:/admin/color";
    	}
    	return "admin/color/edit";
    }
    @GetMapping("color/delete/{id}")
    public String delete(Model model,@PathVariable("id") Integer id) {
    	if(this.colorService.delete(id)) {
    		return "redirect:/admin/color";
    	}
    	return "redirect:/admin/color";
    }
}
