package br.com.aciolecontabilidade.services.acessoportal;

import br.com.aciolecontabilidade.models.dto.AcessoPortalCadastroDTO;

public interface AcessoPortalService {

	void salvar(AcessoPortalCadastroDTO dto);
	
	AcessoPortalCadastroDTO retornaDtorPorId(Long id);
	
	void remover(Long id);
}
