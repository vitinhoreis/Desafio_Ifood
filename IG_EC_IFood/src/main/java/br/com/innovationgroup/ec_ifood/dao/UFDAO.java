package br.com.innovationgroup.ec_ifood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.innovationgroup.ec_ifood.bo.UF;

public class UFDAO implements IDataHandler<UF>{
	
	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	@Override
	public List<?> GetAll() {
		
		DAO dao = new DAO();
		
		List<UF> listaUFs = new ArrayList<UF>();
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_UF");
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				UF c = new UF();
				c.setCodigo(result.getInt("CD_UF"));
				c.setNome(result.getString("NOME"));
				c.setSigla(result.getString("SIGLA"));
				listaUFs.add(c);
			}
			
			return listaUFs;
			
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
	public UF GetByID(int id, int cd) {
		
		DAO dao = new DAO();
		PreparedStatement stmt;
	
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_UF WHERE CD_UF = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				UF e = new UF();
				e.setCodigo(result.getInt("CD_UF"));
				return e;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dao.CloseConnection();
		}
		return null;
	}
	
	//Método responsável por adicionar valores no Banco de Dados
	@Override
	public int Add(UF obj) {
		
		DAO dao = new DAO();
		
		try {
	
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_IC_UF VALUES (SQ_CD_UF.NEXTVAL, ?, ?)");
			stmt.setString(1, obj.getSigla());
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_IC_UF WHERE CD_UF = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int Update(UF obj) {
		// TODO Auto-generated method stub
		return 0;
	}


}
