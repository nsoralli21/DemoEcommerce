<!DOCTYPE HTML>
 
<html>
<head>
	  <title>E-Commerce</title>
	  <meta charset="utf-8" />
	  <meta name="viewport" content="width=device-width, initial-scale=1" />
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#loginform").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		username : $("#username").val(),
    		password :  $("#password").val()
    	}
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "LoginService/login",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				alert("result.ststus="+result.status);
				if(result.status == "OK"){
					$("#statusdiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Login Success");
				}else{
					$("#statusdiv").html("<strong>Login Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    function resetData(){
    	$("#username").val("");
    	$("#password").val("");
    }
})

</script>	  
</head>
<body>
 
<div class="container">
 
	<h3 style="color:blue">POST-GET AJAX Example</h3>
	
	<div>
		<form class="form-inline" style="margin:20px 20px 20px 20px" id="loginform">
			<div class="form-group">
				<label for="firstname" style="margin-right:5px">UserName:</label>
				<input type="text" class="form-control" id="username" placeholder="Enter UserName"/>
			</div>
			<div class="form-group">
				<label for="lastname" style="margin-left:20px; margin-right:5px">Password:</label>
				<input type="text" class="form-control" id="password" placeholder="Enter Password"/>
			</div>
			<button type="submit" class="btn btn-default" style="margin-left:20px; margin-right:5px">Submit</button>
		</form>
	</div>
	
	<div class="col-sm-7" id="statusdiv">
	</div>
	
	<!-- <div class="col-sm-7" style="margin:20px 0px 20px 0px">
		<button id="getAllCustomerId" type="button" class="btn btn-primary">Get All Customers</button>
		<div id="getResultDiv" style="padding:20px 10px 20px 50px">
	        <ul class="list-group">
	    	</ul>
    	</div>
	</div> -->
	
</div>
</body>
</html>