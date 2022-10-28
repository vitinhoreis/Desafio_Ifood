package br.com.innovationgroup.ec_ifood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.innovationgroup.ec_ifood.bo.Valor;

public class ValorDAO implements IDataHandler<Valor>{
	
	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	@Override
	public List<?> GetAll() {
		
		DAO dao = new DAO();
		
		List<Valor> lista = new ArrayList<Valor>();
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_VALOR");
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Valor c = new Valor();
				c.setCodigo(result.getInt("CD_VALOR"));
				c.setDescricao(result.getString("DS_VALOR"));
				c.setCodigoEstabelecimento(result.getInt("CD_ESTABELECIMENTO"));
				lista.add(c);
			}
			
			return lista;
			
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
	public Valor GetByID(int id, int cd) {
		
		DAO dao = new DAO();
		PreparedStatement stmt;
	
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_VALOR WHERE CD_VALOR = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Valor e = new Valor();
				e.setCodigo(result.getInt("CD_VALOR"));
				e.setDescricao(result.getString("DS_VALOR"));
				e.setCodigoEstabelecimento(result.getInt("CD_ESTABELECIMENTO"));
				
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
	public int Add(Valor obj) {
		
		DAO dao = new DAO();
		
		try {
	
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_IC_VALOR VALUES (SQ_CD_VALOR.NEXTVAL, ?, ?)");
			stmt.setString(1, obj.getDescricao());
			stmt.setInt(2, obj.getCodigoEstabelecimento());
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_IC_VALOR WHERE CD_UF = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int Update(Valor obj) {
		// TODO Auto-generated method stub
		return 0;
	}


}
