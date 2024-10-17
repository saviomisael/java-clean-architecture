package br.com.alura.codechella.shared.mapper;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.entities.UsuarioEntity;

import java.util.Map;

public class UsuarioEntityMapper {
    private final Mapper mapper;
    private final Map<String, String> relacaoCpfNomeNascimentoEmail = Map.ofEntries(
            Map.entry("cpf", "cpf"),
            Map.entry("nome", "nome"),
            Map.entry("nascimento", "nascimento"),
            Map.entry("email", "email")
    );

    public UsuarioEntityMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public Usuario comCpfNomeNascimentoEmail(UsuarioEntity entity) {
        return mapper.map(entity, Usuario.class, relacaoCpfNomeNascimentoEmail);
    }

    public UsuarioEntity comCpfNomeNascimentoEmail(Usuario usuario) {
        return mapper.map(usuario, UsuarioEntity.class, relacaoCpfNomeNascimentoEmail);
    }
}
