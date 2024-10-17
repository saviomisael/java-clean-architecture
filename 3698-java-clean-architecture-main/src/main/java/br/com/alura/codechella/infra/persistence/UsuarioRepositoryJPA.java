package br.com.alura.codechella.infra.persistence;

import br.com.alura.codechella.infra.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositoryJPA extends JpaRepository<UsuarioEntity, Long> {
}
