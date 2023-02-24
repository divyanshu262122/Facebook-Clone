<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>MyFacebook</title>
</head>
<body>

<div class="jumbotron "  style="background-color:rgb(78,78,78); color:white" >
<h1>MyFacebook</h1><br/>
<p>MyFacebook helps you connect and share with the people in your life.</p>


</div>

<div class="container">

  <div class="row">
    <div class="col-sm-4">
    </div>
   
    <div class="col-sm-4">
      <h3>Login</h3>
      <sform:form action="login" modelAttribute="user">
  	    <div class="form-group">
         <label for="emailid">Email:</label>
            <sform:input path="emailid" type="text" class="form-control" id="emailid" name="emailid"/>
  			
		</div>
		<div class="form-group">
		  <label for="password">Password:</label>
		  <sform:input path="password" type="password" class="form-control" id="password" name="password"/>
  			
  			
		</div>
		<div class="form-group">
		  <button type="submit" class="btn btn-primary"> Login </button>
		</div>
		
		
		  </sform:form>
		<div class="form-group">
		 <a href="signUp.jsp">New User?</a>
		</div>
		
    
    </div>
     <div class="col-sm-4">
    </div>
   
  </div>
</div>

</body>
</html>