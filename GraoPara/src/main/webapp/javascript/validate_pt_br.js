$(document).ready(function() {
	// validate signup form on keyup and submit
	var validator = $("#signupform").validate({
		rules: {
			/* ----------------------------------
			 *  Cadastro de Documentos
			 * ---------------------------------- */
			identificacao: "required",
			codigo: {
				required: true,
				minlength: 3,				
			},
			titulo: {
				required: true,
				minlength: 5,				
			},
			numero: {
				required: true,
				minlength: 3
			},
			tipo_num: required,
			autor: {
				required: true,
				minlength: 5,				
			},
			destinatario: {
				required: true,
				minlength: 5,				
			},
			local: {
				required: true,
				minlength: 5,				
			},
			data:{
				required: true,
				date: true
			},
			tipoDoc: required,
			resumo: required,
			chave1: {
				required: true,
				minlength: 3
			},
			/* ----------------------------------
			 *  Cadastro de Usuários
			 * ---------------------------------- */
			nome: {
				required: true,
				minlength: 5
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
			
		},
		messages: {
			/* ----------------------------------
			 *  Cadastro de Documentos
			 * ---------------------------------- */
			identificacao: "Selecione a identificação.",
			tipo_num: "Selecione o tipo de número.",
			codigo: {
				required: "Digite o código do documento.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			titulo: {
				required: "Digite o título do documento.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},			
			numero: {
				required: "Digite o número APEP ou Sequencial.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			autor: {
				required: "Digite o autor do documento.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			destinatario: {
				required: "Digite o destinatário do documento.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			local: {
				required: "Digite o local do documento.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			data: {
				required: "Entre com uma data válida.",
				date: "Entre com uma data válida."					
			},
			tipoDoc: "Selecione o tipo de Documento.",
			resumo: "Digite o resumo do Documento",
			chave1: {
				required: "Informe a primeira palavra chave.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			/* ----------------------------------
			 *  Cadastro de Usuários
			 * ---------------------------------- */
			nome: {
				required: "Digite seu nome completo.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			senha: {
				required: "Digite sua senha",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			confsenha: {
				required: "Confirme sua senha",
				minlength: jQuery.format("Digite no mínimo {0} caracteres."),
				equalTo: "Digite uma senha igual a anterior."
			},
			email: {
				required: "Entre com um email válido.",
				email: "Entre com um email válido."
			}
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
			alert("Cadastro Realizado com Sucesso!");
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