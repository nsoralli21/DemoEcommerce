$('document').ready(function(){
        	getselectedproduct();
			function getselectedproduct() {
				$.ajax({
					url : "/ProductService/getProductsummary",
					type : "GET",
					contentType : "application/json",
					success : function(result) {
						$.each(result, function(i, product) {

							var productRow = '<tr>' + '<th>' + product.id
									+ '</th>' + '<th>' + product.name
									+ '</th>'+'<th>' + ""+ '</th>' + '<th>' +'&#x20b9 '+ product.price+ '</th>'
									+ '</tr>';

							$('#productTable tbody').append(productRow);
							document.getElementById("totalitem").innerHTML = product.itemcount;
							document.getElementById("totalvalue").innerHTML = product.totprice;

						});
						/*$("#productTable tbody tr:odd").addClass("info");
						$("#productTable tbody tr:even")
								.addClass("success");*/
					},
					error : function(e) {
						alert("ERROR: ", e);
						console.log("ERROR: ", e);
					}
				});
			}
        });
