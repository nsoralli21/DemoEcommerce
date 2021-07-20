<!DOCTYPE HTML>

<html>
<head>
<title>E-Commerce</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script type="text/javascript">
      $(document).ready(function() {
    		ajaxGet();
    		// DO GET
    		function ajaxGet(){
    			$.ajax({
    				type : "GET",
    				url :"getProduct",
    				success: function(result){
    					$.each(result, function(i, product){
    						
    						var productRow = '<tr>' +
    											'<td>' + product.id + '</td>' +
    											'<td>' + product.name+ '</td>' +
    											'<td>' + product.price + '</td>' +
    										  '</tr>';
    						
    						$('#productTable tbody').append(productRow);
    						
    			        });
    					
    					$( "#productTable tbody tr:odd" ).addClass("info");
    					$( "#productTable tbody tr:even" ).addClass("success");
    				},
    				error : function(e) {
    					alert("ERROR: ", e);
    					console.log("ERROR: ", e);
    				}
    			});	
    		}
    	})
      
      </script>
</head>

<body onload="ajaxGet()">
	<div class="container">
		<h1>Product Table</h1>
		<div class="row col-md-7 table-responsive">
			<table id="productTable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>