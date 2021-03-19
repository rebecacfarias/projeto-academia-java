package model.data;
/*
 * CLASSE RepositorioPessoaArray
 * Implementação do Repositório com Lista
 * 
 * */

import java.util.ArrayList;
import java.util.List;

import model.entities.Aluno;
import model.entities.Pessoa;
import model.entities.Professor;

public class RepositorioPessoaLista implements RepositorioPessoa {
	List<Pessoa> pessoas = new ArrayList<>();

	@Override
	public void inserir(Pessoa p) {
		pessoas.add(p);
	}

	@Override
	public Pessoa procurar(String numCPF) {	 
		for(Pessoa p : pessoas) {
			if(p.getCpf().equals(numCPF))
				return p;
		}
		return null;
	}

	@Override
	public void remover(String numCPF) {
		boolean encontrou = false;
		for(Pessoa p : pessoas) {
			if(p.getCpf().equals(numCPF)) {
				encontrou = true;
				pessoas.remove(p);
				break;
			}	
		}
		
		if(!encontrou) {
			System.out.println("IMPOSSIVEL REMOVER - NAO ENCONTRADO");
		}
	}
	
	@Override
	public void exibir() {
		System.out.println("\nALUNOS:");
		for(Pessoa p: pessoas){
			if(p instanceof Aluno)
				System.out.println(p);
		}
		System.out.println("\n\nPROFESSORES:");
		for(Pessoa p: pessoas){
			if(p instanceof Professor)
				System.out.println(p);
		}
	}
}
