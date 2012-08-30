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
				minlength: 3,				
			},
			numero: {
				required: true,
				minlength: 3
			},
			tipo_num: {
				required: true			
			},
			autor: {
				required: true,
				minlength: 3,				
			},
			destinatario: {
				required: true,
				minlength: 3,				
			},
			local: {
				required: true,
				minlength: 3,				
			},
			dia: {
				required: true				
			},
			mes: {
				required: true				
			},
			ano: {
				required: true,
				minlength: 4,
				max: 2012,
				number: true
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
				minlength: 3
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
			/* ----------------------------------
			 *  Painel de trocar senha
			 * ---------------------------------- */
			senhaAtual: {
				required: true,
			},
			senhaNova: {
				required: true,
				minlength: 6
			},
			senhaConfirme: {
				required: true,
				minlength: 6,
				equalTo: "#senhaNova"
			},
			/* ----------------------------------
			 *  Painel de editar Palavra Chave
			 * ---------------------------------- */
			palavraNova:{
				required: true,
				minlength: 3
			},
			/* ----------------------------------
			 *  Cadastro de usuários pelo Admin
			 * ---------------------------------- */
			permissao:{
				required: true
			},
			/* ----------------------------------
			 *  Cadastro de novos tipos de documentos pelo Admin
			 * ---------------------------------- */
			docType:{
				required: true,
				minlength: 3
			},
			/* ----------------------------------
			 * Editar tipos de documentos pelo Admin
			 * ---------------------------------- */
			tpDocNovo:{
				required: true,
				minlength: 3
			},
		},
		messages: {
			/* ----------------------------------
			 *  Cadastro de Documentos
			 * ---------------------------------- */
			identificacao: {
				required: "Selecione a identificação."
			},
			tipo_num: {
				required: "Selecione o tipo de número. </br>"
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
			dia: {
				required: "Selecione o dia."				
			},
			mes: {
				required: "Selecione o mês.</br>"				
			},
			ano: {
				required: "Informe o Ano.",
				minlength: jQuery.format("Informe o ano com {0} dígitos."),
				max: jQuery.format("Informe um ano anterior a {0}"),
				number: "Digite apenas números"
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
			},
			/* ----------------------------------
			 *  Painel de trocar senha
			 * ---------------------------------- */
			senhaAtual: {
				required: "Digite sua senha cadastrada"
			},
			senhaNova: {
				required: "Digite uma senha nova",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			senhaConfirme: {
				required:  "Confirme sua senha",
				minlength: jQuery.format("Digite no mínimo {0} caracteres."),
				equalTo: "Digite uma senha igual a anterior."
			},
			/* ----------------------------------
			 *  Painel de editar Palavra Chave
			 * ---------------------------------- */
			palavraNova: {
				required: "Digite uma palavra nova",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			/* ----------------------------------
			 *  Cadastro de usuários pelo Admin
			 * ---------------------------------- */
			permissao:{
				required: "Selecione uma permissão para o usuário"
			},
			/* ----------------------------------
			 *  Cadastro de novos tipos de documentos pelo Admin
			 * ---------------------------------- */
			docType:{
				required: "Informe o tipo de documento que deseja cadastrar",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			/* ----------------------------------
			 *  Cadastro de novos tipos de documentos pelo Admin
			 * ---------------------------------- */
			tpDocNovo:{
				required: "Informe o tipo de Documento novo",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
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