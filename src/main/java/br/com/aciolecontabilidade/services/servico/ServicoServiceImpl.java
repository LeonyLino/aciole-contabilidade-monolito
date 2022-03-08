package br.com.aciolecontabilidade.services.servico;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.Servico;
import br.com.aciolecontabilidade.models.dto.CadastrarServicoDTO;
import br.com.aciolecontabilidade.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoServiceImpl implements ServicoService{

	private final ServicoRepository sRepository;
	
	
	@Override
	@Transactional
	public void salvar(CadastrarServicoDTO dto) {
		sRepository.save(new Servico(dto.getTipo(), dto.getValor(), new Cliente(dto.getIdCliente())));
	}

}
