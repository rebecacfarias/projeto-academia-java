package model.data;

import model.entities.Aluno;
import model.entities.Pessoa;
import model.entities.Professor;

public class RepositorioPessoaArray extends RepositorioPessoa {
	private Pessoa[] pessoas;
	private int indice;
	
	public RepositorioPessoaArray(int tamanho) {
		pessoas = new Pessoa[tamanho];
		indice = 0;
	}
	

	public Pessoa[] getPessoas() {
		return pessoas;
	}

	public void inserir(Pessoa a) {
		pessoas[indice] = a;
		indice++;
	}
	
	public Pessoa procurar(String numCPF) {
		Pessoa pessoa = null;
		
		for(Pessoa p : pessoas) {
			if(p!=null && p.getCpf().equals(numCPF)) 
				pessoa = p;
		}
		
		return pessoa;
	}
	
	public void remover(String numCPF) {
		for(int i = 0; i<pessoas.length; i++) {
			Pessoa aux = pessoas[i];
			
			if(aux!=null && aux.getCpf().equals(numCPF)) {
				pessoas[i] = pessoas[indice-1];
				pessoas[indice - 1] = null;
				
				indice--;
			}
			
		}
	}
	
	@Override
	public void exibir() {
		System.out.println("\nLISTA DE ALUNOS:");
		for(Pessoa p: pessoas){
			if(p!=null && p instanceof Aluno)
				System.out.println(p);
		}
		System.out.println("\n\nLISTA DE PROFESSORES:");
		for(Pessoa p: pessoas){
			if(p!=null && p instanceof Professor)
				System.out.println(p);
		}
	}
	
	
	

}
