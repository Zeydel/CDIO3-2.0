/**
 * 
 */
$(document).ready(function(){
	$('#mainContainer').show();
	
	$('#LoginContainer').submit(function(){
		event.preventDefault();
		$('#mainContainer').load('adminContainer.html');
		loadUsers()
	})
	
	$('#adminCon').submit(function(){
		event.preventDefault();
		$('#mainContainer').load('CreateUser.html');
		loadUsers()
	})
	
	$('#confirmCreateUser').click(function(){
		event.preventDefault();
		createUser();
		$('#mainContainer').load('adminContainer.html');
	})

	function createUser(){
		event.preventDefault();
		$.ajax({
			url : 'rest/user',
			type : 'POST',
			data: ('#createUserForm').serializeJSON,
			contentType : ("application/json"),
			success : function(data){
				alert(HEJ)
			}
		})
		$('#mainContainer').load('adminContainer.html');
	}
	
	function loadUsers(){
		event.preventDefault();
		$.ajax({
			url : 'rest/user',
			type : 'GET',
			success : function(){
				$.each(json, function(i, el){
					$('#userTableBody').append(el)
				})
				
			}
		})
	}
	
	
	$('#cancel').click(function(){
		event.preventDefault();
		$('#mainContainer').load('adminContainer.html');
	})
	
	function generateHTML(json){
		var html = '<tr>'
		$.each(json, function(i, elt) {
			html += '<td>' + elt + '</td>';
		});
		return html += '</tr>'
	}
	
	function generateUserHTML(UserDTO) {
		return '<tr><td>' + UserDTO.userId + '</td>' +
				'<td>' + UserDTO.userName + '</td>' +
				'<td>' + UserDTO.ini + '</td>' + 
				'<td>' + UserDTO.roles + '</td>' +
				'<td>' + UserDTO.password + '</td>' +
				'<td>' + UserDTO.cpr + '</td>' + '</tr>';
	}
	
	
})

/*	function form_validate(){
		//alert("function is there");
		var e = 0;
		if(isEmpty("username", "Please type in your username", "err_username_msg"))
		{
			//alert("1");
			e++;
		}
		if(isEmpty("psw", "Please type in your password", "err_password_msg"))
		{
			//alert("2");
			e++;
		}
		if(isEmpty("psw-repeat", "Please confirm password", "err_passwordrepeat_msg"))
		{
			//alert("3");
			e++;
		}
		if(isEmpty("CPR", "Please type in your CPR", "err_CPR_msg"))
		{
			//alert("4");
			e++;
		}
		if(isEmpty("Roles", "Please type in your roles", "err_roles_msg"))
		{
			alert("5");
			e++;
		}
		
		
		alert("right before end");
		if(e > 0) {
			alert("Please fill login details");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	function isEmpty(field, message, error_field){
			var r = document.getElementById(field);
			var error_field = document.getElementById(error_field);
			if(r.value.replace(/\s+$/, "") == "")
			{
				error_field.innerHTML = message;
				r.value = "";
				r.focus();
				return true;
			}
			else
			{
				error_field.innerHTML = "";
				return false;
			}
	}


	function checkPassword() {
		var pass = document.getElementById('psw').value;
		var con_pass = document.getElementById('psw_repeat').value;
		if (pass === con_pass){
			document.getElementById('err_passwordrepeat_msg').innerHTML = '';
			return true;
		} else {
			document.getElementById('err_passwordrepeat_msg').innerHTML = 'Password matcher ikke';
			return false;
		}
	}

	function validate_login(){
		//alert("function is there");
		var e = 0;
		if(isEmpty("fname", "Please type in your username", "err_username_msg"))
		{
			//alert("1");
			e++;
		}
		if(isEmpty("user_password", "Please type in your password", "err_password_msg"))
		{
			//alert("2");
			e++;
		}
		else
		{
			return true;
		}
	}*/
