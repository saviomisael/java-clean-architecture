package br.com.alura.codechella.shared.ioc;

import br.com.alura.codechella.shared.mapper.Mapper;
import br.com.alura.codechella.shared.mapper.UsuarioDtoMapper;
import br.com.alura.codechella.shared.mapper.UsuarioEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedContainer {
    @Bean
    public Mapper mapper() {
        return new Mapper();
    }

    @Bean
    public UsuarioEntityMapper usuarioEntityMapper(Mapper mapper) {
        return new UsuarioEntityMapper(mapper);
    }

    @Bean
    public UsuarioDtoMapper usuarioDtoMapper(Mapper mapper) {
        return new UsuarioDtoMapper(mapper);
    }
}
