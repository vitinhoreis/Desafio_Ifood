package br.com.innovationgroup.ec_ifood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.innovationgroup.ec_ifood.bo.Responsavel;

public class ResponsavelDAO implements IDataHandler<Responsavel> {
	
	
	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	@Override
	public List<?> GetAll() {
		
		DAO dao = new DAO();
		
		List<Responsavel> listResponsavel = new ArrayList<Responsavel>();
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_RESPONSAVEL");
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Responsavel r = new Responsavel();
				r.setCodigo(result.getInt("CD_RESPONSAVEL"));
				r.setCodigoEstabelecimento(result.getInt("CD_ESTABELECIMENTO"));
				r.setNome(result.getString("NM_RESPONSAVEL"));
				r.setCpf(result.getString("CPF_RESPONSAVEL"));
				r.setRg(result.getString("RG_RESPONSAVEL"));

				
				listResponsavel.add(r);
			}
			
			return listResponsavel;
			
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
	public Responsavel GetByID(int id, int cd) {
		
		DAO dao = new DAO();
		PreparedStatement stmt;
	
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_RESPONSAVEL WHERE CD_RESPONSAVEL = ? AND CD_ESTABELECIMENTO = ?");
			stmt.setInt(1, id);
			stmt.setInt(2, cd);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Responsavel r = new Responsavel();
				r.setCodigo(result.getInt("CD_RESPONSAVEL"));
				r.setCodigoEstabelecimento(result.getInt("CD_ESTABELECIMENTO"));
				return r;
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
	public int Add(Responsavel obj) {
		
		DAO dao = new DAO();
		
		try {
	
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_IC_RESPONSAVEL VALUES (SQ_CDRESPONSAVEL.NEXTVAL, ?, ?, ?, ?)");
			stmt.setLong(1, obj.getCodigoEstabelecimento());
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getCpf());
			stmt.setString(4, obj.getRg());
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_IC_RESPONSAVEL WHERE CD_RESPONSAVEL = ? AND CD_ESTABELECIMENTO = ?");
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
	public int Update(Responsavel obj) {
		// TODO Auto-generated method stub
		return 0;
	}


}
