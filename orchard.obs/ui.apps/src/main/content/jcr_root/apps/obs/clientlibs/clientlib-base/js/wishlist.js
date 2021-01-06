$(function() {
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

    if(customerId != null) {
    	$(this).fetchWishlistData(customerId);
    }
    else {
        $("#message-block").show();
        $("#close").hide();
		$("#message-block").css("background-color", "red");
        $("#message").text("Please Login!...");
    }
});

$.fn.fetchWishlistData = function(customerId) {
	$.ajax({
		url: '/bin/obs/wishlistservlet',
		type: 'POST',
        data: {
        	customerId: customerId,
            action: "getwishlistdata"
        },
		complete: function(xhr, status) {
        	if (status == "success") {
            	wishlistData = JSON.parse(xhr.responseText);
                $(this).loadWishlistData(wishlistData, customerId);
            }
            else {
            	$("#message-block").show();
                $("#message-block").css("background-color", "red");
            	$("#message").text("something went wrong");
            }
		}
    });
}

$.fn.addToCart = function(index, customerId) {
	var obj = this;
    if($(this).text() == "ADD TO CART") {
		$.ajax({
			url: '/bin/obs/wishlistservlet',
			type: 'POST',
			data: {
				bookId: (wishlistData[index].book).id,
                customerId: customerId,
                action: "addtocart"
			},
		 	complete: function(xhr, status) {
            	if (status == "success") {
                	if(xhr.responseText > 0) {
                    	$("#message-block").show();
                		$("#message-block").css("background-color", "green");
            			$("#message").text("Successfully Added To Cart");
                        $(obj).text("GO TO CART");
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

$.fn.removeWishlistItem = function(index, customerId) {
	$.ajax({
		url: '/bin/obs/wishlistservlet',
		type: 'POST',
		data: {
			bookId: (wishlistData[index].book).id,
            customerId: customerId,
            action: "removeitem"
		},
		complete: function(xhr, status) {
            if (status == "success") {
                if(xhr.responseText > 0) {
					wishlistData.splice(index, 1);
                    $(this).loadWishlistData(wishlistData, customerId);
            	}
         	}
           	else {
            	$("#message-block").show();
                $("#message-block").css("background-color", "red");
            	$("#message").text("Failed To Remove Book From Wishlist");
          	}
		 }
	});
}

$.fn.loadWishlistData = function(wishlistData, customerId) {
   	$("#cart-block").empty();
	if(wishlistData.length != 0) {
        $(".modal").css("display", "block");
        var totalPrice = 0, totalDiscount = 0, deliveryCharge = 0, totalAmount = 0, totalAmountSaved = 0;
        var cartBlock = [
            '<div id="header">',
                '<div id="label">My Wishlist (' + wishlistData.length + ')</div>',
           	'</div>'
		].join("\n");
		$("#cart-block").append(cartBlock);

		$.each(wishlistData, function(index, item) {
        	book = item.book;
			discountPrice = (((100-book.discount)/100)*book.price*item.cartQuantity);
           	actualPrice = (book.price*item.cartQuantity);

			var Item_Block = [
				'<div class="item-block">',
                    '<div class="item-block-first-div">',
                        '<div class="item-image-block">',
                            '<img src="/content/dam/obs/en/images/books/' + book.name + '.jpg">',
                        '</div>',
                        '<div class="item-detail-block">',
                        	'<div class="item-name">' + book.name + '</div>',
                            '<div class="language">' + book.language + '</div>',
                            '<div class="item-price">',
                            	'<div class="discount-price">₹' + discountPrice + '</div>',
                                '<div class="actual-price"><s>₹' + actualPrice + '</s></div>',
                                '<div class="discount">' + book.discount + '% Off</div>',
                           	'</div>',
                            '<div class="item-save-remove">',
                            	'<div class="item-save-later" onclick="$(this).addToCart(' + index + ',\'' + customerId + '\')">ADD TO CART</div>',
                                '<div class="item-remove" onclick="$(this).removeWishlistItem(' + index + ',\'' + customerId + '\')">REMOVE</div>',
                            '</div>',
                    	'</div>',
                       	'<div class="delivery-detail-block">',
                        	'<div class="delivery-detail">Delivery in 3 - 5 days | ₹66</div>',
                          	'<div class="replacement-policy">7 Days Replacement Policy</div>',
                       	'</div>',
                 	'</div>',
               	'</div>'
			].join("\n");
           	$("#cart-block").append(Item_Block);

          	if(item.cartQuantity > 1) {
            	$("#m"+index).prop("disabled", false);
           	}
           	else {
            	$("#m"+index).prop("disabled", true);
          	}

           	if(book.discount == 0) {
           		$(".discount").hide();
               	$(".actual-price").hide();
          	}

           	if(book.isPresentInCart) {
            	$(".item-save-later").text("GO TO CART");
           	}
        });
	}
	else
    	$("#cart-block").html("<h3>Wishlist Is Empty!...</h3>");
}