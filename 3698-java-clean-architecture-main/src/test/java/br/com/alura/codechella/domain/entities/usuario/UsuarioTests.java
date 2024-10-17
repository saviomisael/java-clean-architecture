package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTests {
    @Test
    public void naoDeveCadastrarUsuarioQuandoOCpfEstaFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () ->
                        new Usuario(
                                "12345678912",
                                "Savio",
                                LocalDate.of(1900, 1, 10),
                                "teste@email.com")
        );

        Assertions.assertThrows(IllegalArgumentException.class,
                () ->
                        new Usuario(
                                "",
                                "Savio",
                                LocalDate.of(1900, 1, 10),
                                "teste@email.com")
        );
    }

    @Test
    public void naoDeveCadastrarUsuarioQuandoForMenorDeIdade() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () ->
                        new Usuario(
                                "12345678912",
                                "Savio",
                                LocalDate.now().minusYears(17),
                                "teste@email.com")
        );
    }
}
