<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Index page</title>
</head>
<body>

<div class="jumbotron "  style="background-color:blue; color:white" >
<h1>MyFacebook</h1><br/>
<p>MyFacebook helps you connect and share with the people in your life.</p>


</div>

<div class="container">

  <div class="row">
    <div class="col-sm-4">
    </div>
   
    <div class="col-sm-4">
      <h3>SignUp</h3>
       <sform:form action="signUp" modelAttribute="user">
  	    <div class="form-group">
         <label for="emailid">Email:</label>
  			<sform:input path="emailid" type="text" class="form-control" id="emailid" name="emailid"/>
		</div>
		<div class="form-group">
		  <label for="password">Password:</label>
  			<sform:input path="password" type="password" class="form-control" id="password" name="password"/>
		</div>
		<div class="form-group">
		  <label for="name">Name:</label>
  			<sform:input path="name" type="text" class="form-control" id="name" name="name"/>
		</div>
		<div class="form-group">
		  <label for="pno">Mobile No.:</label>
  			<sform:input path="pno" type="text" class="form-control" id="pno" name="pno"/>
		</div>
		<div class="form-group">
		  <label for="gender">Select Gender:</label>
		  <sform:select path="gender" class="form-control" id="gender" name="gender" size=1>
		    <sform:option value="male">Male</sform:option>
		    <sform:option value="female">Female</sform:option>
		    <sform:option value="others">Others</sform:option>
		  </sform:select>
		</div>
		<div class="form-group">
		  <button type="submit" class="btn btn-primary"> SignUp </button>
		</div>
		
		
      </sform:form>
    </div>
     <div class="col-sm-4">
    </div>
   
  </div>
</div>
</body>
</html>