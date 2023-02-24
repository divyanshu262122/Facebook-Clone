package com.facebook.model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DbHandler {
	
	// function for login
	public boolean login(User user)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
		Session session =factory.getCurrentSession();
		session.beginTransaction();
		User u=session.get(User.class,user.getEmailid());
		session.close();
		if(u==null)
			return false;
		else 
		{
			if(u.getPassword().equals(user.getPassword()))
			
				return true;
			else
				return false;
		}
	}
	
	// function for user to signUp
	public boolean signUp(User user)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
		Session session =factory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.beginTransaction().commit();
		session.close();
		return true; 
		
	}
	
	// function return the list of friends
	public ArrayList<User> getFriends(User user)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Friend.class).addAnnotatedClass(User.class).buildSessionFactory();
		Session session =factory.getCurrentSession();
		session.beginTransaction();
	  	ArrayList<Friend> myfriends=(ArrayList<Friend>)session.createQuery("from " +Friend.class.getName()+" where (sender='"+user.getEmailid()+"' or rec='"+user.getEmailid()+"') and status=1 ").getResultList();
		session.close();
		ArrayList<User> friends=new ArrayList<User>();
		for(Friend friend:myfriends)
		{   String sender=friend.getSender();
			String receiver=friend.getRec();
			if(sender.equals(user.getEmailid()))
			{   User u=getUser(receiver);
				friends.add(u);
			}
			else
			{   User u=getUser(sender);
				friends.add(u);
			}
		 	
		}
		return friends;
	}
	
	
	//funtion to return the user by searching with emailid
		public User getUser(String emailid)
		{   
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
			Session session =factory.getCurrentSession();
			session.beginTransaction();
			User u=session.get(User.class, emailid);
			session.close();
			return u;	
		}
		
	//function to return the user name by emailid
		public String getName(String emailid)
		{

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
			Session session =factory.getCurrentSession();
			session.beginTransaction();
			User u=session.get(User.class, emailid);
			session.close();
			return u.getName();	
		}
	
	//funtion to return the list of user on searching
	public ArrayList<User> getUsers(User user)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
		Session session =factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("name="+user.getName());
		ArrayList<User> users=(ArrayList<User>)session.createQuery("from user where name like '"+user.getName()+"%'").getResultList();
		System.out.println("size ="+users.size());
		session.close();
		return users;	
	}
	
	// function to save the post in database
	public void savePost(User suser,Wpost wpost)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Wpost.class).buildSessionFactory();
		Session session =factory.getCurrentSession();
		session.beginTransaction();
		Wpost w=new Wpost();
		w.setSender(suser.getEmailid());
		w.setP(wpost.getP());
		w.setDop(new java.util.Date().toString());
		w.setName(getName(suser.getEmailid()));
		session.save(w);
		session.getTransaction().commit();
		session.close();
	}
	
	// function to get the post form database
		public ArrayList<Wpost> getWposts(User suser)
		{
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Wpost.class).buildSessionFactory();
			Session session =factory.getCurrentSession();
			session.beginTransaction();
			ArrayList<Wpost> posts=(ArrayList<Wpost>)session.createQuery("from "+Wpost.class.getName()).getResultList();
			session.close();
			return posts;
		}
		
		
	// function to return friend requests 
		public ArrayList<User> getf_requests(User user)
		{   ArrayList<User> f_requests=new ArrayList<>();
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Friend.class).buildSessionFactory();
			Session session =factory.getCurrentSession();
			session.beginTransaction();
			ArrayList<Friend> requests=(ArrayList<Friend>)session.createQuery("from "+Friend.class.getName()+" where rec='"+user.getEmailid()+"' and status=0 order by fid desc").getResultList();
			session.close();
			for(Friend r:requests)
			{
				String emailid=r.getSender();
				String name=getName(emailid);
				User u= new User();
				u.setEmailid(emailid);
				u.setName(name);
				f_requests.add(u);
			}
			return f_requests;
		}
		
	// function to send request
		public void sendrequest(String rec,String sender)
		{
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Friend.class).buildSessionFactory();
			Session session =factory.getCurrentSession();
			session.beginTransaction();
			Friend f=new Friend();
			f.setSender(sender);
			f.setRec(rec);
			f.setStatus(0);
			f.setDor(new java.util.Date().toString());
			session.save(f);
			session.getTransaction().commit();
			session.close();

		}
		
}
