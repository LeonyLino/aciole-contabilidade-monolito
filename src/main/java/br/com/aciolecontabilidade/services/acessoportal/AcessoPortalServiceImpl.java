package br.com.aciolecontabilidade.services.acessoportal;

import org.springframework.stereotype.Service;

import br.com.aciolecontabilidade.models.AcessoPortal;
import br.com.aciolecontabilidade.models.dto.AcessoPortalCadastroDTO;
import br.com.aciolecontabilidade.repository.AcessoPortalRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcessoPortalServiceImpl implements AcessoPortalService {

	private final AcessoPortalRepository apRepository;

	@Override
	public void salvar(AcessoPortalCadastroDTO dto) {
		apRepository.save(new AcessoPortal(null, dto.getDescricaoPortal(), dto.getCodigoAcesso(), dto.getSenha(),
				dto.getCliente()));
	}

}
