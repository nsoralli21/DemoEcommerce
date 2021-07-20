function toggleResetPswd(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle() // display:block or none
    $('#logreg-forms .form-reset').toggle() // display:block or none
}
function toggleForgotPswd(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle() // display:block or none
    $('#logreg-forms .form-forgot').toggle() // display:block or none
}

function toggleSignUp(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle(); // display:block or none
    $('#logreg-forms .form-signup').toggle(); // display:block or none
}

$(()=>{
    // Login Register Form
    $('#logreg-forms #forgot_pswd').click(toggleForgotPswd);
    $('#logreg-forms #cancel_forgot').click(toggleForgotPswd);
    $('#logreg-forms #reset_pswd').click(toggleResetPswd);
    $('#logreg-forms #cancel_reset').click(toggleResetPswd);
    $('#logreg-forms #btn-signup').click(toggleSignUp);
    $('#logreg-forms #cancel_signup').click(toggleSignUp);
})
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
    		url : "/login",
			type : "POST",
			contentType : "application/json",
			data : JSON.stringify(formData),
			success : function(result) {
				console.log(result);
				if(result == "Login Success"){
					window.location.href='/dashboard';
				}else{
					$("#statusdiv").html("<strong>Login Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				$("#statusdiv").html("<strong>Login Error</strong>");
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
