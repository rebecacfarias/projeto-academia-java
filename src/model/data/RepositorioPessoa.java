package model.data;
/*
 * INTERFACE RepositorioPessoa  
 * Interface que estabelece os métodos necessários para os Repositórios(Array e Lista)
 * 
 * */


import model.data.exceptions.InsertException;
import model.entities.Pessoa;

public interface RepositorioPessoa {
	
	void inserir(Pessoa p) throws InsertException;
	
	Pessoa procurar(String numCPF);
	
	void remover(String numCPF);

	void exibir();
	
}
