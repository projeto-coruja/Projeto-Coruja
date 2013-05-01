$(window).bind("load",function(){
	var $height = 0,
		$element,
		pathname = window.location.pathname;
		agent = navigator.userAgent,
		count = 0,
		browserWhitelist = ["firefox","chrome", "opera", "safari"];
	if ($(".content")[0])	$element = $('.content');
	else	$element = $('.text');
	
	$height = $element.innerHeight();
//	$.each($bordaBox, function(){
//		height += $(this).height();
//	});
	
	for(var i = 0; i < browserWhitelist.length; i++ ){
		count += agent.toLocaleLowerCase().indexOf(browserWhitelist[i], 0);
	}
	
	if(count <= browserWhitelist.length * -1){
		window.location.replace("atualizarBrowser.jsp");
	}
	if(pathname.indexOf("public/", 0) >= 0){	
		if($height < 320)	$height = 320;
	}
	else if(pathname.indexOf("user/", 0) >= 0){	
		if($height < 361)	$height = 361;
	}
	else if(pathname.indexOf("userAdv/", 0) >= 0){	
		if($height < 451)	$height = 451;
	}
	else if(pathname.indexOf("admin/", 0) >= 0){	
		if($height < 477)	$height = 477;
	}
	$('.sidebar1').css({height:$height});
});

function confirmAction(msg, url){
	var r=confirm(msg);
	if (r==true){
		document.location = url;
	}
}

function changeToInput(obj) {
		check = obj.options[obj.selectedIndex].value;
		if(check === 'newKeyWord') {
			tb = document.createElement('INPUT');
			tb.type = 'text';
			tb.value = '';
			tb.size = 18;
			tb.name = obj.name;
			tb.id = obj.id;
			obj.parentNode.insertBefore(tb, obj);
			obj.parentNode.removeChild(obj);
		}
		if(check === 'newDocType') {
			tb = document.createElement('INPUT');
			tb.type = 'text';
			tb.value = 'Tipo - Descrição';
			tb.size = 64;
			tb.name = obj.name;
			tb.id = obj.id;
			obj.parentNode.insertBefore(tb, obj);
			obj.parentNode.removeChild(obj);
		}
		else true;
	}
