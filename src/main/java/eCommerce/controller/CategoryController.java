package eCommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ECommerce.DAO.CategoryDAO;
import ECommerce.model.Category;


@Controller
public class CategoryController {

   @Autowired
   CategoryDAO categoryDAO;
   
   
	@RequestMapping("/category")
	public String showCategroy(Model m)
	{
		List<Category> listCatg= categoryDAO.listCategories();
		m.addAttribute("listCategories",listCatg);
		m.addAttribute("pageinfo", "AboutUs");
		return "Category";
	}
	
	@RequestMapping(value="/AddCategory",method=RequestMethod.POST)
	
	public String addCategory(Model m , @RequestParam("catName") String categoryName,@RequestParam("catDesc")String CategoryDesc)
	{
		
		
		
	  Category category = new Category();	
	  category.setCategoryName(categoryName);
	  category.setCategoryDesc(CategoryDesc);
	  categoryDAO.addCategory(category);
	  
	  List<Category> listCatg= categoryDAO.listCategories();
	  m.addAttribute("listCategories",listCatg);
	  
	  m.addAttribute("pageinfo", "Manage Category");
	  
	  return "Category";
	
	
	}
	
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	
	public String updateCategory(Model m , @RequestParam("catId") int categoryId,@RequestParam("catName")String CategoryName,@RequestParam("cateDesc")String CategoryDesc)
	{
		
		
		
	  Category category = categoryDAO.getCategory(categoryId);	
	  category.setCategoryName(CategoryName);
	  category.setCategoryDesc(CategoryDesc);
	  categoryDAO.updateCategory(category);
	  
	  List<Category> listCatg= categoryDAO.listCategories();
	  m.addAttribute("listCategories",listCatg);
	  
	  m.addAttribute("pageinfo", "Manage Category");
	  
	  return "Category";
	}
	
    @RequestMapping(value="/deleteCategory",method=RequestMethod.POST)
	
	public String deleteCategory(Model m , @PathVariable("catId") int categoryId)
	{
	
    	Category category = categoryDAO.getCategory(categoryId);	
    	categoryDAO.deleteCategory(category);
    	
        List<Category> listCatg= categoryDAO.listCategories();
   	    m.addAttribute("listCategories",listCatg);
   	   
   	    m.addAttribute("pageinfo", "Manage Category");
	  
	    return "Category";
   	   
   	   
   	   
	}
	
    @RequestMapping(value="/editCategory",method=RequestMethod.POST)
	
   	public String eidtCategory(Model m , @PathVariable("catId") int categoryId)
   	{    
    	
    	Category category = categoryDAO.getCategory(categoryId);	
    	
    	m.addAttribute("category", category);
       
    	m.addAttribute("pageinfo", "Manage Category");
    	
    	 return "UpdateCategory";
   	}
	
}
