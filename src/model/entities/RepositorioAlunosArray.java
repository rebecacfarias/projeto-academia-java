package model.entities;

public class RepositorioAlunosArray {
	private Aluno[] alunos;
	private int indice;
	
	public RepositorioAlunosArray(int tamanho) {
		alunos = new Aluno[tamanho];
		indice = 0;
	}
	
	public void inserir(Aluno c) {
		alunos[indice] = c;
		indice++;
	}
	
	public Aluno procurar(String numCPF) {
		Aluno aluno = null;
		
		for(Aluno a : alunos) {
			if(a!=null && a.getCpf().equals(numCPF)) 
				aluno = a;
		}
		
		return aluno;
	}
	
	public void remover(String numCPF) {
		for(int i = 0; i<alunos.length; i++) {
			Aluno aux = alunos[i];
			
			if(aux!=null && aux.getCpf().equals(numCPF)) {
				alunos[i] = alunos[indice-1];
				alunos[indice - 1] = null;
				
				indice--;
			}
			
		}
	}
	
	
	public void exibir() {
		for(Aluno a: alunos){
			if(a!=null)
				System.out.println(a);
		}
	}
	
	
	
	

	
}
