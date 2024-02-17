package eCommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ECommerce.DAO.CartDAO;
import ECommerce.DAO.OrderDAO;
import ECommerce.DAO.ProductDAO;
import ECommerce.DAO.UserDAO;
import ECommerce.model.CartItem;
import ECommerce.model.OrderDetail;
import ECommerce.model.UserDetail;

@Controller

public class PaymentController {

	@Autowired
    CartDAO cartDAO;
	
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping("/checkout")
	public String checkOut(Model m, HttpSession session )
	{
		String username=(String) session.getAttribute("username");
		List<CartItem> cartItemList=cartDAO.listCartItem(username);
		
		m.addAttribute("cartItemList",cartItemList);
		m.addAttribute("garndTotal", this.getGrandTotal(cartItemList));
		
		UserDetail userDetail=userDAO.getUser(username);
		
		String address=userDetail.getCustomerAddr();
		m.addAttribute("addr", address);
		
		return "OrderConfirm";
		
	}
	
	@RequestMapping(value="/UpdateAddr",method=RequestMethod.POST)
	public String UpdateAddr(@RequestParam("addr") String addr, Model m,HttpSession session)
	{
		String username=(String) session.getAttribute("username");
		List<CartItem> cartItemList=cartDAO.listCartItem(username);
		
		m.addAttribute("cartIemList",cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		UserDetail userdetail=userDAO.getUser(username);
		userdetail.setCustomerAddr(addr);
		
		userDAO.updateuser(userdetail);
		
		
		String address=userdetail.getCustomerAddr();
		m.addAttribute("addr", address);
		
		return "OrderConfirm";
	}
	
	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String generateReceipt(@RequestParam("rd")String rd,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setShippingAddr(userDAO.getUser(username).getCustomerAddr());
		orderDetail.setTrans(rd);
		orderDetail.setUsername(username);
		
		List<CartItem> cartItemList=cartDAO.listCartItem(username);
		
		m.addAttribute("cartIemList",cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		

		UserDetail userdetail=userDAO.getUser(username);
		userdetail.setTotalAmount(this.getGrandTotal(cartItemList));
		
		orderDAO.saveOrder(orderDetail);
		orderDAO.updateCart(username);
		
		m.addAttribute("orderDetail",orderDetail);
		
		return "Recepit";
		
	}
	
	
	
	
	@RequestMapping(value="/payment")
	
	public String paymentPage(Model m,HttpSession session)
	{
		return "Payment";
		
	}
	 public int getGrandTotal(List<CartItem> cartList)
	 {
		
		 int grandTotal=0, count=0;
		 while(count<cartList.size())
		 {
			 grandTotal=grandTotal+(cartList.get(count).getQuantity()*cartList.get(count).getPrice());
			 count++;
			 
		 }
		 
		 
		 return grandTotal;
		 
	 }
	
	
	
}
