package br.com.innovationgroup.ec_ifood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.innovationgroup.ec_ifood.bo.Contato;

public class ContatoDAO implements IDataHandler<Contato>{
	
	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	@Override
	public List<?> GetAll() {
		
		DAO dao = new DAO();
		
		List<Contato> listContato = new ArrayList<Contato>();
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_CONTATO");
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Contato c = new Contato();
				c.setCodigo(result.getInt("CD_CONTATO"));
				c.setNome(result.getString("NM_CONTATO"));
				c.setEmail(result.getString("EMAIL_CONTATO"));
				c.setTelefone(result.getString("TEL_CONTATO"));
				listContato.add(c);
			}
			
			return listContato;
			
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
	public Contato GetByID(int id, int cd) {
		
		DAO dao = new DAO();
		PreparedStatement stmt;
	
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_CONTATO WHERE CD_CONTATO = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Contato e = new Contato();
				e.setCodigo(result.getInt("CD_CONTATO"));
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
	public int Add(Contato obj) {
		
		DAO dao = new DAO();
		
		try {
	
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_IC_CONTATO VALUES (SQ_CD_CONTATO.NEXTVAL, ?, ?, ?)",
           Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getEmail());
			stmt.setString(3, obj.getTelefone());
			return dao.ExecuteCommandInsert(stmt, "SQ_CD_CONTATO");
					
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_IC_CONTATO WHERE CD_CONTATO = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int Update(Contato obj) {
		// TODO Auto-generated method stub
		return 0;
	}


}
