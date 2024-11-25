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
import com.thuctap.models.Size;
import com.thuctap.models.Users;
import com.thuctap.service.BrandService;
import com.thuctap.service.CategoryService;
import com.thuctap.service.SizeService;
import com.thuctap.service.UserService;

@Controller
@RequestMapping("/admin")
public class SizeController {
	@Autowired
	private SizeService sizeService;
	@GetMapping("/size")
    public String index(Model model) {
		List<Size> list=sizeService.findAll();
		model.addAttribute("list", list);
        return "admin/size/index";
    }
	@GetMapping("/size/add")
    public String add(Model model) {
    	Size size=new Size();
    	
    	model.addAttribute("size", size);
    	return "admin/size/add";
    }
    @PostMapping("/size/add")
    public String save(Model model,@ModelAttribute("size") Size size) {
    	
    	if(this.sizeService.create(size)) {
    		return "redirect:/admin/size";
    	}
    	else {
    		return "admin/size/add";
    	}
    }
    @GetMapping("size/edit/{id}")
    public String edit(Model model,@PathVariable("id") Integer id) {
    	Size size =this.sizeService.findById(id);
    	model.addAttribute("size",size);
    	return "admin/size/edit";
    }
    @PostMapping("size/edit")
    public String update(@ModelAttribute("size") Size size) {
    	
    	if(this.sizeService.create(size)) {
    		return "redirect:/admin/size";
    	}
    	return "admin/size/edit";
    }
    @GetMapping("size/delete/{id}")
    public String delete(Model model,@PathVariable("id") Integer id) {
    	if(this.sizeService.delete(id)) {
    		return "redirect:/admin/size";
    	}
    	return "redirect:/admin/size";
    }
}
