package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;
import model.dao.CursoDaoContract;
import model.entities.Curso;

public class CursoDao implements CursoDaoContract {
	private Connection connection;
	
	public CursoDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean inserir(Curso curso) {
		PreparedStatement st = null;
		String sql = "INSERT INTO curso (Codigo, Nome) VALUES (?, ?)";
		int updates = 0;
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setDouble(1, curso.getCodigo());
			st.setString(2, curso.getNome());

			
			updates = st.executeUpdate();
			
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("ERRO - CODIGO JÁ CADASTRADO.");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
		}
		
		return (updates>0 ? true : false);
	}

	@Override
	public boolean atualizar(Curso curso) {
		PreparedStatement st = null;
		String sql = "UPDATE curso SET Nome = ? WHERE Codigo = ?";
		int updates = 0;
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setString(1, curso.getNome());
			st.setDouble(2, curso.getCodigo());
			
			updates = st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
		}
		
		return (updates>0 ? true : false);
		
	}

	@Override
	public Curso procurar(double codigo) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM curso WHERE Codigo = ?";
		Curso curso = null;
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setDouble(1, codigo);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				curso = new Curso();
				curso.setNome(rs.getString("Nome"));
				curso.setCodigo(rs.getDouble("Codigo"));
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
			DbManager.closeResultSet(rs);
		}
		
		return curso;
		
	}

	@Override
	public boolean remover(double codigo) {
		PreparedStatement st = null;
		String sql = "DELETE FROM curso WHERE Codigo = ?";
		int updates = 0;
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setDouble(1, codigo);
			
			updates = st.executeUpdate();
			
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("ERRO - CURSO NAO PODE SER REMOVIDO.");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
		}
		
		
		return (updates>0 ? true : false);
	}
	
	
	@Override
	public List<Curso> exibirCurso(){
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM curso";
		List<Curso> lista = new ArrayList<>();
		Curso curso;
		
		try {
			st = connection.prepareStatement(sql);
		
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				curso = new Curso();
				curso.setNome(rs.getString("Nome"));
				curso.setCodigo(rs.getDouble("Codigo"));
				
				lista.add(curso);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
			DbManager.closeResultSet(rs);
		}
		
		return lista;
	}
	
	
}
