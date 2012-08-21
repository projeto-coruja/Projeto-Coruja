$(document).ready(function() {
	// validate signup form on keyup and submit
	var validator = $("#signupform").validate({
		rules: {
			/* ----------------------------------
			 *  Cadastro de Documentos
			 * ---------------------------------- */
			identificacao: {
				required: true
			},
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
			tiponum: {
				required: true			
			},
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
			tipoDoc: {
				required: true
			},
			resumo: {
				required: true
			},
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
			permissao:{
				required: true
			},			
		},
		messages: {
			/* ----------------------------------
			 *  Cadastro de Documentos
			 * ---------------------------------- */
			identificacao: {
				required: "Selecione a identificação."
			},
			tiponum: {
				required: "Selecione o tipo de número."
			},
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
			tipoDoc: {
				required: "Selecione o tipo de Documento."
			},
			resumo: {
				required: "Digite o resumo do Documento"
			},
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
			},
			permissao: {
				required: "Selecione a Permissão do Usuário."
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
		}
	});

});