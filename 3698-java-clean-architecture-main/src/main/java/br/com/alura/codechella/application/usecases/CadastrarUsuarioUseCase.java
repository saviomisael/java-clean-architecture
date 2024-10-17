package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.IUsuarioDbGateway;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class CadastrarUsuarioUseCase implements IUseCase<CadastrarUsuarioUseCase.Input, CadastrarUsuarioUseCase.Output> {
    private final IUsuarioDbGateway repository;

    public CadastrarUsuarioUseCase(IUsuarioDbGateway repository) {
        this.repository = repository;
    }

    public Output handle(Input input) {
            return new Output(repository.cadastrarUsuario(input.usuario));
    }


    public record Input(Usuario usuario) implements IUseCase.Input {}

    public record Output(Usuario usuario) implements IUseCase.Output {}
}
