package application;
/*Projeto - Academia Java
 *		@author: Grupo 2 -
			Isa Mariana Bernardo
			Rayanne Augusto
			Nayara Castro
			Rebeca Farias
 * */


import model.entities.Aluno;
import model.entities.Curso;
import model.entities.RepositorioAlunosArray;

public class TestaAluno {
	public static void main(String[] args){

		   Curso curso1 = new Curso(123, "ADS");
		   Curso curso2 = new Curso(321, "Computação");

		   Aluno aluno1 = new Aluno("Nayara", "001", 20, curso1 );
		   Aluno aluno2 = new Aluno("Rebeca", "002", 20, curso2 );
		   Aluno aluno3 = new Aluno("Rayanne", "003", 20, curso1);
		   Aluno aluno4 = new Aluno("Isa", "004", 20, curso1);
		   Aluno aluno5 = new Aluno("Jurubeba", "005", 20, curso1);
		   
		   RepositorioAlunosArray rep = new RepositorioAlunosArray(5);

		   rep.inserir(aluno1);
		   rep.inserir(aluno2);
		   rep.inserir(aluno3);
		   rep.inserir(aluno4);
		   rep.inserir(aluno5);

		   System.out.println("\n\n---------- TESTE DE PROCURAR ----------\n");
		   Aluno alunoProcurado = rep.procurar("003");
		   if(alunoProcurado != null)
			   System.out.println("ALUNO PROCURADO(003): " + alunoProcurado);
		   else 
			   System.out.println("ALUNO NÃO ENCONTRADO!"); 

		   System.out.println("\n\n---------- TESTE DE REMOÇÃO, INSERÇÃO E EXIBIÇÃO ----------");
		   System.out.println("\nLISTA DE ALUNOS: \n");
		   rep.exibir();
		   
		   rep.remover("005");

		   System.out.println("\n\nLISTA DE ALUNOS ATUALIZADA: ");
		   System.out.println("(CPF a ser removido: 005)\n");
		   rep.exibir();
		   
		   
		   System.out.println("\n\n---------- PROCURANDO ALUNO APAGADO ----------\n");
		   if(rep.procurar("005") == null) 
			   System.out.println("NÃO ENCONTRADO! APAGOU!");
		   else 
			   System.out.println("ENCONTRADO! NÃO APAGOU!");
	}
}
