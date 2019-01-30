$(document).ready(function() {
	$("#searchButton").click(function () {
		console.debug("obtaining person from the db"); 
		$.ajax({
			url: "http://localhost:8080/spring-rest-project-backend/persons/"+($("#personId").val() == "" ? alert("Insert a value to search for"):$("#personId").val()),
			type: 'GET',
		    dataType: 'json',
		    success: function (data) {
		    	clearFields (data);
		    	$('.person-id').append(data.id);
				$('.person-name').append(data.firstName);
				$('.person-last-name').append(data.lastName);
				$('.person-email').append(data.email);
				$('.person-phone').append(data.mobile);
		    },
		    statusCode: {
		        404: function() {
		        	alert("No person was found with ID: " + $("#personId").val() + ". Please, try another ID.");
		        }
		      }
		});
	});
		
});

function clearFields (data){
	$('.person-id').empty(data.id);
	$('.person-name').empty(data.firstName);
    $('.person-last-name').empty(data.lastName);
    $('.person-email').empty(data.email);
    $('.person-phone').empty(data.mobile);
}
