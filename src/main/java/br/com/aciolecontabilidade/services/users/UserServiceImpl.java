package br.com.aciolecontabilidade.services.users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.aciolecontabilidade.models.Authorities;
import br.com.aciolecontabilidade.models.Users;
import br.com.aciolecontabilidade.models.dto.UserDTO;
import br.com.aciolecontabilidade.repository.AuthoritiesRepository;
import br.com.aciolecontabilidade.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository uRepository;
	private final AuthoritiesRepository aRepository;

	@Override
	public void salvar(UserDTO dto) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		uRepository.save(new Users(dto.getUsuario(), encoder.encode(dto.getSenha()), true));
		aRepository.save(new Authorities(dto.getUsuario(), "ADM"));
		
	}

}
