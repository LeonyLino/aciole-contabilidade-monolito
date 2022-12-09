$(document).ready(function() {
	$("#codigoAcesso").mask("000000000000");
});

function hideOrShowInputCodigoAcesso() {

	switch (document.getElementById("descricao").value) {
		case 'GOV':
			$("#divInputCodAcesso").hide();
			break;
		case 'PREFEITURA':
			$("#divInputCodAcesso").hide();
			break;
		default:
			$("#divInputCodAcesso").show();
			break;
	}
}