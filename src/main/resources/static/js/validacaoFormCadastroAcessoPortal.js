$(document).ready(function() {
	$("#codigoAcesso").mask("000000000000");

	let elementDescricao = document.getElementById("descricao");
	if (elementDescricao !== null && elementDescricao.value !== '') {
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