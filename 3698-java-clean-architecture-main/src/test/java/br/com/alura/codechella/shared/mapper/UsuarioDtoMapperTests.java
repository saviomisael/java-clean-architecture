package br.com.alura.codechella.shared.mapper;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.controller.requests.UsuarioDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioDtoMapperTests {
    private final UsuarioDtoMapper mapper = new UsuarioDtoMapper(new Mapper());

    @Test
    public void deveMapearCpfNomeNascimentoEmail() {
        UsuarioDto dto = new UsuarioDto();
        dto.setCpf("12345678912");
        dto.setEmail("email@email.com");
        dto.setNascimento(LocalDate.of(2000, 2, 3));
        dto.setNome("Usuário");

        Usuario usuario = mapper.comCpfNomeNascimentoEmail(dto);

        Assertions.assertThat(usuario.getNome()).isEqualTo("Usuário");
        Assertions.assertThat(usuario.getCpf()).isEqualTo("12345678912");
        Assertions.assertThat(usuario.getEmail()).isEqualTo("email@email.com");
        Assertions.assertThat(usuario.getNascimento().getYear()).isEqualTo(2000);
        Assertions.assertThat(usuario.getNascimento().getMonthValue()).isEqualTo(2);
        Assertions.assertThat(usuario.getNascimento().getDayOfMonth()).isEqualTo(3);
    }
}
