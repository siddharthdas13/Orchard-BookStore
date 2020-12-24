$(document).ready(function(){
	deleteCookie('customObject');
});
function setCookie(name, filter) {
	var customObject = {};
	customObject.first = name;
	customObject.second = filter;

	var jsonString = JSON.stringify(customObject);
	document.cookie = "customObject=" + jsonString;
}
function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ')
			c = c.substring(1, c.length);
		if (c.indexOf(nameEQ) == 0)
			return c.substring(nameEQ.length, c.length);
	}
	return null;
}
function deleteCookie(name){
	document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
}
function getFilteredBook(name, filter) {
	
	if (filter.localeCompare("all")==0){
		url = "/bin/FilterBookServlet?first=" + name + "&second=" + filter;
		deleteCookie('customObject');
	}
	if (filter.localeCompare("all")!=0) {
		var json = readCookie('customObject');
		var customObject = JSON.parse(json);
		setCookie(name, filter);
		if ((customObject) === null) {
			url = "/bin/FilterBookServlet?first=" + name + "&second=" + filter;
		} else if ((customObject.first).localeCompare("genre")
				&& (name.localeCompare("genre"))) {
			url = "/bin/FilterBookServlet?first=" + name + "&second=" + filter;
		} else if ((customObject.first).localeCompare("publisher")
				&& (name.localeCompare("publisher"))) {
			url = "/bin/FilterBookServlet?first=" + name + "&second=" + filter;
		} else if (name.localeCompare("genre")) {
			url = "/bin/FilterBookServlet?first=" + customObject.second
					+ "&second=" + filter;
		} else if (name.localeCompare("publisher")) {
			url = "/bin/FilterBookServlet?first=" + filter + "&second="
					+ customObject.second;
		}
	}
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			data = JSON.parse(this.responseText);
			generateTiles(data);
		}
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}
function generateTiles(data) {
	var html = '<section id="products">';
	for (x in data) {

		html += [
				'<section class="product-tile">',
				'<div class="product-block">',
				'<div class="image-block">',
				'<div class="product-image">',
				'<img src="/content/dam/BookStore/en/images/books/abc.jpg>',
				'</div>',
				'<div class="hover-block">',
				'<a href="http://www.google.com"><button class="add-to-cart" target="_blank">ADD TO CART</button></a>',
				'<a href="http://www.google.com"><button class="view-detail">VIEW DETAILS</button></a>',
				'</div>',
				'<div class="bestseller-label">',
				'<img src="https://www.sapnaonline.com/static/images/sapna/bestseller.svg">',
				'</div>', '<div class="discount-label">', '<label>30%</label>',
				'</div>', '</div>', '<div class="product-detail">',
				'<div class="book-name"><b>', data[x].name, '</b></div>',
				'<div class="hover-product-detail">',
				'<label class="creator"><i>by', data[x].authors,
				'</i></label>', '<br>', '<label><b>Language</b></label>',
				'<label class="language"><i>', data[x].language,
				'</i></label>', '</div>', '<div class="price">&#8377;',
				data[x].price, '/-</div>', '</div>',
				'<div class="new-product-label">', '<label>New</label>',
				'</div>', '</div>', '</section>' ].join("\n");
	}
	html += '</section>';
	document.getElementById("ab").innerHTML = html;
}