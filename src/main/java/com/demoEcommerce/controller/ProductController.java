package com.demoEcommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoEcommerce.dao.Product;

@RestController
@RequestMapping(value = "/ProductService")
public class ProductController {
	@GetMapping("/")
	public String getDefault(Map<String,Object> message) {
		
		message.put("message", "Hello world!");
		return "welcome";
	}
	
	@RequestMapping(value= "/getProduct", method = RequestMethod.GET)
	public List<Product> getProductDetails(){
		
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product(1,"iPhone 5s",24500));
		productList.add(new Product(2,"iPhone 12s",670000));
		productList.add(new Product(3,"iPhone SE",670000));
		
		return productList;
	}
	@RequestMapping(value="/getselectedProduct", method = RequestMethod.GET)
	public ResponseEntity<String> getselectedProductDetails(ModelMap model,@RequestParam(name="productdetail",required=true)String selproduct,HttpSession session) {
		    String selectedproduct=selproduct;
		    List<Product> productList = new ArrayList<Product>();
		    System.out.println("selectedproduct="+selectedproduct);
		    if(selectedproduct.length()>0) {
		    	StringTokenizer st=new StringTokenizer(selectedproduct, "$");
		    	while(st.hasMoreElements()) {
		    		String selsubproduct=st.nextToken();
		    		StringTokenizer subst=new StringTokenizer(selsubproduct, "#");
		    		while(subst.hasMoreElements()) {
		    			Long id=Long.parseLong(subst.nextToken());
		    			String name=subst.nextToken();
		    			String price=(subst.nextToken());
		    			price=price.substring(price.indexOf(" ")+1);
		    			double prprice=Double.parseDouble(price);
		    			productList.add(new Product(id,name,prprice));
		    		}
		    	}
		    	session.setAttribute("selectedproductlist",productList);
		    	return new ResponseEntity<String>("Data", HttpStatus.OK);
		    }
		    else {
		    	return new ResponseEntity<String>("No Data", HttpStatus.OK);	
		    }
			
	}
	@RequestMapping(value= "/getProductsummary", method = RequestMethod.GET)
	public List<Product> getselectedsummaryProductDetails(HttpSession session){
		List<Product> prlist=new ArrayList<Product>(); 
		@SuppressWarnings("unchecked")
		List<Product> productList = (List<Product>) session.getAttribute("selectedproductlist");//new ArrayList<Product>();
		System.out.println("productList size="+productList.size());
		int prodcount=productList.size();
		double totamount=0;
		for(Product price:productList) {
			totamount+=price.getPrice();
		}
		for(Product P:productList) {
			Product p=new Product();
			p.setId(P.getId());
			p.setName(P.getName());
			p.setPrice(P.getPrice());
			p.setItemcount(prodcount);
			p.setTotprice(totamount);
			prlist.add(p);
		}
		return prlist;
	}
}
