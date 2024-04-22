

$(document).ready(function() {
	
	jQuery.validator.setDefaults({
		debug: true,
		success: "valid"
	});
	
	
	$("#labelDebt").maskMoney();
	$("#labelDate").inputmask("99/99/9999");
	
	$("#formInclude").validate({
		rules: {
			name: {
				required: true,
				maxlength: 45
			},
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			name: {
				required: "Esse campo é obrigatório!",
				maxlength: "O campo nome não pode ter mais que 45 caracteres"
			},
			email: {
				required: "Esse campo é obrigatório!",
				email: "Este não é um email válido!"
			}
			
		}
	});
	
	
});


	