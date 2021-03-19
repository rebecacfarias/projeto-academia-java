package application;
/*Projeto - Academia Java
*		@author: Grupo 2 -
*			Isa Mariana Bernardo
*			Rayanne Augusto
*			Nayara Castro
*			Rebeca Farias
*			
*			
*	CLASSE DE TESTE PARA CRUD NO BANCO DE DADOS
*
* */

import model.dao.DaoFactory;
import model.dao.impl.AlunoDao;
import model.dao.impl.CursoDao;
import model.dao.impl.ProfessorDao;
import model.entities.Aluno;
import model.entities.Curso;
import model.entities.Pessoa;
import model.entities.Professor;

public class TestaBanco {

	public static void main(String[] args) {
		
//	BLOCO DE DECLARAÇÃO E INSTANCIAÇÃO DE OBJETOS TESTE
		   Curso curso1 = new Curso(123, "ADS");
		   Curso curso2 = new Curso(321, "Computação");
		   Curso curso4 = new Curso(101, "Design");

		   Pessoa aluno1 = new Aluno("Nayara", "12345678911", 20, curso1 );
		   Pessoa aluno2 = new Aluno("Rebeca", "12345678912", 20, curso2 );
		   Pessoa aluno3 = new Aluno("Rayanne", "12345678913", 20, curso1);
		   Pessoa aluno4 = new Aluno("Isa", "12345678914", 20, curso1);
		   Pessoa professor1 = new Professor("Juliana", "12345678915", 20, 8000);
		   Pessoa professor2 = new Professor("Julio", "12345678916", 20, 8000);
		   
		 
		   
//	INSTANCIANDO OS DAOS ATRAVÉS DA DAO FACTORY
		   AlunoDao alunoDao = DaoFactory.createAlunoDao();
		   ProfessorDao professorDao = DaoFactory.createProfessorDao();
		   CursoDao cursoDao = DaoFactory.createCursoDao();

		   
		   
/*
 * BLOCO DE TESTES CRUD 
 * (partes de atualização estão comentadas para efeito de visualização das alterações dos dados
 * no momento da apresentação do projeto)
 * */ 
		   
		   System.out.println("\n--------- TENTANDO CADASTRAR PESSOAS JÁ CADASTRADAS ---------");
		   alunoDao.inserir((Aluno) aluno1);
		   alunoDao.inserir((Aluno) aluno2);
		   alunoDao.inserir((Aluno) aluno3);
		   alunoDao.inserir((Aluno) aluno4);
		   professorDao.inserir((Professor)professor1);
		   professorDao.inserir((Professor)professor2);
		   
		   
		   
		   System.out.println("\n\n--------- TENTANDO CADASTRAR ALUNOS EM CURSOS NÃO CADASTRADOS ---------");
		   Curso curso3 = new Curso(333, "Curso que nao existe no banco");
		   alunoDao.inserir(new Aluno("Jurubeba", "12345678955", 20, curso3));
		   
		   
		   
		   System.out.println("\n\n---------- TESTE DE PROCURAR PROFESSOR E ALUNO ----------");
		   
		   System.out.println("\n>>> PROCURANDO PROFESSOR DE CPF 12345678915:");
		   Professor professor = professorDao.procurar("12345678915");
		   System.out.println(professor == null ?"NENHUM DADO ENCONTRADO." : professor);
		   
		   System.out.println("\n>>> PROCURANDO ALUNO DE CPF 100:");
		   Aluno aluno = alunoDao.procurar("100");
		   System.out.println(aluno == null ?"NENHUM DADO ENCONTRADO." : aluno);
		   
		   System.out.println("\n>>> PROCURANDO ALUNO DE CPF 12345678913: ");
		   aluno = alunoDao.procurar("12345678913");
		   System.out.println(aluno == null ? "NENHUM DADO ENCONTRADO" : aluno);
		   
		   System.out.println("\n>>> PROCURANDO PROFESSOR DE CPF 12345678916:");
		   professor = professorDao.procurar("12345678916");
		   System.out.println(professor == null ? "NENHUM DADO ENCONTRADO" : professor);
		   
		   System.out.println("\n>>> PROCURANDO PROFESSOR DE CPF 000:");
		   professor = professorDao.procurar("000");
		   System.out.println(professor == null ? "NENHUM DADO ENCONTRADO" : aluno);
		   

		   

		   System.out.println("\n\n---------- TESTE DE REMOVER PROFESSOR E ALUNO ----------");
		   
		   System.out.println("\n>>> TENTANDO EXCLUIR COM CPF NÃO CADASTRADO:");
		   if(professorDao.remover("005")) {
			   System.out.println("Excluido!");
		   }else{
			   System.out.println("IMPOSSIVEL EXCLUIR - NÃO ENCONTRADO");
		   }
		   
//		   if(professorDao.remover("12345678916")) {
//			   System.out.println("Excluido!");
//		   }else{
//			   System.out.println("IMPOSSIVEL EXCLUIR - NÃO ENCONTRADO");
//		   }
		   	   
		   System.out.println("\n\n---------- TESTE DE ATUALIZAR PROFESSOR E ALUNO ----------");
		   
		   System.out.println("\n>>> TENTANDO ATUALIZAR CURSO PARA CURSO NÃO CADASTRADO");
		   alunoDao.atualizar(new Aluno("Rebeca Farias","12345678912",21, curso3));

		   System.out.println("\n>>> TENTANDO ATUALIZAR ALUNO COM CPF INVALIDO");
		   if(alunoDao.atualizar(new Aluno("Rebeca Farias","000",21, curso3))) {
			   System.out.println("ATUALIZADO!");
		   }else {
			   System.out.println("CPF NÃO ENCONTRADO!");
		   }
		   
		   
//		   System.out.println("\n>>> TENTANDO ATUALIZAR CURSO VÁLIDO");
//		   if(alunoDao.atualizar(new Aluno("Rayanne","12345678913",20, curso4)))
//			   System.out.println("ATUALIZOU!");
//		   else
//			   System.out.println("ERRO!");
		   
		   System.out.println("\n>>> TENTANDO ATUALIZAR PROFESSOR COM CPF INVALIDO");
		   if(professorDao.atualizar(new Professor("Juliana Mafra", "000", 20, 8000))) {
			   System.out.println("ATUALIZADO!");
		   }else {
			   System.out.println("CPF NÃO ENCONTRADO!");
		   }
		   
//		   System.out.println("\n>>> TENTANDO ATUALIZAR IDADE E NOME DE ALUNO");
//		   if(alunoDao.atualizar(new Aluno("Rebeca Farias","12345678912",21, curso2))) {
//			   System.out.println("ATUALIZADO!");
//		   }else {
//			   System.out.println("CPF NÃO ENCONTRADO!");
//		   }
		   
//		   System.out.println("\n>>> TENTANDO ATUALIZAR IDADE E SALARIO DE PROFESSOR");
//		   if(professorDao.atualizar(new Professor("Juliana Mafra", "12345678915", 20, 10000))) {
//			   System.out.println("ATUALIZADO!");
//		   }else {
//			   System.out.println("CPF NÃO ENCONTRADO!");
//		   }
//		   
		   
		   System.out.println("\n\n---------- TESTE DE EXIBIR PROFESSOR E ALUNO ----------");

		   System.out.println("PROFESSORES: ");
		   for(Professor p : professorDao.exibirProfessores()) {
			   System.out.println(p);
		   }
		   
		   System.out.println("ALUNOS: ");
		   for(Aluno a : alunoDao.exibirAlunos()) {
			   System.out.println(a);
		   }
		   
		   System.out.println("\n\n---------- TESTE DE EXIBIR ALUNO POR CURSO ----------");
		   for(Aluno a : alunoDao.alunoPorCurso(123)) {
			   System.out.println(a);
		   }
		   
		   
//		   System.out.println("\n\n---------- ADICIONANDO AJUSTE NO SALÁRIO DOS PROFs ----------");
//		   professorDao.ajusteSalarial(5);
		   

		   System.out.println("\n\n---------- TESTE TABELA CURSO ----------");
		   
		   System.out.println("\n>>> TENTANDO INSERIR CURSO JÁ CADSATRADO");
		   cursoDao.inserir(curso1);
//		   cursoDao.inserir(curso2);
//		   cursoDao.inserir(new Curso(101, "Design"));
		   System.out.println("\n>>> TENTANDO EXCLUIR CURSOS COM ALUNOS CADASTRADOS: ");
		   cursoDao.remover(123);
		   
		   
		   System.out.println("\n>>> EXIBINDO CURSOS");
		   for(Curso c : cursoDao.exibirCurso()) {
			   System.out.println(c);
		   }

	}

}
