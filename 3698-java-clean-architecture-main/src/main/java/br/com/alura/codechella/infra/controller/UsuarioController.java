package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CadastrarUsuarioUseCase;
import br.com.alura.codechella.application.usecases.IUseCase;
import br.com.alura.codechella.application.usecases.ListarUsuarioUseCase;
import br.com.alura.codechella.infra.controller.requests.UsuarioDto;
import br.com.alura.codechella.shared.mapper.UsuarioDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final IUseCase<CadastrarUsuarioUseCase.Input, CadastrarUsuarioUseCase.Output> useCase;
    private final UsuarioDtoMapper mapper;
    private final IUseCase<ListarUsuarioUseCase.Input, ListarUsuarioUseCase.Output> listarUsuarioUseCase;

    @Autowired
    public UsuarioController(
            IUseCase<CadastrarUsuarioUseCase.Input, CadastrarUsuarioUseCase.Output> useCase,
            IUseCase<ListarUsuarioUseCase.Input, ListarUsuarioUseCase.Output> listarUsuarioUseCase,
            UsuarioDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
        this.listarUsuarioUseCase = listarUsuarioUseCase;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {
        return mapper.comCpfNomeNascimentoEmail(useCase.handle(new CadastrarUsuarioUseCase.Input(mapper.comCpfNomeNascimentoEmail(usuarioDto))).usuario());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios() {
        return this.listarUsuarioUseCase.handle(new ListarUsuarioUseCase.Input()).usuarios().stream().map(mapper::comCpfNomeNascimentoEmail).toList();
    }
}
