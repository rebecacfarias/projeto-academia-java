package model.data;

import model.entities.Pessoa;

public abstract class RepositorioPessoa {

	public abstract void inserir(Pessoa p);
	
	public abstract Pessoa procurar(String numCPF);
	
	public abstract void remover(String numCPF);

	public abstract void exibir();
	
}
