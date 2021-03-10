package model.data;

import model.entities.Pessoa;

public abstract class RepositorioPessoa {

	public abstract void inserir(Pessoa p);
	
	public abstract Pessoa procurar(String numCPF);
	
	public abstract void remover(String numCPF);
	
	public abstract void exibirAlunos();
	
	public abstract void exibirProfessores();
	
	public void exibirTodos() {
		System.out.println("\nLISTA DE ALUNOS:");
		exibirAlunos();
		System.out.println("\n\nLISTA DE PROFESSORES:");
		exibirProfessores();	
	}
	
}
