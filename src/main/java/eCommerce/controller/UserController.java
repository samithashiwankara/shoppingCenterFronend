package eCommerce.controller;

import java.security.Security;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import ECommerce.DAO.ProductDAO;
import ECommerce.model.Product;



@Controller
public class UserController {
	
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping(value="/username")
	public String showUSerHome(Model m, HttpSession session)
	{
		m.addAttribute("pageinfo", "Product CataLog");
		List<Product>listProduct=productDAO.listproduct();
		m.addAttribute("productList",listProduct);
		
		return "userHome";
		
		
	}
	
	@RequestMapping(value="/login_success")
	 public String loginCheck(Model m, HttpSession session)
	 {
		String page="";
		boolean loggedIn=false;
		
		
		SecurityContext securitycontext=SecurityContextHolder.getContext();
		Authentication authentication=securitycontext.getAuthentication();
		
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		 for(GrantedAuthority role:roles)
		 {
			 session.setAttribute("role", role.getAuthority());
			 if(role.getAuthority().equals("Role_Admin"))
			 {
				 loggedIn=true;
				 page="UserHome";
				 session.setAttribute("loggedIn", loggedIn);
				 session.setAttribute("username",username);
			 }
			 else
			 {
				m.addAttribute("pageinfo","User_Home");
				List<Product>listProduct=productDAO.listproduct();
				m.addAttribute("productList",listProduct);
				loggedIn=true;
				page="UserHome";
				
				
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			 }
			 
		 }
		
		return page;
		
		
	 }
	
	
	

}
