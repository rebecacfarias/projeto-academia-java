package application;
/*Projeto - Academia Java
 *		@author: Grupo 2 -
			Isa Mariana Bernardo
			Rayanne Augusto
			Nayara Castro
			Rebeca Farias
* */


import model.dao.DaoFactory;
import model.dao.impl.AlunoDao;
import model.dao.impl.CursoDao;
import model.dao.impl.ProfessorDao;
import model.entities.Aluno;
import model.entities.Curso;
import model.entities.Pessoa;
import model.entities.Professor;

public class TestaPessoa {
	public static void main(String[] args){

		   Curso curso1 = new Curso(123, "ADS");
		   Curso curso2 = new Curso(321, "Computação");

		   Pessoa aluno1 = new Aluno("Nayara", "001", 20, curso1 );
		   Pessoa aluno2 = new Aluno("Rebeca", "002", 20, curso2 );
		   Pessoa aluno3 = new Aluno("Rayanne", "003", 20, curso1);
		   Pessoa aluno4 = new Aluno("Isa", "004", 20, curso1);
		   Pessoa professor1 = new Professor("Juliana", "005", 26, 8000);
		   Pessoa professor2 = new Professor("Julio", "006", 20, 8000);
		   
		   //RepositorioPessoa rep = new RepositorioPessoaLista();
		   //RepositorioPessoa rep = new RepositorioPessoaArray(6);
		   
		   AlunoDao alunoDao = DaoFactory.createAlunoDao();
		   ProfessorDao professorDao = DaoFactory.createProfessorDao();
		   CursoDao cursoDao = DaoFactory.createCursoDao();
		   

		   
		   professorDao.atualizar((Professor)professor1);
		   professorDao.inserir((Professor)professor2);
		   
		   Professor professor = professorDao.procurar("005");
		   
		   System.out.println(professor);
		   

		   

		   
		   if(professorDao.remover("005")) {
			   System.out.println("Excluido!");
		   }else{
			   System.out.println("IMPOSSIVEL EXCLUIR - NÃO ENCONTRADO");
		   }
		   
		   for(Professor p : professorDao.exibirProfessores()) {
			   System.out.println(p);
		   }
		   
		   
		   System.out.println("---------- TESTE TABELA CURSO ----------");
		   
//		   cursoDao.inserir(curso1);
//		   cursoDao.inserir(curso2);
//		   cursoDao.inserir(new Curso(101, "Design"));
		   
		   cursoDao.remover(123);
		   
		   
		   System.out.println("---------- TESTE TABELA ALUNO ----------");
		   
//		   alunoDao.inserir((Aluno)aluno1);
//		   alunoDao.inserir((Aluno)aluno2);
//		   alunoDao.inserir((Aluno)aluno3);
//		   alunoDao.inserir((Aluno)aluno4);
		   
//		   alunoDao.remover("001");
		   
		   for(Aluno a : alunoDao.exibirAlunos()) {
			   System.out.println(a);
		   }
		   
		   System.out.println(alunoDao.procurar("002"));
		   
		   
		   
		   
		   
		   
//		   
//		   try {
//			   rep.inserir(aluno1);
//			   rep.inserir(aluno2);
//			   rep.inserir(aluno3);
//			   rep.inserir(aluno4);
//			   rep.inserir(professor1);
//			   rep.inserir(professor2);
//		   }catch(InsertException e){
//			   System.out.println("");
//			   System.out.println(e.getMessage());
//		   }
//
//
//		   System.out.println("\n\n---------- TESTE DE PROCURAR ----------\n");
//		   Pessoa alunoProcurado = rep.procurar("003");
//		   
//		   if(alunoProcurado != null)
//			   System.out.println("PESSOA PROCURADA(003): " + alunoProcurado);
//		   else 
//			   System.out.println("PESSOA NÃO ENCONTRADO!"); 
//
//		   System.out.println("\n\n---------- TESTE DE REMOÇÃO, INSERÇÃO E EXIBIÇÃO ----------");
//		   
//		   System.out.println("\n>>>>> LISTA DE PESSOAS ANTES DA REMOÇÃO <<<<<<");
//		   rep.exibir();
//		   
//		   rep.remover("003");
//		   rep.remover("005");
//
//		   System.out.println("\n\n>>>>> LISTA DE PESSOAS ATUALIZADA <<<<<<");
//		   System.out.println("(CPF a ser removido: 005, 003)\n");
//		   rep.exibir();
//		   
//		   
//		   System.out.println("\n\n---------- PROCURANDO PESSOA APAGADA ----------\n");
//		   if(rep.procurar("005") == null) 
//			   System.out.println("NÃO ENCONTRADO! APAGOU!");
//		   else 
//			   System.out.println("ENCONTRADO! NÃO APAGOU!");
//		   
//		   System.out.println("\n\n---------- TENTANDO REMOVER PESSOA APAGADA ----------\n");
//		   rep.remover("003");
	}
}
