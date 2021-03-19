package model.data.exceptions;
/*
 * CLASSE InsertException (subclasse de Exception)
 * Exceção personalizada para lidar com o limite de inserção no RepositorioPessoaArray
 *  
 * */

public class InsertException extends Exception{
	private static final long serialVersionUID = 1L;

	public InsertException() {
		super("Array cheio!");
	}

}
