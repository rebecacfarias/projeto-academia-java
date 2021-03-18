package application;

import validation.ValidateFields;

public class TestaValidacao {

	public static void main(String[] args) {
		String cpf = "119.942.544-32";
		
		System.out.println(ValidateFields.cpfIsValid(cpf));
		cpf = ValidateFields.formatCpf(cpf);
		System.out.println(cpf);
		
		String name = "    rebeca   farias  ";
		name = ValidateFields.formatName(name);
		System.out.println(name);
		
		

	}

}
