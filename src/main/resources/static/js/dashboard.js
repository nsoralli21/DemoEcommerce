function GetSelected() {
	//alert("hi in getselected");
	//Reference the Table.
	var grid = document.getElementById("productTable");

	//Reference the CheckBoxes in Table.
	var checkBoxes = grid.getElementsByTagName("INPUT");
	// var message = "Id  Name                  Price\n";
	var selproduct = "";
	//Loop through the CheckBoxes.
	for (var i = 0; i < checkBoxes.length; i++) {
		if (checkBoxes[i].checked) {
			var row = checkBoxes[i].parentNode.parentNode;
			selproduct += row.cells[0].innerHTML;
			selproduct += "#" + row.cells[1].innerHTML;
			selproduct += "#" + row.cells[2].innerHTML;
			selproduct += "$";
		}
	}

	//Display selected Row data in Alert Box.
	//alert(selproduct);
	senddata(selproduct);
	function senddata(detail) {
		//	alert("in senddata="+detail);
		// PREPARE FORM DATA
		var formData = {
			productdetail: detail
		}
		//alert("in formData="+formData);
		// DO POST
		$.ajax({
			url: "/ProductService/getselectedProduct",
			type: "GET",
			data: formData,
			success: function(result) {
				console.log(result);
				if (result == "Data") {
					window.location.href = '/summary';
				} else {
					$("#statusdiv1").html("<strong>No Data</strong>");
				}
				console.log(result);
			},
			error: function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});


	}
}
function selectallcheckbox(){
	//*/alert("hinnn");*/
	 var ele=document.getElementsByName('chk');  
                for(var i=0; i<ele.length; i++){  
                    if(ele[i].type=='checkbox')  
                        ele[i].checked=true;  
                }
}
$(document).ready(function() {
	ajaxGet();
	// DO GET
	/*$('#selectallcheckboxproductlist').click(function(e) {
		$(this).closest('productTable').find('td input:checkbox').prop('checked', this.checked);
	});*/

	function ajaxGet() {
		$.ajax({
			url: "/ProductService/getProduct",
			type: "GET",
			contentType: "application/json",
			success: function(result) {
				$.each(result, function(i, product) {

					var productRow = '<tr>' + '<td>' + product.id
						+ '</td>' + '<td>' + product.name
						+ '</td>' + '<td>' +'&#x20b9 '+ product.price
						+ '</td>' + '<td>'
						+ '<input type="checkbox" class="productlistcheckbox" name="chk"/>' + '</td>'
						+ '</tr>';

					$('#productTable tbody').append(productRow);

				});

				$("#productTable tbody tr:odd").addClass("info");
				$("#productTable tbody tr:even")
					.addClass("success");
			},
			error: function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});
	}
	 
            
})
