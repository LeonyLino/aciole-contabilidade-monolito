$(document).ready(function() {
	$("#dtNascimentoPF").mask("00/00/0000");
	$("#numContatoPF").mask("(00) 0 0000-0000");
	$("#rgCliente").mask("000000000000000");
	$("#tituloEleitorCliente").mask("000000000000");
	$('#valorServico').mask('###.##0,00', { reverse: true });


	document.getElementById("tipo").value !== '' ? $("#divCpfCnpj").show() : $("#divCpfCnpj").hide();

});
function mudarNomeCampoCpfCnpj() {
	$("#divCpfCnpj").show();
	document.getElementById("cpfCnpjPF").value = "";
	switch (document.getElementById("tipo").value) {
		case 'PF':
			console.log('PF selecionado');
			document.getElementById("campoCpfCnpjPF").innerHTML = "CPF";
			$(document).ready(function() {
				$("#cpfCnpjPF").mask("000.000.000-00");
			});
			break;
		case 'PJ':
			console.log('PJ selecionado');
			document.getElementById("campoCpfCnpjPF").innerHTML = "CNPJ";
			$(document).ready(function() {
				$("#cpfCnpjPF").mask("00.000.000/0000-00");
			});
			break;
		default:
			console.log('nenhum valor selecionado');
			$("#divCpfCnpj").hide();
			break;
	}
}