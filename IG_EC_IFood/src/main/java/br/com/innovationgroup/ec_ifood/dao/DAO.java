package br.com.innovationgroup.ec_ifood.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	
	private Connection connection;
	
	public DAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//M�todo para obter conex�o com o banco de dados
	public Connection GetConnection() {
		
		OpenConnection();	
		System.out.println("Conex�o aberta com sucesso!");
		return this.connection;
		
	}
	
	//M�todo respons�vel por abrir a conex�o
	private void OpenConnection() {
		
		try {
			this.connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM88634", "151087");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//M�todo respons�vel por fechar a conex�o
	public void CloseConnection() {
		
		try {
		if (this.connection != null) {
				this.connection.close();
			} 
			this.connection.close();
			System.out.println("Conex�o fechada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//M�todo respons�vel por executar os comandos SQL (insert, update, delete)
	public int ExecuteCommand(PreparedStatement stmt) {
				 	 
		int j = 0;
		
		try {
			j = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		
		return j;
		
	}
	
	
	public int ExecuteCommandInsert(PreparedStatement stmt, String sequencia) {
		int generatedKey = 0;
	
		try {
			stmt.execute();
			 
			PreparedStatement ps = connection
			        .prepareStatement("select " + sequencia +" .currval from dual");
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			    generatedKey = (int) rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		
		return generatedKey;
		
	}
	//M�todo respons�vel por mostrar o n�mero de linhas alteradas
	public ResultSet GetData(PreparedStatement stmt) {
		
		ResultSet resultSet = null;
		
		try {
			resultSet = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}

}
