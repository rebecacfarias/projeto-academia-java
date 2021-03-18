package validation;

public final class ValidateFields {
	
	public static String formatCpf(String cpf) {
		cpf = cpf.toUpperCase().replaceAll("[A-Z]*", "");
		cpf = cpf.replaceAll("\\.", "");
		cpf = cpf.replaceAll("-", "");
		
		return cpf;
	}
	
	
	public static boolean cpfIsValid(String cpf) {
		cpf = formatCpf(cpf);
		if(cpf.length() == 11) {
			return true;
		}
		return false;
	}
	
	//FALTA
	public static boolean cpfAlreadyExists(String cpf) {
		//buscar no banco aqui baseado no findByCpf
		
		return false;
	}
	
	//FALTA testar para n�o gerar exce��o, adicionar remo��o de caracteres invalidos
	/*
	 * M�todo para formata��o dos nomes
	 * Primeira letra de cada nome mai�scula
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
	
	//FALTA
	public static boolean courseAlreadyExists(Double codigo) {
		//checar se t� no banco findByCodigo

		return false;
	}
	
	
	
}
