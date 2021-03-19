package model.entities;
/*
 * CLASSE PROFESSOR
 * OBS: Subclasse de Pessoa
 *      Relaciona-se com a classe Curso
 *      
 * */

public class Aluno extends Pessoa{
	
	private Curso curso;
	
	public Aluno() {
		super();
		curso = null;
	}
	
	public Aluno(String nome, String cpf, int idade, Curso curso) {
		super(nome, cpf, idade);
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return super.toString()+", Curso: " + curso.getNome();
	}

}
