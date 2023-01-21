$(document).ready(function() {
	$("#codigoAcesso").mask("000000000000");

	let elementDescricao = document.getElementById("descricao");
	if (elementDescricao.value !== null) {
		switch (elementDescricao.value) {
			case 'GOV':
			case 'PREFEITURA':
				$("#divInputCodAcesso").hide();
				document.getElementById('codigoAcesso').value = "";
				break;
			default:
				$("#divInputCodAcesso").show();
				break;
		}
	}
});

function hideOrShowInputCodigoAcesso() {

	switch (document.getElementById("descricao").value) {
		case 'GOV':
		case 'PREFEITURA':
			$("#divInputCodAcesso").hide();
			document.getElementById('codigoAcesso').value = "";
			break;
		default:
			$("#divInputCodAcesso").show();
			break;
	}
}