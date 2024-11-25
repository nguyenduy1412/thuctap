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

import com.thuctap.models.Category;
import com.thuctap.models.Users;
import com.thuctap.service.CategoryService;
import com.thuctap.service.UserService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/category")
    public String index(Model model,@Param("keyword") String keyword,
    		@RequestParam(name="page",defaultValue = "1") Integer page) {
		Page<Category> list=this.categoryService.getAll(page,5);
		if(keyword !=null) {
			list=this.categoryService.searchCategory(keyword,page,5);
			model.addAttribute("keyword",keyword);
		}
		model.addAttribute("totalPage", list.getTotalPages());
		model.addAttribute("currentPage",page);
		model.addAttribute("list",list);		
        return "admin/category/index";
    }
	@GetMapping("/category/add")
    public String add(Model model) {
    	Category category=new Category();
    	category.setStatus(true);
    	model.addAttribute("category", category);
    	return "admin/category/add";
    }
    @PostMapping("/category/add")
    public String save(Model model,@ModelAttribute("category") Category category) {
    	
    	if(this.categoryService.create(category)) {
    		return "redirect:/admin/category";
    	}
    	else {
    		return "admin/category/add";
    	}
    }
    @GetMapping("category/edit/{id}")
    public String edit(Model model,@PathVariable("id") Integer id) {
    	Category category =this.categoryService.findById(id);
    	model.addAttribute("category",category);
    	return "admin/category/edit";
    }
    @PostMapping("category/edit")
    public String update(@ModelAttribute("category") Category category) {
    	
    	if(this.categoryService.create(category)) {
    		return "redirect:/admin/category";
    	}
    	return "admin/category/edit";
    }
    @GetMapping("category/delete/{id}")
    public String delete(Model model,@PathVariable("id") Integer id) {
    	if(this.categoryService.delete(id)) {
    		return "redirect:/admin/category";
    	}
    	return "redirect:/admin/category";
    }
}
