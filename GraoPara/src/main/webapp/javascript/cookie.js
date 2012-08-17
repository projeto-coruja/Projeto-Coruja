function getCookie(c_name)
{
	var i,x,y,ARRcookies=document.cookie.split(";");
	for (i=0;i<ARRcookies.length;i++)
	{
		x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		x=x.replace(/^\s+|\s+$/g,"");
		if (x==c_name)
		{
			return unescape(y);
		}
	}
}

function setCookie(c_name,value,exdays)
{
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
	document.cookie=c_name + "=" + c_value;
}

function checkCookie() {

	var status = getCookie("status_graopara");

	if(status == 2) {
		window.location.replace("/GraoPara/protected/admin/indexAdmin.jsp");
	}
	else if(status == 1) {
		window.location.replace("/GraoPara/protected/user/indexUser.jsp");
	}
}

function getName() {
	var name = getCookie("nome_graopara");
	return name;	
}