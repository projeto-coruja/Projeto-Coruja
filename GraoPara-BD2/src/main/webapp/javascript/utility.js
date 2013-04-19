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