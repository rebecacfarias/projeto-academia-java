package model.dao;
/*
 * INTERFACE AlunoDaoContract
 * Interface que estabelece os métodos que devem ser implementados pelo AlunoDao
 *  
 * */

import java.util.List;

import model.entities.Aluno;

public interface AlunoDaoContract {
	
	boolean inserir(Aluno aluno);
	
	boolean atualizar(Aluno aluno);
	
	Aluno procurar(String cpf);
	
	boolean remover(String cpf);
	
	List<Aluno> exibirAlunos();
	
	List<Aluno> alunoPorCurso(double codigo);
	
}
