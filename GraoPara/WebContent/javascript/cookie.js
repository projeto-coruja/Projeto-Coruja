function getCookie(c_name){
	var i,x,y,ARRcookies=document.cookie.split(";");
	for (i=0;i<ARRcookies.length;i++)
	{
		x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		x=x.replace(/^\s+|\s+$/g,"");
		if (x==c_name) {
			return unescape(y);
		}
	}
}

function checkCookie() {
	var node;
	var username=getCookie('email_graopara');
	var status=getCookie('status_graopara');
	if (username!=null && username!='') {
		node = document.getElementById('LoginArea');
		node.style.hidden = '0';
		node = document.getElementById('AfterLogin');
		node.style.hidden = '';
	}
}