package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.IUsuarioDbGateway;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuarioUseCase implements IUseCase<ListarUsuarioUseCase.Input, ListarUsuarioUseCase.Output> {
    private final IUsuarioDbGateway gateway;

    public ListarUsuarioUseCase(IUsuarioDbGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Output handle(Input input) {
        return new Output(gateway.listarTodos());
    }

    public record Input() implements IUseCase.Input {}

    public record Output(List<Usuario> usuarios) implements IUseCase.Output {}
}
