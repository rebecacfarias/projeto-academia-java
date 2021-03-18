package model.dao;

import java.util.List;

import model.entities.Aluno;
import model.entities.Curso;

public interface AlunoDaoContract {
	
	boolean inserir(Aluno aluno);
	
	boolean atualizar(Aluno aluno);
	
	Aluno procurar(String cpf);
	
	boolean remover(String cpf);
	
	List<Aluno> exibirAlunos();
	
	List<Aluno> alunoPorCurso(Curso curso);
	
}
