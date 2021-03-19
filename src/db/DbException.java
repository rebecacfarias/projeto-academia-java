package db;
/*
 * CLASSE DbException
 * Subclasse de RuntimeException
 * Exceção personalizada para lidar com as operações feitas no banco de dados
 * 
 * OBS: Para fins de visualização, o tratamento foi feito exibindo mensagens no console, e não lançando a exceção;
 * 
 * */

public class DbException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DbException(String message) {
		super(message);
	}
	
}
