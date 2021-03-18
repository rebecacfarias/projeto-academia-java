package model.dao;

import db.DbManager;
import model.dao.impl.AlunoDao;
import model.dao.impl.CursoDao;
import model.dao.impl.ProfessorDao;

public class DaoFactory {
	
	public static AlunoDao createAlunoDao() {
		return new AlunoDao(DbManager.getConnection());
	}
	
	public static ProfessorDao createProfessorDao() {
		return new ProfessorDao(DbManager.getConnection());
	}
	
	public static CursoDao createCursoDao() {
		return new CursoDao(DbManager.getConnection());
	}
	
}
