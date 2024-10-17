package br.com.alura.codechella.shared.ioc;

import br.com.alura.codechella.application.gateways.IUsuarioDbGateway;
import br.com.alura.codechella.infra.gateways.UsuarioRepository;
import br.com.alura.codechella.infra.persistence.UsuarioRepositoryJPA;
import br.com.alura.codechella.shared.mapper.UsuarioEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfraContainer {
    @Bean
    public IUsuarioDbGateway usuarioRepository(UsuarioRepositoryJPA repositoryJPA, UsuarioEntityMapper mapper) {
        return new UsuarioRepository(repositoryJPA, mapper);
    }
}
