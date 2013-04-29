$(window).bind("load",function(){
	var $height = 0,
		$element,
		$pathname = window.location.pathname;
	if ($(".content")[0])	$element = $('.content');
	else	$element = $('.text');
	
	$height = $element.innerHeight();
//	$.each($bordaBox, function(){
//		height += $(this).height();
//	});
	
	if($pathname.indexOf("public/", 0) >= 0){	
		if($height < 320)	$height = 320;
	}
	else if($pathname.indexOf("user/", 0) >= 0){	
		if($height < 361)	$height = 361;
	}
	else if($pathname.indexOf("userAdv/", 0) >= 0){	
		if($height < 451)	$height = 451;
	}
	else if($pathname.indexOf("admin/", 0) >= 0){	
		if($height < 477)	$height = 477;
	}
	$('.sidebar1').css({height:$height});
});

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