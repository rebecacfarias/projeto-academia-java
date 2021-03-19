package model.dao.impl;
/*
 * CLASSE ProfessorDao
 * Classe que implementa as operações de CRUD para a tabela professor
 * 
 * */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;
import model.dao.ProfessorDaoContract;
import model.entities.Professor;

public class ProfessorDao implements ProfessorDaoContract {
	
	private Connection connection;
	
	public ProfessorDao(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public boolean inserir(Professor professor) {
		PreparedStatement st = null;
		String sql = "INSERT INTO professor (Nome, Cpf, Idade, Salario) VALUES (?, ?, ?, ?)";
		int updates = 0;
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setString(1, professor.getNome());
			st.setString(2, professor.getCpf());
			st.setInt(3, professor.getIdade());
			st.setDouble(4, professor.getSalario());
			
			updates = st.executeUpdate();
			
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("ERRO - CPF JÁ CADASTRADO.");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
		}
		
		return (updates>0 ? true : false);
	}

	@Override
	public boolean atualizar(Professor professor) {
		PreparedStatement st = null;
		String sql = "UPDATE professor SET Nome = ?, Idade = ?, Salario = ? WHERE Cpf = ?";
		int updates = 0;
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setString(1, professor.getNome());
			st.setInt(2, professor.getIdade());
			st.setDouble(3, professor.getSalario());
			st.setString(4, professor.getCpf());
			
			updates = st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
		}
		
		return (updates>0 ? true : false);
		
	}

	@Override
	public Professor procurar(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM professor WHERE Cpf = ?";
		Professor professor = null;
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setString(1, cpf);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				professor = new Professor();
				professor.setNome(rs.getString("Nome"));
				professor.setCpf(rs.getString("Cpf"));
				professor.setIdade(rs.getInt("Idade"));
				professor.setSalario(rs.getDouble("Salario"));
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
			DbManager.closeResultSet(rs);
		}
		
		return professor;
	}

	@Override
	public boolean remover(String cpf) {
		PreparedStatement st = null;
		String sql = "DELETE FROM professor WHERE Cpf = ?";
		int updates = 0;
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setString(1, cpf);
			
			updates = st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
		}
		
		
		return (updates>0 ? true : false);
	}

	@Override
	public List<Professor> exibirProfessores() {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM professor";
		List<Professor> lista = new ArrayList<>();
		Professor professor;
		
		try {
			st = connection.prepareStatement(sql);
		
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				professor = new Professor();
				professor.setNome(rs.getString("Nome"));
				professor.setCpf(rs.getString("Cpf"));
				professor.setIdade(rs.getInt("Idade"));
				professor.setSalario(rs.getDouble("Salario"));
				
				lista.add(professor);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
			DbManager.closeResultSet(rs);
		}
		
		return lista;
	}
	
	//MÉTODO QUE REALIZA UM AJUSTE SALARIAL BASEADO EM UMA PORCENTAGEM DE AUMENTO
	@Override
	public boolean ajusteSalarial(double porcentagem) {
		PreparedStatement st = null;
		String sql = "UPDATE professor SET Salario = (Salario * ?)";
		int updates = 0;
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setDouble(1, 1+(porcentagem/100));
			
			
			updates = st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
		}
		
		return (updates>0 ? true : false);	
	}

}
