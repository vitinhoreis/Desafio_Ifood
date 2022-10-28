package br.com.innovationgroup.ec_ifood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.innovationgroup.ec_ifood.bo.Premiacao;

public class PremiacaoDAO implements IDataHandler<Premiacao> {
	
	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	@Override
	public List<?> GetAll() {
		
		DAO dao = new DAO();
		
		List<Premiacao> listPremiacao = new ArrayList<Premiacao>();
		PreparedStatement stmt;
		
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_PREMIACAO");
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Premiacao p = new Premiacao();
				p.setCodigo(result.getInt("CD_PREMIACAO"));
				p.setCodigoEstabelecimento(result.getInt("CD_ESTABELECIMENTO"));
				p.setNome(result.getString("NM_PREMIACAO"));
				p.setDatapremio(result.getDate("DT_PREMIACAO"));
				p.setClassificacao(result.getInt("PREM_CLASSIFICACAO"));
				p.setDescricao(result.getString("DSC_PREMIACAO"));
				listPremiacao.add(p);
			}
			
			return listPremiacao;
			
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
	public Premiacao GetByID(int id, int cd) {
		
		DAO dao = new DAO();
		PreparedStatement stmt;
	
		try {
			
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_IC_PREMIACAO WHERE CD_PREMIACAO = ? AND CD_ESTABELECIMENTO = ?");
			stmt.setInt(1, id);
			stmt.setInt(2, cd);
			ResultSet result = null;
			result = dao.GetData(stmt);
			
			while (result.next()) {
				Premiacao p = new Premiacao();
				p.setCodigo(result.getInt("CD_PREMIACAO"));
				p.setCodigoEstabelecimento(result.getInt("CD_ESTABELECIMENTO"));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//Método responsável por adicionar valores no Banco de Dados
	@Override
	public int Add(Premiacao obj) {
		
		DAO dao = new DAO();
		
		try {
	
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_IC_PREMIACAO VALUES (SQ_CDPREMIACAO.NEXTVAL, ?, ?, ?, ?, ?)");
			stmt.setInt(1, obj.getCodigoEstabelecimento());
			stmt.setString(2, obj.getNome());
			stmt.setDate(3, obj.getDatapremio());
			stmt.setInt(4, obj.getClassificacao());
			stmt.setString(5, obj.getDescricao());
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_IC_PREMIACAO WHERE CD_PREMIACAO = ? AND CD_ESTABELECIMENTO");
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
	public int Update(Premiacao obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
