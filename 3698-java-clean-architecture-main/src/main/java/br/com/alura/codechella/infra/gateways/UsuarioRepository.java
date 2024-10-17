package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.IUsuarioDbGateway;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioRepositoryJPA;
import br.com.alura.codechella.infra.persistence.entities.UsuarioEntity;
import br.com.alura.codechella.shared.mapper.UsuarioEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// O repositório é um gateway para o banco
public class UsuarioRepository implements IUsuarioDbGateway {
    private final UsuarioRepositoryJPA repository;
    private final UsuarioEntityMapper mapper;

    @Autowired
    public UsuarioRepository(UsuarioRepositoryJPA repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.comCpfNomeNascimentoEmail(usuario);

        UsuarioEntity usuarioSalvo = repository.save(entity);
        return mapper.comCpfNomeNascimentoEmail(usuarioSalvo);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll().stream().map(mapper::comCpfNomeNascimentoEmail).toList();
    }
}
