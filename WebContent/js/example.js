
$(document).ready(function() {	
	function myAlert() {
		var message = $("#message").val();
		$("#messageResponse").text(message);
	}
	
	$("button").on("click", function(event) {
		myAlert();
	});
});

