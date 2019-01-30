/**
 * JS that manages all the frame actions
 */	
$(function () {
	$("#main").load("main.html");
});


$(document).ready(function() {
	$("#loginButton").click(function() {
		$("#main").load("person-crud.html");
	});
});	
