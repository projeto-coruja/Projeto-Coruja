function confirmBox(url){
	var r=confirm("Para a visualização do documento gerado, será necessário ter o LibreOffice instalado. \n"
			+ "Caso você já tenha o LibreOffice instalado em sua máquina, pressione OK.\n"
			+ "Pressione cancelar caso contrário (Você será redirecionado para a página de download).");
	if (r==true)	document.location = url;
	else	window.open("http://pt-br.libreoffice.org/baixe-ja/");
}