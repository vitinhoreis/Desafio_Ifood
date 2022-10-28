package br.com.innovationgroup.ec_ifood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.innovationgroup.ec_ifood.bo.Cidade;

public class CidadeDAO implements IDataHandler<Cidade>{
	
	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	public List<?> GetAll(int codUF) {
		
		DAO dao = new DAO();
		
		List<Cidade> listaCidades = new ArrayList<Cidade>();
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_CIDADE WHERE CD_UF = ? ORDER BY NM_CIDADE ASC");
			stmt.setInt(1, codUF);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Cidade c = new Cidade();
				c.setCodigo(result.getInt("CD_CIDADE"));
				c.setNome(result.getString("NM_CIDADE"));
				listaCidades.add(c);
			}
			
			return listaCidades;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.CloseConnection();
		}
		
		return null;
	}
	
	//Método responsável por buscar e apresentar valores presentes no Banco de Dados, através do Id
	@Override
	public Cidade GetByID(int id, int cd) {
		
		DAO dao = new DAO();
		PreparedStatement stmt;
	
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_CIDADE WHERE CD_CIDADE = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Cidade e = new Cidade();
				e.setCodigo(result.getInt("CD_CIDADE"));
				e.setCodigoUf(result.getInt("CD_UF"));
				e.setNome(result.getString("NM_CIDADE"));
				return e;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.CloseConnection();
		}
		return null;
	}
	
	//Método responsável por adicionar valores no Banco de Dados
	@Override
	public int Add(Cidade obj) {
		
		DAO dao = new DAO();
		
		try {
	
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_IC_CIDADE VALUES (SQ_CD_CIDADE.NEXTVAL, ?, ?)");
			stmt.setInt(1, obj.getCodigoUf());
			stmt.setString(2, obj.getNome());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//Método responsável por deletar valores do Banco de Dados
	@Override
	public int Delete(int id, int cd) {
		
		DAO dao;
		
		PreparedStatement stmt;
		try {
			
			dao = new DAO();
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_IC_CIDADE WHERE CD_CIDADE = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int Update(Cidade obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
