package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.valueobjects.Endereco;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    private Endereco endereco;

    public Usuario() {}

    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        isValid(cpf, nascimento);

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public void isValid(String cpf, LocalDate nascimento) {
        if(cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))
            throw new IllegalArgumentException("CPF não está no padrão correto");

        final int idade = Period.between(nascimento, LocalDate.now()).getYears();

        if(idade < 18) throw new IllegalArgumentException("Usuário deve ser maior de idade");
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getEmail() {
        return email;
    }
}
