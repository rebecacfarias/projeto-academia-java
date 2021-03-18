package model.data;

import model.data.exceptions.InsertException;
import model.entities.Pessoa;

public interface RepositorioPessoa {
	
	void inserir(Pessoa p) throws InsertException;
	
	Pessoa procurar(String numCPF);
	
	void remover(String numCPF);

	void exibir();
	
}
