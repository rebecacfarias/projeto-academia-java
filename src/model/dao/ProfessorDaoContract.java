package model.dao;
/*
 * INTERFACE ProfessorDaoContract
 * Interface que estabelece os métodos que devem ser implementados pelo ProfessorDao
 *  
 * */

import java.util.List;

import model.entities.Professor;

public interface ProfessorDaoContract {
	boolean inserir(Professor professor);
	
	boolean atualizar(Professor professor);
	
	Professor procurar(String cpf);
	
	boolean remover(String cpf);
	
	boolean ajusteSalarial(double porcentagem);
	
	List<Professor> exibirProfessores();
}
