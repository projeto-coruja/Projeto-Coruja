<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Teste Validação</title>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <meta http-equiv="Content-Language" content="pt-br" />
		<link rel="stylesheet" href="../css/validationEngine.jquery.css" type="text/css" media="screen" /><link rel="stylesheet" href="css/apprise.min.css" type="text/css" media="screen" />     
			<!-- scripts -->
				<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
				<script type="text/javascript" src="../javascript/jquery.validationEngine.js" charset="utf-8"></script><script type="text/javascript" src="../javascript/languages/jquery.validationEngine-pt.js" charset="utf-8"></script><script type="text/javascript" src="../javascript/script.js"></script>				
			<!-- /scripts -->
	 </head>
    <body onload="start();">	           

		<!-- content -->
		<div class="content">
		    <h1>Fale Conosco</h1>
		
		    <form method="post" action="#" id="contact">
				<input type="hidden" name="conType" value="contact" />
		        <fieldset>
		            <legend>Entre em contato conosco</legend>
				  	<label for="conName">Nome</label>
				  	<input type="text" name="conName" id="conName" class="validate[required] mediumInput"/>
				  	<br />
					
				  	<label for="conMail">Email</label>
				  	<input type="text" name="conMail" id="conMail" class="validate[required] validate[custom[email]] mediumInput"/>
					<br />
					
					<label for="conOperator" class="none">Operadora</label>
					<label for="conPhone">Telefone</label>
					<select name="conOperator" id="conOperator" class="validate[required] smallInput">
						<option value="">-- Selecione a operadora --</option>
						<option value="TIM">TIM</option>
						<option value="OI">OI</option>
						<option value="Claro">Claro</option>
						<option value="Vivo">Vivo</option>
						<option value="Nextel">Nextel</option>
						<option value="Outros">Outros</option>
					</select>
				  	<input type="text" name="conPhone" id="conPhone" class="validate[required] mediumInput phone"/>
				  	<br />
				  	
				  	<label for="conMessage">Mensagem</label>
				  	<textarea name="conMessage" id="conMessage" cols="20" rows="3"></textarea>
				  	<br />
				  	<input type="submit" name="send" value="Enviar"/>
		        </fieldset>
		    </form>    
		</div>
		<!-- /content -->
	</body>
</html>