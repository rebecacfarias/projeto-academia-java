package model.dao;

import java.util.List;

import model.entities.Professor;

public interface ProfessorDaoContract {
	boolean inserir(Professor professor);
	
	boolean atualizar(Professor professor);
	
	Professor procurar(String cpf);
	
	boolean remover(String cpf);
	
	boolean adicionarBonusAnual(Double porcentagem);
	
	List<Professor> exibirProfessores();
}
