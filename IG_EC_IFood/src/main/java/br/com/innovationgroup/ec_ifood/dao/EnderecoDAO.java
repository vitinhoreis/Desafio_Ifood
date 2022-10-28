package br.com.innovationgroup.ec_ifood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.innovationgroup.ec_ifood.bo.Endereco;

public class EnderecoDAO implements IDataHandler<Endereco> {
	
	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	@Override
	public List<?> GetAll() {
		
		DAO dao = new DAO();
		
		List<Endereco> listEndereco = new ArrayList<Endereco>();
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_ENDERECO");
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Endereco e = new Endereco();
				e.setCodigo(result.getInt("CD_ENDERECO"));
				e.setCodigoEstabelecimento(result.getInt("CD_ESTABELECIMENTO"));
				e.setLogradouro(result.getString("LOGRADOURO"));
				e.setNrEndereco(result.getString("NR_ENDERECO"));
				e.setCep(result.getInt("CEP"));
			    e.setComplemento(result.getString("COMPLEMENTO"));
				e.setCidade(result.getInt("CD_CIDADE"));
				
				listEndereco.add(e);
			}
			
			return listEndereco;
			
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
	public Endereco GetByID(int id, int cd) {
		
		DAO dao = new DAO();
		PreparedStatement stmt;
	
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_ENDERECO WHERE CD_ENDERECO = ? AND CD_ESTABELECIMENTO = ?");
			stmt.setInt(1, id);
			stmt.setInt(2, cd);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Endereco e = new Endereco();
				e.setCodigo(result.getInt("CD_ENDERECO"));
				e.setCodigoEstabelecimento(result.getInt("CD_ESTABELECIMENTO"));
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
	public int Add(Endereco obj) {
		
		DAO dao = new DAO();
		
		try {
	
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_IC_ENDERECO VALUES (SQ_CDENDERECO.NEXTVAL, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, (int) obj.getCodigoEstabelecimento());
			stmt.setString(2, obj.getLogradouro());
			stmt.setString(3, obj.getNrEndereco());
			stmt.setLong(4, obj.getCep());
			stmt.setString(5, obj.getComplemento());
			stmt.setInt(6, obj.getCidade());
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_IC_ESTABELECIMENTO WHERE CD_ENDERECO = ? AND CD_ESTABELECIMENTO = ?");
			stmt.setInt(1, id);
			stmt.setInt(2, cd);
			return dao.ExecuteCommand(stmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int Update(Endereco obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
