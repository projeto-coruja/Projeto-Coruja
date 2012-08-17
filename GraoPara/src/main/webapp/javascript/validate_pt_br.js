$(document).ready(function() {
	// validate signup form on keyup and submit
	var validator = $("#signupform").validate({
		rules: {
			nome: {
				required: true,
				minlength: 5
			},
			lastname: "required",
			username: {
				required: true,
				minlength: 5,				
			},
			senha: {
				required: true,
				minlength: 6
			},
			confsenha: {
				required: true,
				minlength: 6,
				equalTo: "#password"
			},
			email: {
				required: true,
				email: true,
			},
			dateformat: "required",
			terms: "required"
		},
		messages: {
			nome: {
				required: "Digite seu nome completo",
				minlength: jQuery.format("Digite no mínimo {0} caracteres")
			},
			lastname: "Enter your lastname",
			username: {
				required: "Enter a username",
				minlength: jQuery.format("Digite no mínimo {0} caracteres"),
				remote: jQuery.format("{0} is already in use")
			},
			senha: {
				required: "Digite sua senha",
				minlength: jQuery.format("Digite no mínimo {0} caracteres")
			},
			confsenha: {
				required: "Confirme sua senha",
				minlength: jQuery.format("Digite no mínimo {0} caracteres"),
				equalTo: "Digite uma senha igual a anterior"
			},
			email: {
				required: "Entre com um email válido",
				minlength: "Entre com um email válido",
				remote: jQuery.format("{0} is already in use")
			},
			dateformat: "Choose your preferred dateformat",
			terms: " "
		},
		// the errorPlacement has to take the table layout into account
		errorPlacement: function(error, element) {
			if ( element.is(":radio") )
				error.appendTo( element.parent().next().next() );
			else if ( element.is(":checkbox") )
				error.appendTo ( element.next() );
			else
				error.appendTo( element.parent().next() );
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
			alert("submitted!");
		},
		// set this class to error-labels to indicate valid fields
		success: function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("checked");
		}
	});
	
	// propose username by combining first- and lastname
	$("#username").focus(function() {
		var firstname = $("#nome").val();
		var lastname = $("#lastname").val();
		if(firstname && lastname && !this.value) {
			this.value = firstname + "." + lastname;
		}
	});

});