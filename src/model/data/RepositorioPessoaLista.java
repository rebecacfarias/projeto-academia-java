package model.data;

import java.util.ArrayList;
import java.util.List;

import model.entities.Aluno;
import model.entities.Pessoa;
import model.entities.Professor;

public class RepositorioPessoaLista extends RepositorioPessoa {
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
			System.out.println("Nao encontrado.");
		}
	}
	
	@Override
	public void exibirAlunos() {
		for(Pessoa p: pessoas){
			if(p instanceof Aluno)
				System.out.println(p);
		}
	}
	
	@Override
	public void exibirProfessores() {
		for(Pessoa p: pessoas){
			if(p instanceof Professor)
				System.out.println(p);
		}
	}

}
