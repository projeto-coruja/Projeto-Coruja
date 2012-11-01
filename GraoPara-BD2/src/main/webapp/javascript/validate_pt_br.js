$(document).ready(function() {
	// validate signup form on keyup and submit
	var validator = $("#signupform").validate({
		groups: {
			numberType: "tipo_num numero",
			documentDate: "dia mes ano"
		},
		
		rules: {
			
			/* -----------------------------------------------------
			 *  Cadastro de Documento
			 * ----------------------------------------------------- */
			
			identificacao: {
				required: true
			},
			anoInicioCodiceCaixa: {
				required: true,
				number: true,
				minlength: 4
			},
			anoFimCodiceCaixa: {
				required: true,
				number: true,
				minlength: 4
			},
			codigo: {
				required: true,
				minlength: 3				
			},
			tituloDocumento: {
				required: true				
			},
			numero: {
				required: true,
				minlength: 3
			},
			tipo_num: {
				required: true			
			},
			autor: {
				required: true				
			},
			autorOcupacao: {
				required: true
			},
			destinatario: {
				required: true				
			},
			destinatarioOcupacao: {
				required: true
			},
			local: {
				required: true				
			},
			dia: {
				required: true				
			},
			mes: {
				required: true				
			},
			ano: {
				required: true,
				number: true,
				minlength: 4
			},
			tipoDoc: {
				required: true
			},
			descricaoTipoDocumento: {
				required: true
			},
			resumo: {
				required: true
			},
			chave1: {
				required: true
			},
			
			/* -----------------------------------------------------
			 *  Cadastro de Usuário
			 * ----------------------------------------------------- */
			
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
			
			/* -----------------------------------------------------
			 *  Painel de Controle (Alterar Senha)
			 * ----------------------------------------------------- */
			
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
			
			/* -----------------------------------------------------
			 *  Painel de Editar Palavra-Chave
			 * ----------------------------------------------------- */
			
			palavraNova:{
				required: true,
				minlength: 3
			},
			
			/* -----------------------------------------------------
			 *  Cadastro de Usuário [Administrador]
			 * ----------------------------------------------------- */
			
			permissao:{
				required: true
			},
			
			/* -----------------------------------------------------
			 *  Cadastro de Tipo de Documento [Administrador]
			 * ----------------------------------------------------- */
			
			docType:{
				required: true,
				minlength: 3
			},
			
			/* -----------------------------------------------------
			 *  Cadastro de Palavra-Chave [Administrador]
			 * ----------------------------------------------------- */
			
			palavra:{
				required: true,
				minlength: 3
			},
			
			/* -----------------------------------------------------
			 * Editar Tipo de Documento [Administrador]
			 * ----------------------------------------------------- */
			
			tpDocNovo:{
				required: true,
				minlength: 3
			},
		},
		
		messages: {
			
			/* -----------------------------------------------------
			 *  Cadastro de Documento
			 * ----------------------------------------------------- */
			
			identificacao: {
				required: "Escolhe uma identificação."
			},
			anoInicioCodiceCaixa: {
				required: "Digite o ano inicial.",
				minlength: jQuery.format("Informe o ano com {0} dígitos."),
				number: "Digite apenas números"
			},
			anoFimCodiceCaixa: {
				required: "Digite o ano final.",
				minlength: jQuery.format("Informe o ano com {0} dígitos."),
				number: "Digite apenas números"
			},
			tipo_num: {
				required: "Número APEP ou Sequencial inválido."
			},			
			numero: {
				required: "Número APEP ou Sequencial inválido.",
				minlength: jQuery.format("Informe no mínimo {0} caracteres.")
			},
			codigo: {
				required: "Digite o código do documento.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			tituloDocumento: {
				required: "Digite o título do documento."
			},
			autor: {
				required: "Digite o autor do documento."
			},
			autorOcupacao: {
				required: "Digite a ocupação do autor do documento."
			},
			destinatario: {
				required: "Digite o destinatário do documento."
			},
			destinatarioOcupacao: {
				required: "Digite a ocupação do destinatário do documento."
			},
			local: {
				required: "Digite o local do documento."
			},
			dia: {
				required: "Data do documento inválido."				
			},
			mes: {
				required: "Data do documento inválido."				
			},
			ano: {
				required: "Data do documento inválido.",
				minlength: jQuery.format("Informe o ano com {0} dígitos."),
				number: "Digite apenas números."
			},
			tipoDoc: {
				required: "Escolhe um tipo de documento."
			},
			descricaoTipoDocumento: {
				required: "Escreva uma descrição para o tipo de documento."
			},
			resumo: {
				required: "Escreva um resumo para o documento."
			},
			chave1: {
				required: "Informe a primeira palavra-chave."
			},
			
			/* -----------------------------------------------------
			 *  Cadastro de Usuário
			 * ----------------------------------------------------- */
			
			nome: {
				required: "Digite seu nome.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			senha: {
				required: "Digite uma senha.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			confsenha: {
				required: "Confirme sua senha.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres."),
				equalTo: "Senha incorreta."
			},
			email: {
				required: "Digite um email válido.",
				email: "Entre com um email válido."
			},
			permissao: {
				required: "Selecione o nível do usuário."
			},
			
			/* -----------------------------------------------------
			 *  Painel de Controle (Alterar Senha)
			 * ----------------------------------------------------- */
			
			senhaAtual: {
				required: "Informe sua senha atual."
			},
			senhaNova: {
				required: "Digite a nova senha.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			senhaConfirme: {
				required:  "Redigite a nova senha.",
				minlength: jQuery.format("Digite no mínimo {0} caracteres."),
				equalTo: "Digite uma senha igual a anterior."
			},
			
			/* -----------------------------------------------------
			 *  Painel de Editar Palavras-Chave
			 * ----------------------------------------------------- */
			
			palavraNova: {
				required: "Digite uma palavra nova",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")
			},
			
			/* -----------------------------------------------------
			 *  Cadastro de Usuário [Administrador]
			 * ----------------------------------------------------- */
			
			permissao:{
				required: "Selecione uma permissão para o usuário"
			},
			
			/* -----------------------------------------------------
			 *  Cadastro de Tipo de Documento [Administrador]
			 * ----------------------------------------------------- */
			
			docType:{
				required: "Informe o tipo de documento que deseja cadastrar",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")				
			},
			
			/* -----------------------------------------------------
			 *  Cadastro de Palavra-Chave [Administrador]
			 * ----------------------------------------------------- */
			
			palavra:{
				required: "Informe a palavra-chave que deseja cadastrar",
				minlength: jQuery.format("Digite no mínimo {0} caracteres.")				
			},
			
			/* -----------------------------------------------------
			 *  Cadastro de Tipo de Documento [Administrador]
			 * ----------------------------------------------------- */
			
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