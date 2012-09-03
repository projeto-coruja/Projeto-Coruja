function changeToInput(obj) {
		check = obj.options[obj.selectedIndex].value;
		if(check === '') {
			tb = document.createElement('INPUT');
			tb.type = 'text';
			tb.value = check;
			tb.size = 8;
			tb.name = obj.name;
			tb.id = obj.id;
			obj.parentNode.insertBefore(tb, obj);
			obj.parentNode.removeChild(obj);
		}
		else true;
	}