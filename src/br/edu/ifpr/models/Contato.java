package br.edu.ifpr.models;

import br.edu.ifpr.utils.BrazilianFormats;

import java.util.Calendar;

public class Contato {

    private	Long id;
    private	String nome;
    private	String email;
    private	String endereco;
    private Calendar dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void show(){
        System.out.println("Nome: "	+	this.getNome());
        System.out.println("Nome: "	+	this.getNome());
        System.out.println("Email: "	+	this.getEmail());
        System.out.println("Endereço: "	+	this.getEndereco());
        System.out.println("Data de Nascimento: " + BrazilianFormats.date(this.getDataNascimento().getTime()) +"\n");
    }
}
