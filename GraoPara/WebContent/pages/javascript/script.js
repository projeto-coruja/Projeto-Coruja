// variáveis utilizadas como função
var start;

$(document).ready(function() {
	
	// target="_blank" falso
	$('a.blank').click(function() {
		window.open($(this).attr('href'));
		return false;
	});

	
	// se houverem formulários
	if ($('form').length) {
		$('form').validationEngine({promptPosition : 'topRight', scroll: false});
		$('form').ajaxForm({dataType: 'json', success: processJson});
		
		// remove validation errors
		$(window).resize(function() {
			$('form').validationEngine('hideAll');
		});
		
		function processJson(data)
		{
			apprise(data.message, {'animate': 'true', 'textOk': 'Ok'});
			if (data.status == 'success') {
				// limpa formulário
				$('form input[type="text"]').val('');
				$('form textarea').val('');
			}
		}
	}
});