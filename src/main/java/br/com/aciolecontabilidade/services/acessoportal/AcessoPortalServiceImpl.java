package br.com.aciolecontabilidade.services.acessoportal;

import org.springframework.stereotype.Service;

import br.com.aciolecontabilidade.exceptions.EntidadeNaoEncontradaException;
import br.com.aciolecontabilidade.models.AcessoPortal;
import br.com.aciolecontabilidade.models.dto.AcessoPortalCadastroDTO;
import br.com.aciolecontabilidade.models.dto.converter.AcessoPortalCadastroDTOConverter;
import br.com.aciolecontabilidade.repository.AcessoPortalRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcessoPortalServiceImpl implements AcessoPortalService {

	private final AcessoPortalRepository apRepository;
	private final AcessoPortalCadastroDTOConverter apcDTOConverter;

	@Override
	public void salvar(AcessoPortalCadastroDTO dto) {
		apRepository.save(new AcessoPortal(dto.getId(), dto.getDescricaoPortal(), dto.getCodigoAcesso(), dto.getSenha(),
				dto.getCliente()));
	}

	private AcessoPortal buscarPorId(Long id) {
		return apRepository.findById(id).orElseThrow(EntidadeNaoEncontradaException::new);
	}

	@Override
	public AcessoPortalCadastroDTO retornaDtorPorId(Long id) {
		return apcDTOConverter.convert(this.buscarPorId(id));
	}

	@Override
	public void remover(Long id) {
		apRepository.delete(this.buscarPorId(id));
	}

}
