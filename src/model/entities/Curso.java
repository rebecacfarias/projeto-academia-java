package model.entities;
/* CLASSE CURSO
 * OBS: A classe Curso se relaciona com a classe Aluno;
 * 
 * */

public class Curso {
	private double codigo;
	private String nome;
	
	
	public Curso() {
		codigo = 0;
		nome = null;
	}
	
	public Curso(double codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}


	public double getCodigo() {
		return codigo;
	}


	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString(){
		    return "Nome: "+nome+", Codigo: "+codigo;
	}
	
}
