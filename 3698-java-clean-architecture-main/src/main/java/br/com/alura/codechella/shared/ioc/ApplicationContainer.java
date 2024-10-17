package br.com.alura.codechella.shared.ioc;

import br.com.alura.codechella.application.gateways.IUsuarioDbGateway;
import br.com.alura.codechella.application.usecases.CadastrarUsuarioUseCase;
import br.com.alura.codechella.application.usecases.IUseCase;
import br.com.alura.codechella.application.usecases.ListarUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContainer {
    @Bean
    public
    IUseCase<CadastrarUsuarioUseCase.Input, CadastrarUsuarioUseCase.Output>
    cadastrarUsuarioUseCase(IUsuarioDbGateway gateway) {
        return new CadastrarUsuarioUseCase(gateway);
    }

    @Bean
    public IUseCase<ListarUsuarioUseCase.Input, ListarUsuarioUseCase.Output> listarUsuarioIUseCase(IUsuarioDbGateway gateway) {
        return new ListarUsuarioUseCase(gateway);
    }
}
