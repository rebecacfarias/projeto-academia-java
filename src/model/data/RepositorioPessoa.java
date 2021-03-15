package model.data;

import model.entities.Pessoa;

public interface RepositorioPessoa {
	
	void inserir(Pessoa p);
	
	Pessoa procurar(String numCPF);
	
	void remover(String numCPF);

	void exibir();
	
}
