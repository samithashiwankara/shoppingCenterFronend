package eCommerce.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ECommerce.DAO.CategoryDAO;
import ECommerce.DAO.ProductDAO;
import ECommerce.model.Category;
import ECommerce.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping("/product")
	public String showProduct(Model m)
	{
		Product product = new Product();
		m.addAttribute(product);
		
		List<Product> listProduct = productDAO.listproduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("pageinfo","Manager Product");
		
		
		return "Product";
	}
	
	 @RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	
	public String insertProduct(@ModelAttribute("product")Product product, @RequestParam("pimage")MultipartFile filedet,Model m)
	
	{
		 productDAO.addProduct(product);
		 
		 Product product1 = new Product();
		 m.addAttribute(product1);
		 m.addAttribute("pageinfo","Manager Product");
		 m.addAttribute("categoryList" , this.getCategories());
		 
		 String imagepath ="E:\\JAVA\\shoppingCenterFronend\\src\\main\\resources\\images\\";
		 imagepath = imagepath+String.valueOf(product.getProductId()+".jpg");
		 
		 File image = new File(imagepath);
		 
		 if(! filedet.isEmpty())
		 {
			 try
			 {
				 byte buff[]=filedet.getBytes();
				 FileOutputStream fos = new FileOutputStream(image);
				 BufferedOutputStream bs = new BufferedOutputStream(fos);
				 bs.write(buff);
				 bs.close();
			 }
			 catch(Exception e){
				 
				 m.addAttribute("errorInfo","Exception Occured during image Uploading :" + e.getMessage());
				 
			 }
		 }
		 else {
			 m.addAttribute("errorinfo", "problem Occured during Image Uploading :");
	}

	 
	 List<Product> listProduct = productDAO.listproduct();
	 m.addAttribute("productList",listProduct);
	 
	 return "Product";
	}
  
	
@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
public String updateProduct(@ModelAttribute("product") Product product, Model m)
{
	productDAO.updateProduct(product);
	
	Product product1= new Product();
	m.addAttribute(product1);
	
	 m.addAttribute("pageinfo","Manager Product");
	 m.addAttribute("categoryList" , this.getCategories());
	
	 List<Product> listProduct = productDAO.listproduct();
	 m.addAttribute("productList",listProduct);
	 
	 return "updateProduct";
	 
}

@RequestMapping(value="deleteProduct/{productId}")
public String deleteProduct(@PathVariable("productId") int productId, Model m)
{
	
	Product product = productDAO.getProduct(productId);
	productDAO.deleteProduct(product);
	
	Product product1= new Product();
	m.addAttribute(product1);
	
	 m.addAttribute("pageinfo","Manager Product");
	 m.addAttribute("categoryList" , this.getCategories());
	
	 List<Product> listProduct = productDAO.listproduct();
	 m.addAttribute("productList",listProduct);
	 
	 return "deleteProduct";
	 
}

@RequestMapping(value="editProduct/{productId}")
public String editProduct(@PathVariable("productId") int productId, Model m)
{
	

	Product product = productDAO.getProduct(productId);
	m.addAttribute(product);
	
	m.addAttribute("pageinfo","Manager Product");
	 m.addAttribute("categoryList" , this.getCategories());
	 
	 List<Product> listProduct = productDAO.listproduct();
	 m.addAttribute("productList",listProduct);
	 
	 return"updateProduct";
	 
	
}


@RequestMapping(value="/TotalProductDisplay/{productId}")
public String TotalProductDisplay(@PathVariable("productId")int productId,Model m)

{
	m.addAttribute("pageinfo","Product Info");
	Product product = productDAO.getProduct(productId);
	m.addAttribute("product",product);
	
	return "TotalProductDisplay";



}



@RequestMapping(value="/productDisplay")
public String displayAllProduct(Model m)
{
	
	m.addAttribute("pageinfo","Product Catalog");
	
	List<Product> listProduct = productDAO.listproduct();
	m.addAttribute("productList",listProduct);
	
	
	return"ProductDisplays";

}


@RequestMapping(value="/totalproductDisplay/{productId}")
public String totalProductDisplay(@PathVariable("productId") int productId, Model m)
{
	m.addAttribute("pageinfo","Product Info");
	Product product = productDAO.getProduct(productId);
	
	m.addAttribute("product", "Product");
	
	return "TotalProductDisplay";

     
}








public LinkedHashMap<Integer,String> getCategories()
{
	List<Category> listcategories = categoryDAO.listCategories();
	LinkedHashMap<Integer,String> categoryList = new LinkedHashMap<Integer,String>();
	for(Category category :listcategories)
	{
		categoryList.put(category.getCategoryId(),category.getCategoryName());
	}
		
	return categoryList;

}





}
