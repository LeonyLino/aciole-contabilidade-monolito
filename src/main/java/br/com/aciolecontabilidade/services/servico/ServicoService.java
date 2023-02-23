package br.com.aciolecontabilidade.services.servico;

import br.com.aciolecontabilidade.models.dto.CadastrarServicoDTO;

public interface ServicoService {

	void salvar(CadastrarServicoDTO dto);
	
	CadastrarServicoDTO retornaDtoPorId(Long id);

}
