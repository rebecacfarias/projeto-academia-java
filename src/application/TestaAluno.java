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

public class TestaAluno {
	public static void main(String[] args){

		   Curso curso1 = new Curso(123, "ADS");
		   Curso curso2 = new Curso(321, "Computação");

		   Aluno aluno1 = new Aluno("Nayara", "12345678", 20, curso1 );
		   Aluno aluno2 = new Aluno("Rebeca", "87654321", 20, curso2 );
		   Aluno aluno3 = new Aluno("Rayanne", "24681357", 20, curso1);

		  System.out.println("ALUNOS");
		  System.out.println(aluno1.toString());
		  System.out.println(aluno2.toString());
		  System.out.println(aluno3.toString());
		  
		  System.out.println("CURSOS");
		  System.out.println(curso1.toString());
		  System.out.println(curso2.toString());
		  System.out.println(curso1.getNome());
		  System.out.println(curso2.getNome());

		  }
}
