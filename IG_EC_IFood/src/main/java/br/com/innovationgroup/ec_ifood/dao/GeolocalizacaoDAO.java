package br.com.innovationgroup.ec_ifood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.innovationgroup.ec_ifood.bo.Geolocalizacao;

public class GeolocalizacaoDAO implements IDataHandler<Geolocalizacao>{	
	
	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	@Override
	public List<?> GetAll() {
		
		DAO dao = new DAO();
		
		List<Geolocalizacao> listGeolocalizacao = new ArrayList<Geolocalizacao>();
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_GEO");
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Geolocalizacao g = new Geolocalizacao();
				g.setCodigo(result.getInt("CD_GEOCODE"));
				g.setCodigoEstabelecimento(result.getInt("CD_ESTABELECIMENTO"));
				g.setGeoCode(result.getString("GEO_CODE"));
				g.setComplemento(result.getString("COMPLEMENTO"));
				listGeolocalizacao.add(g);
			}
			
			return listGeolocalizacao;
			
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
	public Geolocalizacao GetByID(int id, int cd) {
		
		DAO dao = new DAO();
		PreparedStatement stmt;
	
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_GEO WHERE CD_GEOCODE = ? AND CD_ESTABELECIMENTO = ?");
			stmt.setInt(1, id);
			stmt.setInt(2, cd);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Geolocalizacao g = new Geolocalizacao();
				g.setCodigo(result.getInt("CD_GEOCODE"));
				g.setCodigoEstabelecimento(result.getInt("CD_ESTABELECIMENTO"));
				return g;
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
	public int Add(Geolocalizacao obj) {
		
		DAO dao = new DAO();
		
		try {
	
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_IC_GEO VALUES (SQ_CDGEO.NEXTVAL, ?, ?, ?)");
			stmt.setLong(1, obj.getCodigoEstabelecimento());
			stmt.setString(2, obj.getGeoCode());
			stmt.setString(3, obj.getComplemento());
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_IC_GEO WHERE CD_GEOCODE = ?");
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
	public int Update(Geolocalizacao obj) {
		// TODO Auto-generated method stub
		return 0;
	}


}
