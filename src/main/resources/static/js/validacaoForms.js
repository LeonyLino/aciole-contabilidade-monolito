$(document).ready(function() {
	$("#dtNascimentoIR").mask("00/00/0000");
	$("#numContatoIR").mask("(00) 0 0000-0000");
	$("#rgIR").mask("000000000000000");
	$("#tituloIR").mask("000000000000");
	$('#valorServico').mask('###.##0,00', { reverse: true });
	$("#cpfIR").mask("000.000.000-00");
	$("#cnpjIR").mask("00.000.000/0000-00");

	console.log('tela carregada: ', document.getElementById("tipoIR").value)

	switch (document.getElementById("tipoIR").value) {
		case 'PJ':
			console.log('chegou pj')
			$("#divCnpj").show();
			$("#divCpf").hide()
			break;
		case 'PF':
			console.log('chegou pf')
			$("#divCpf").show();
			$("#divCnpj").hide();
			break;
		default:
			console.log('nenhum valor selecionado');
			$("#divCpf").hide()
			$("#divCnpj").hide()
			break;
	}

});

function mudarNomeCampoCpfCnpj() {
	document.getElementById("cpfIR").value = "";
	document.getElementById("cnpjIR").value = "";
	switch (document.getElementById("tipoIR").value) {
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