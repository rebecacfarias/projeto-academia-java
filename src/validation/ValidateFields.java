package validation;

/*
 * CLASSE ValidateFields
 * Classe que possui métodos estáticos para validar entradas de usuário
 * OBS: classe feita para ser utilizada em testes que solicitam os dados do usuário
 * 
 * */

public final class ValidateFields {
	
	// FORMATAR CPF
	public static String formatCpf(String cpf) {
		cpf = cpf.toUpperCase().replaceAll("[A-Z]*", "");
		cpf = cpf.replaceAll("\\.", "");
		cpf = cpf.replaceAll("-", "");
		
		return cpf;
	}
	
	// CHECAR VALIDADE DO CPF
	public static boolean cpfIsValid(String cpf) {
		if(cpf.length() == 11) {
			return true;
		}
		return false;
	}

	
	/*
	 * Método para formatação dos nomes
	 * Primeira letra de cada nome maiúscula
	 * */
	public static String formatName(String name) {
		name = name.trim();
		String[] fullName = name.split(" +");
		String formatedName = "";
		for(int i = 0; i<fullName.length; i++) {
			if(fullName[i].length()<1) {
				fullName[i] = fullName[i].toUpperCase();
			}else {
				fullName[i] = fullName[i].substring(0,1).toUpperCase().concat(fullName[i].substring(1));
				formatedName+=fullName[i]+" ";
			}
		}

		return formatedName.trim();
	}

}
