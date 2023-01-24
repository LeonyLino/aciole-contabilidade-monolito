$(document).ready(function() {

	$(".btnRemoverclass").click(function() {
		let valBtn = $(this).val();
		console.log('excluindo ' + valBtn);

		$.confirm({
			title: 'Atenção!',
			content: 'Tem certeza que deseja EXCLUIR essa credencial?',
			buttons: {
				cancel: function() {
					//close
				},
				confirm: {
					text: 'Excluir',
					btnClass: 'btn-red',
					action: function() {
						$.ajax({
							url: "/acessoPortal/remover/" + valBtn, success: function() {
								location.reload(true);
							}
						});
						$.alert('Excluido');
					}
				}
			}
		});
	});

})
