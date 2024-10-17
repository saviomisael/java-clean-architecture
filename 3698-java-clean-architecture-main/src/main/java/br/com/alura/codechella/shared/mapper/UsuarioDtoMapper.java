package br.com.alura.codechella.shared.mapper;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.controller.requests.UsuarioDto;

import java.util.Map;

public class UsuarioDtoMapper {
    private final Mapper mapper;
    private final Map<String, String> relacaoCpfNomeNascimentoEmail = Map.ofEntries(
            Map.entry("cpf", "cpf"),
            Map.entry("nome", "nome"),
            Map.entry("nascimento", "nascimento"),
            Map.entry("email", "email")
    );

    public UsuarioDtoMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public Usuario comCpfNomeNascimentoEmail(UsuarioDto dto) {
        try {
            return mapper.map(dto, Usuario.class, relacaoCpfNomeNascimentoEmail);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public UsuarioDto comCpfNomeNascimentoEmail(Usuario usuario) {
        try {
            return mapper.map(usuario, UsuarioDto.class, relacaoCpfNomeNascimentoEmail);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
