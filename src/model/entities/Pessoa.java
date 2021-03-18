package model.entities;

public class Pessoa {
	private String nome;
	private String cpf;
	private int idade;

	public Pessoa() {
		nome = null;
		cpf = null;
		idade = 0;
	}
	
	public Pessoa(String nome, String cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString(){
	   return "Nome: "+nome+", CPF: "+cpf+", Idade: "+idade;
	}
}
