$(document).ready(function() {
	$("#codigoAcesso").mask("000000000000");
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