function validate(){
	
var name=document.getElementById('name').value;
var password=document.getElementById('password').value;
var uname=document.getElementById('uname').value;
var dob=document.getElementById("db").value;
var country=document.getElementById('countryId').value;
var state=document.getElementById('stateId').value;
var city=document.getElementById('cityId').value;
var address=document.getElementById('textarea').value;
var pin=document.getElementById('pn').value;
var gender=document.getElementById('g').value;
var phone=document.getElementById('phn').value;
var mail=document.getElementById('m').value;
var data="name="+name+"&password="+password+"&uname="+uname+"&dob="+dob+"&country="+country+"&state="+state+"&city="+city+"&address="+address+
"&pin="+pin+"&gender="+gender+"&phone="+phone+"&mail="+mail;


var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
   if (this.readyState == 4 && this.status == 200) {
     // Response
     alert(this.responseText);
   }
};
xhttp.open("POST", "/bin/Register", true); 
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhttp.send(data);
}