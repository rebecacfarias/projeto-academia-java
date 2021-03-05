package entities;

public class Curso {
	private double codigo;
	private String nome;
	
	
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
	
	public String toString(){
		    return "Nome: "+nome+", Codigo: "+codigo;
	}
	
}
