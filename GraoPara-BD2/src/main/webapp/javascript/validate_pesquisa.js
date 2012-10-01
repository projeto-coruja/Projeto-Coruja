$(document).ready(function() {
	// validate signup form on keyup and submit
	var validator = $("#signupform").validate({
		rules: {
			/* ----------------------------------
			 *  Pesquisa por ano
			 * ---------------------------------- */
			ano: {
				minlength: 4,
				max: 2012,
				number: true
			},
		},
		messages: {
			ano: {
				minlength: jQuery.format("Informe o ano com {0} dígitos."),
				max: jQuery.format("Informe um ano anterior a {0}"),
				number: "Digite apenas números"
			},
		},
		// the errorPlacement has to take the table layout into account
		errorPlacement: function(error, element) {
			if ( element.is(":radio") )
				error.appendTo( element.parent().next().next() );
			else if ( element.is(":checkbox") )
				error.appendTo ( element.next() );
			else
				error.appendTo( element.parent().next() );
		}
	});

});