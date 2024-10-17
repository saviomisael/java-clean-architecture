package br.com.alura.codechella.domain.entities.usuario;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;

public class UsuarioBuilderTests {
    @Test
    public void deveCriarUsuarioComAFabrica() {
        UsuarioBuilder factory = new UsuarioBuilder();
        final Usuario usuario = factory.comNomeCpfNascimento("Emily", "654.123.897-88", LocalDate.of(2000, 10 , 1));

        assertAll(
                () -> Assertions.assertThat(usuario.getNome()).isEqualTo("Emily"),
                () -> Assertions.assertThat(usuario.getCpf()).isEqualTo("654.123.897-88"),
                () -> Assertions.assertThat(usuario.getNascimento().getYear()).isEqualTo(2000),
                () -> Assertions.assertThat(usuario.getNascimento().getMonthValue()).isEqualTo(10),
                () -> Assertions.assertThat(usuario.getNascimento().getDayOfMonth()).isEqualTo(1)
        );

        final Usuario usuarioComEndereco = factory.incluiEndereco("12345-999", 40, "apto 201");

        assertAll(
                () -> Assertions.assertThat(usuarioComEndereco.getNome()).isEqualTo("Emily"),
                () -> Assertions.assertThat(usuarioComEndereco.getCpf()).isEqualTo("654.123.897-88"),
                () -> Assertions.assertThat(usuarioComEndereco.getNascimento().getYear()).isEqualTo(2000),
                () -> Assertions.assertThat(usuarioComEndereco.getNascimento().getMonthValue()).isEqualTo(10),
                () -> Assertions.assertThat(usuarioComEndereco.getNascimento().getDayOfMonth()).isEqualTo(1),
                () -> Assertions.assertThat(usuarioComEndereco.getEndereco().getCep()).isEqualTo("12345-999"),
                () -> Assertions.assertThat(usuarioComEndereco.getEndereco().getNumero()).isEqualTo(40),
                () -> Assertions.assertThat(usuarioComEndereco.getEndereco().getComplemento()).isEqualTo("apto 201")
        );
    }
}
