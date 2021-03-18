package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;
import model.dao.AlunoDaoContract;
import model.dao.DaoFactory;
import model.entities.Aluno;
import model.entities.Curso;

public class AlunoDao implements AlunoDaoContract {
	
	private Connection connection;
	
	public AlunoDao(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public boolean inserir(Aluno aluno) {
		PreparedStatement st = null;
		String sql = "INSERT INTO aluno (Nome, Cpf, Idade, CursoCodigo) VALUES (?, ?, ?, ?)";
		int updates = 0;
		CursoDao cursoDao = DaoFactory.createCursoDao();
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getCpf());
			st.setInt(3, aluno.getIdade());
			st.setDouble(4, aluno.getCurso().getCodigo());
			
			updates = st.executeUpdate();
			
		}catch(SQLIntegrityConstraintViolationException e){
			if(cursoDao.procurar(aluno.getCurso().getCodigo()) == null) {
				System.out.println("ERRO - CODIGO DO CURSO INVALIDO");
			}else {
				System.out.println("ERRO - CPF JÁ CADASTRADO");
			}	
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
		}
		
		return (updates>0 ? true : false);
	}

	@Override
	public boolean atualizar(Aluno aluno) {
		PreparedStatement st = null;
		String sql = "UPDATE aluno SET Nome = ?, Idade = ?, CursoCodigo = ? WHERE Cpf = ?";
		int updates = 0;
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setString(1, aluno.getNome());
			st.setInt(2, aluno.getIdade());
			st.setDouble(3, aluno.getCurso().getCodigo());
			st.setString(4, aluno.getCpf());
			
			updates = st.executeUpdate();
			
		}catch(SQLIntegrityConstraintViolationException e){
			System.out.println("ERRO - CODIGO DO CURSO INVALIDO");
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
		}
		
		return (updates>0 ? true : false);
		
	}
	
	
	@Override
	public Aluno procurar(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM aluno WHERE Cpf = ?";
		Aluno aluno = null;
		CursoDao cursoDao = DaoFactory.createCursoDao();
		
		try {
			st = connection.prepareStatement(sql);
			
			st.setString(1, cpf);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				aluno = new Aluno();
				aluno.setNome(rs.getString("Nome"));
				aluno.setCpf(rs.getString("Cpf"));
				aluno.setIdade(rs.getInt("Idade"));
				aluno.setCurso(cursoDao.procurar(rs.getDouble("CursoCodigo")));
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
			DbManager.closeResultSet(rs);
		}
		
		return aluno;
	}

	@Override
	public boolean remover(String cpf) {
		PreparedStatement st = null;
		String sql = "DELETE FROM aluno WHERE Cpf = ?";
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
	public List<Aluno> exibirAlunos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM aluno";
		List<Aluno> lista = new ArrayList<>();
		Aluno aluno;
		CursoDao cursoDao = DaoFactory.createCursoDao();
		
		try {
			st = connection.prepareStatement(sql);
		
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				aluno = new Aluno();
				aluno.setNome(rs.getString("Nome"));
				aluno.setCpf(rs.getString("Cpf"));
				aluno.setIdade(rs.getInt("Idade"));
				aluno.setCurso(cursoDao.procurar(rs.getDouble("CursoCodigo")));
				
				lista.add(aluno);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbManager.closeStatement(st);
			DbManager.closeResultSet(rs);
		}
		
		return lista;
	}

	@Override
	public List<Aluno> alunoPorCurso(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

}
