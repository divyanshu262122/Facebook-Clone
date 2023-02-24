package com.facebook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.facebook.model.DbHandler;
import com.facebook.model.User;
import com.facebook.model.Wpost;

@Controller
public class MainController {
   DbHandler db=new DbHandler();
	@GetMapping(value="/")
	public ModelAndView index()
	{
		
		ModelAndView modelandview=new ModelAndView("index");
		User user=new User();
		modelandview.addObject("user", user);
		return modelandview;
	}
	
	@PostMapping(value="/login")
	public ModelAndView login(User user,HttpServletRequest request)
	{
		
	   boolean b= db.login(user);
	   if(b==true)
	   {   
		   ArrayList<User> friends=db.getFriends(user);
		   ArrayList<User> f_requests=db.getf_requests(user);
		   ArrayList<Wpost> wposts=db.getWposts(user);
		   Wpost wpost= new Wpost();
		   ModelAndView modelandview=new ModelAndView("welcome");
		   modelandview.addObject("wpost", wpost);
		   modelandview.addObject("wposts", wposts);
		   modelandview.addObject("user", user);
		   modelandview.addObject("f_requests", f_requests);
		   modelandview.addObject("friends", friends);
		   request.getSession().setAttribute("session_user",user);//remains until you close your session
		   return modelandview;

	   }
	   else
	   {
		   ModelAndView modelandview=new ModelAndView("index");
		   return modelandview;
	   }
	}
	
	@GetMapping(value="/welcome")
	public ModelAndView welcome(HttpServletRequest request,Model model)
	{
		  User user=(User)request.getSession().getAttribute("session_user");
	      ArrayList<User> friends=db.getFriends(user);	
	      ArrayList<User> f_requests=db.getf_requests(user);
		  ArrayList<Wpost> wposts=db.getWposts(user);
	      Wpost wpost=new Wpost();
		   ModelAndView modelandview=new ModelAndView("welcome");
		   ArrayList<User> getUsers = (ArrayList<User>)model.asMap().get("getUser");
		   modelandview.addObject("f_requests", f_requests);
		   modelandview.addObject("getUsers",getUsers);
		   modelandview.addObject("wpost", wpost);
		   modelandview.addObject("wposts", wposts);
		   modelandview.addObject("user", user);
		   modelandview.addObject("friends", friends);		   
	    	return modelandview;

	  
	}
	
	@PostMapping(value="/signUp")
	public ModelAndView signUp(User user)
	{   
		boolean b=db.signUp(user);
		
		if(b==true)
		{
		ModelAndView modelandview=new ModelAndView("index");
		return modelandview;
		}
		else
		{
			ModelAndView modelandview=new ModelAndView("signUp");
			return modelandview;
		}
	}
	
	@PostMapping(value="/retUser")
	public ModelAndView retUser(User user,HttpServletRequest request,RedirectAttributes redirectAttributes)
	{   
			
		ArrayList<User> getusers=db.getUsers(user);
		ModelAndView modelandview=new ModelAndView("redirect:/welcome");
		redirectAttributes.addFlashAttribute("getusers", getusers);
		return modelandview;
	}
	
	
	@PostMapping(value="/savepost")
	public ModelAndView savepost(@ModelAttribute("wpost") Wpost wpost,HttpServletRequest request)
	{
		User suser=(User)request.getSession().getAttribute("session_user");
		db.savePost(suser,wpost);
		ModelAndView modelandview=new ModelAndView("redirect:/welcome");
		return modelandview;
	}

	
	@PostMapping(value="SendRequest")
	public ModelAndView sendRequest(String emailid,HttpServletRequest request)
	{   System.out.println(emailid);
		User suser=(User)request.getSession().getAttribute("session_user");
		db.sendrequest(emailid,suser.getEmailid());
		ModelAndView modelandview=new ModelAndView("redirect:/welcome");
		return modelandview; 
		
	}
	
}
