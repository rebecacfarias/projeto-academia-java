package model.dao;

import java.util.List;

import model.entities.Curso;

public interface CursoDaoContract {
	boolean inserir(Curso curso);
	
	boolean atualizar(Curso curso);
	
	Curso procurar(double codigo);
	
	boolean remover(double codigo);
	
	public List<Curso> exibirCurso();
}
