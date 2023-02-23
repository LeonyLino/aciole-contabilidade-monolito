$(document).ready(function() {
	/* mask da tela listar clientes IR*/
	$(".colunmCpf").mask("000.000.000-00");
	$(".colunmNumContato").mask("(00) 0 0000-0000");
	$(".colunmCnpj").mask("00.000.000/0000-00");
	
	
	$(".btnRemoveCliente").click(function() {
		let valBtn = $(this).val();
		console.log('excluindo ' + valBtn);

		$.confirm({
			title: 'Atenção!',
			content: 'Tem certeza que deseja EXCLUIR esse Cliente?',
			buttons: {
				cancel: function() {
					//close
				},
				confirm: {
					text: 'Excluir',
					btnClass: 'btn-red',
					action: function() {
						$.ajax({
							url: "/cliente/remover/" + valBtn, success: function() {
								location.reload(true);
							}
						});
						$.alert('Excluido');
					}
				}
			}
		});
	});
});