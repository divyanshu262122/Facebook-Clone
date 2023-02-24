<%@page import="com.facebook.model.Wpost"%>
<%@page import="com.facebook.model.User"%>
<%@page import="com.facebook.model.DbHandler"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.facebook.*" %>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyFacebook</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
</head>
<body>

 <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">MyFacebook</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link " href="#">Link 3</a>
    </li>
     <li class="nav-item">
      <a class="nav-link " href="#">Link 3</a>
    </li>
  </ul>
 <div style="float: right;margin-left:auto;margin-right:0">
  <sform:form class="form-inline" action="retUser" modelAttribute="user">
     <sform:input path="name" class="form-control mr-sm-4"/>
    <input class="btn btn-success" type="submit" value="Search">
  </sform:form>
  </div>
  
</nav>

<%

	
 	ArrayList<User> getusers=(ArrayList<User>)request.getAttribute("getusers");

 	if(getusers!=null && getusers.size()!=0)
 	{
%>  
    <div class="container-fluid">
      <table class="table table-striped" style="font-size:20px;">
         <tbody>
        <%
     	for(User u:getusers)
    	{ 
     	%> <tr >
           <td> <%=u.getName()%></td>
           <td><%=u.getEmailid()%></td>
            <td style="align-items: right"><a  class="btn btn-dark" role="button" href="SendRequest?email=<%=u.getEmailid()%>">Send Request</a></td>
    		</tr>
        <%
    	}
    	%> 

	     </tbody>
 	  </table>
    </div>
<%
}

%>
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3">
       
          <table class="table table-dark table-hover"> 
          <thead>
      <tr>
        <th> <h3>Friends</h3> </th>      
      </tr>
    </thead>
    <tbody>
    <%
    ArrayList<User> friends=(ArrayList<User>)request.getAttribute("friends");
    for(User friend:friends)
    {
    %>
    <tr><td><%=friend.getName()%></td></tr>
    <%
    }
    %>
           </tbody>
  </table>

    </div>
    <div class="col-sm-6">   

      <h3>Whats on your mind </h3>
      <sform:form action="savepost" modelAttribute="wpost" >
       <sform:textarea path="p" rows="5" cols="90" name="txt_post"/> 
      <br>
      <input class="btn btn-dark" role="button" type="submit" value="Upload">
      </sform:form>
   
   <%
     ArrayList<Wpost> posts= (ArrayList<Wpost>)request.getAttribute("wposts");
     for(Wpost w:posts)
     {  
    	 %>
    	 <div class="container p-3 my-3 border">
    	 <span >
    	
    	 <h5><%=w.getName() %></h5>
    	 <font size="2"><%=w.getDop() %></font>
    	 
    	 <p class="container p-3 my-3 border">
    	 <%=w.getP() %>
    	 </p>
    	   	 
    	 </span>
    	 </div>
    	 <%
     }
     
     %>
     </div>
   <div class="col-sm-3">
     
          <table class="table table-dark table-hover"> 
          <thead>
      <tr>
        <th> <h3>Requests</h3> </th>      
      </tr>
    </thead>
    <tbody>
       <%
       ArrayList<User> requests=(ArrayList<User>)request.getAttribute("f_requests");
       if(requests!=null && requests.size()!=0)
       {
    	   for(User u:requests)
       {
    	   %>
    	   	<tr ><td style="font-size:20px;">   <%=u.getName() %></td>
    	   	<td> <a  class="btn btn-light" role="button" href="Accept?fid=<%=u.getEmailid()%>">Accept</a></td>
    	   	</tr>
    	   <%
       }
       }
       %>
       
        </tbody>
        </table>

       
    </div>
       
       
  </div>
</div>

</body>
</html>