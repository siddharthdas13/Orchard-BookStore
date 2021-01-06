$(function() {
	const params = new URLSearchParams(window.location.search);
	bookId = params.get('bookId');

	if(bookId != null) {

		var customerId = null;
		var name = "customerId" + "=";
    	var ca = document.cookie.split(';');

  		for(var i = 0; i < ca.length; i++) {
    		var c = ca[i];
    		while (c.charAt(0) == ' ') {
      			c = c.substring(1);
    		}
    		if (c.indexOf(name) == 0) {
      			customerId = c.substring(name.length, c.length);
    		}
  		}

		$.ajax({
			url: '/bin/obs/bookservlet',
			type: 'POST',
        	data: {
        		bookId: bookId,
				customerId: customerId,
            	action: "getbookdata"
        	},
			complete: function(xhr, status) {
        		if (status == "success" && xhr.responseText.trim() != "null") {
            		bookData = JSON.parse(xhr.responseText);
                    $("#book-image").attr("src", "/content/dam/obs/en/images/books/" + bookData.name + ".jpg");
                	$(".product-name").text(bookData.name);
                	$(".product-language").text(bookData.language);
                	$(".actual-price").html("<s>₹" + bookData.price + "</s>");
                	$(".discount").text(bookData.discount + "% Off");
                	$(".discount-price").text("₹" + ((100-bookData.discount)/100)*bookData.price);
                	$("#author-value").text(bookData.author);
                	$("#language").text("Language : " + bookData.language);
                	$("#publisher").text("Publisher : " + bookData.publisher);
                	$("#genre").text("Genre : " + bookData.genre);
                	$("#isbn").text("ISBN : " + bookData.isbn);
					$("#pages").text("Pages : " + bookData.pageCount);
                	$("#description-value").text(bookData.description);

                    if(bookData.isPresentInCart) {
                    	$("#add-to-cart").text("GO TO CART");
                    }
           		}
            	else {
            		alert("Error");

            	}
			}
		});

    	$("#add-to-cart").click(function() {
        	if(customerId != null) {
            	if($("#add-to-cart").text() == "ADD TO CART") {
					$.ajax({
						url: '/bin/obs/bookservlet',
						type: 'POST',
						data: {
							bookId: bookData.id,
                			customerId: customerId,
                			action: "addtocart"
						},
		 				complete: function(xhr, status) {
            				if (status == "success") {
                				if(xhr.responseText > 0) {
                                	$("#message-block").show();
                					$("#message-block").css("background-color", "green");
            						$("#message").text("Successfully Added To Cart");
                                    $("#add-to-cart").text("GO TO CART");
                   				}
               				}
                			else {
                            	$("#message-block").show();
                				$("#message-block").css("background-color", "red");
            					$("#message").text("Failed To Add Book To Cart");
                			}
		 				}
					});
                }
                else {
					window.location = "cart.html";
                }
            }
            else {
            	$("#message-block").show();
                $("#message-block").css("background-color", "red");
            	$("#message").text("Please Login To Add Book To Cart!...");
            }
		});

		/* $("#add-to-cart").click(function() {
        	if(customerId != null) {
            	if($("#add-to-cart").text() == "ADD TO CART") {
					$.ajax({
						url: '/bin/obs/bookservlet',
						type: 'POST',
						data: {
							bookId: bookData.id,
                			customerId: customerId,
                			action: "addtocart"
						},
		 				complete: function(xhr, status) {
            				if (status == "success") {
                				if(xhr.responseText > 0) {
                                	$("#message-block").show();
                					$("#message-block").css("background-color", "green");
            						$("#message").text("Successfully Added To Cart");
                                    $("#add-to-cart").text("GO TO CART");
                   				}
               				}
                			else {
                            	$("#message-block").show();
                				$("#message-block").css("background-color", "red");
            					$("#message").text("Failed To Add Book To Cart");
                			}
		 				}
					});
                }
                else {
					window.location = "cart.html";
                }
            }
            else {
            	$("#message-block").show();
                $("#message-block").css("background-color", "red");
            	$("#message").text("Please Login To Add Book To Cart!...");
            }
		}); */

    	$("#buy-now").click(function() {
        	if(customerId != null) {
				alert("Buy Now");
            }
            else {
                $("#message-block").show();
                $("#message-block").css("background-color", "red");
            	$("#message").text("Please Login To Buy Book!...");
            }
		});

        $("#message-block").click(function() {
        	$(this).hide();
        });
	}
    else {
    	$("#message-block").show();
        $("#close").hide();
        $("#product-desc").hide();
    	$("#message").text("No Page Found...");
    }
});