$.fn.fetchCartData = function() {	  
	name = $("#name").val();
    password = $("#password1").val();

	if(name == "") { /* || !form.name.value.match(/^([A-Za-z]+\s?){1,3}$/)) { */
    	$("#name").focus() ;
        $("#error").show();
        $("#error").text("Please provide valid username!");
    	return false;
	}

	if(password == "") {
    	$("#password1").focus() ;
        $("#error").show();
        $("#error").text("Please provide valid password!");
    	return false;
	} 

	$.ajax({
    	async: false,
	  	url: '/bin/obs/loginservlet',
		type: 'POST',
		data: {
			name: name,
        	password: password
		},
		complete: function(xhr, status) {
        	if (status == "success") {
        		data = JSON.parse(xhr.responseText);
                if(data != null) {
            		var expires = 1;
       				document.cookie = "customerId" + "=" + data.id + ";expires=" + expires + ";path=/";
                    succeed = true;
                }
                else {
                	$("#error").show();
        			$("#error").text("Invalid username or password!");
                    succeed = false;
                }
            }
            else {
               alert("Error");
            }
		}
	});
    return succeed;
}