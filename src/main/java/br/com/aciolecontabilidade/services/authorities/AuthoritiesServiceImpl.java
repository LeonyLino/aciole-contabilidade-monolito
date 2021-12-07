package br.com.aciolecontabilidade.services.authorities;

import org.springframework.stereotype.Service;

import br.com.aciolecontabilidade.models.Authorities;
import br.com.aciolecontabilidade.repository.AuthoritiesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthoritiesServiceImpl implements AuthoritiesService {
	
	private final AuthoritiesRepository aRepository;
	
	@Override
	public void salvarPorUsuario(String nomeUsuario) {
		aRepository.save(new Authorities(nomeUsuario, "ADM"));
	}

}
