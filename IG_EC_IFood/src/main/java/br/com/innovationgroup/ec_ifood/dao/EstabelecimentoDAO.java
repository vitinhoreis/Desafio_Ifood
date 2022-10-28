package br.com.innovationgroup.ec_ifood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.innovationgroup.ec_ifood.bo.Estabelecimento;

public class EstabelecimentoDAO implements IDataHandler<Estabelecimento> {
	
	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	@Override
	public List<?> GetAll() {
		
		DAO dao = new DAO();
		
		List<Estabelecimento> listEstabelecimento = new ArrayList<Estabelecimento>();
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_ESTABELECIMENTO");
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Estabelecimento e = new Estabelecimento();
				e.setCodigo(result.getInt("CD_ESTABELECIMENTO"));
				e.setCnpj(result.getString("NR_CNPJ"));
				e.setNome(result.getString("NM_ESTABELECIMENTO"));
				e.setRazaoSocial(result.getString("RAZAO_SOCIAL"));
				e.setTelefone(result.getString("NR_TELEFONE"));
				e.setCodigoUsuarioCriacao(result.getInt("CD_CONTATO_CRIACAO"));
				e.setCodigocategoria(result.getInt("CD_CATEGORIA"));
						
				listEstabelecimento.add(e);
			}
			
			return listEstabelecimento;
			
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
	public Estabelecimento GetByID(int id, int cd) {
		
		DAO dao = new DAO();
		PreparedStatement stmt;
	
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_ESTABELECIMENTO WHERE CD_ESTABELECIMENTO = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Estabelecimento e = new Estabelecimento();
				e.setCodigo(result.getInt("CD_ESTABELECIMENTO"));
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
	public int Add(Estabelecimento obj) {
		
		DAO dao = new DAO();
		
		try {
	
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_IC_ESTABELECIMENTO VALUES (SQ_CDESTABELECIMENTO.NEXTVAL, ?, ?, ?, ?, ?)",
			           Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getCnpj());
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getRazaoSocial());
			stmt.setString(4, obj.getTelefone());
			stmt.setInt(5, obj.getCodigoUsuarioCriacao());
			
			return dao.ExecuteCommandInsert(stmt, "SQ_CDESTABELECIMENTO");
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_IC_ESTABELECIMENTO WHERE CD_ESTABELECIMENTO = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int Update(Estabelecimento obj) {
		// TODO Auto-generated method stub
		return 0;
	}


}
