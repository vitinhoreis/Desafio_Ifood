package br.com.innovationgroup.ec_ifood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.innovationgroup.ec_ifood.bo.Categoria;

public class CategoriaDAO implements IDataHandler<Categoria> {
	
	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	@Override
	public List<?> GetAll() {
		
		DAO dao = new DAO();
		
		List<Categoria> listCategoria = new ArrayList<Categoria>();
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_CATEGORIA");
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Categoria c = new Categoria();
				c.setCodigo(result.getInt("CD_CATEGORIA"));
				c.setNome(result.getString("NM_CATEGORIA"));
				c.setDescricao(result.getString("DS_CATEGORIA"));
				listCategoria.add(c);
			}
			
			return listCategoria;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//Método responsável por buscar e apresentar valores presentes no Banco de Dados, através do Id
	@Override
	public Categoria GetByID(int id, int cd) {
		
		DAO dao = new DAO();
		PreparedStatement stmt;
	
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_CATEGORIA WHERE CD_CATEGORIA = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Categoria e = new Categoria();
				e.setCodigo(result.getInt("CD_CATEGORIA"));
				return e;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//Método responsável por adicionar valores no Banco de Dados
	@Override
	public int Add(Categoria obj) {
		
		DAO dao = new DAO();
		
		try {
	
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_IC_CATEGORIA VALUES (SQ_CDCATEGORIA.NEXTVAL, ?, ?)");
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getDescricao());
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_IC_CATEGORIA WHERE CD_CATEGORIA = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int Update(Categoria obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
