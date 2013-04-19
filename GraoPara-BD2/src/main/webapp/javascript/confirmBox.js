function confirmBox(url){
	var r=confirm("Para a visualização do documento gerado, será necessário ter o LibreOffice instalado. \n"
			+ "Caso você já tenha o LibreOffice instalado em sua máquina, pressione OK.\n"
			+ "Pressione cancelar caso contrário (Você será redirecionado para a página de download).");
	if (r==true){
		alert("Para salvar e realizar futuras formatações é necessário fazer o download da planilha em seu disco.\n"
			+ "Caso você apenas abra o arquivo, não será possível gravar a planilha ou fazer futuras modificações na sua formatação.");
		document.location = url;
	}
	else	window.open("http://pt-br.libreoffice.org/baixe-ja/");
}