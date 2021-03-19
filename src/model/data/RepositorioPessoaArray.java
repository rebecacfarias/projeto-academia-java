package model.data;
/*
 * CLASSE RepositorioPessoaArray
 * Implementa��o do Reposit�rio com Array
 * 
 * */

import model.data.exceptions.InsertException;
import model.entities.Aluno;
import model.entities.Pessoa;
import model.entities.Professor;

public class RepositorioPessoaArray implements RepositorioPessoa {
	private Pessoa[] pessoas;
	private int indice;
	
	public RepositorioPessoaArray(int tamanho) {
		pessoas = new Pessoa[tamanho];
		indice = 0;
	}
	

	public Pessoa[] getPessoas() {
		return pessoas;
	}

	@Override
	public void inserir(Pessoa p) throws InsertException{
		if(indice>=pessoas.length) {
			throw new InsertException();
		}
		pessoas[indice] = p;
		indice++;

	}
	
	@Override
	public Pessoa procurar(String numCPF) {
		Pessoa pessoa = null;
		
		for(Pessoa p : pessoas) {
			if(p!=null && p.getCpf().equals(numCPF)) {
				pessoa = p;
				break;
			}	
		}
		return pessoa;
	}
	
	@Override
	public void remover(String numCPF) {
		boolean encontrou = false;
		for(int i = 0; i<pessoas.length; i++) {
			Pessoa aux = pessoas[i];
			if(aux!=null && aux.getCpf().equals(numCPF)) {
				pessoas[i] = pessoas[indice-1];
				pessoas[indice - 1] = null;
				indice--;
				encontrou = true;
				break;
			}
		}
		if(!encontrou) {
			System.out.println("IMPOSSIVEL REMOVER - NAO ENCONTRADO");
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
