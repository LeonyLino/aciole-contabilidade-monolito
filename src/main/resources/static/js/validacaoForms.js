$(document).ready(function() {
	$("#dtNascimentoPF").mask("00/00/0000");
	$("#numContatoPF").mask("(00) 0 0000-0000");
	$("#rgCliente").mask("000000000000000");
	$("#tituloEleitorCliente").mask("000000000000");
	$('#valorServico').mask('###.##0,00', { reverse: true });
	$("#cpf").mask("000.000.000-00");
	$("#cnpj").mask("00.000.000/0000-00");



	switch (document.getElementById("tipo").value) {
		case 'PJ':
			$("#divCnpj").show();
		case 'PF':
			$("#divCpf").show();
		default:
			console.log('nenhum valor selecionado');
			$("#divCpf").hide()
			$("#divCnpj").hide()
			break;
	}

});

function mudarNomeCampoCpfCnpj() {
	document.getElementById("cpf").value = "";
	document.getElementById("cnpj").value = "";
	switch (document.getElementById("tipo").value) {
		case 'PF':
			console.log('PF selecionado');
			$("#divCpf").show();
			$("#divCnpj").hide();
			break;
		case 'PJ':
			$("#divCnpj").show();
			$("#divCpf").hide()
			break;
		default:
			console.log('nenhum valor selecionado');
			$("#divCpf").hide()
			$("#divCnpj").hide()
			break;
	}
}