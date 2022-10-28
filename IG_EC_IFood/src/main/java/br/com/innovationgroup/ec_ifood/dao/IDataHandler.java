package br.com.innovationgroup.ec_ifood.dao;

import java.util.List;

public interface IDataHandler <T> {

	//M�todo respons�vel por buscar e listar todos os valores presentes no Banco de Dados
	public List<?> GetAll ();
	
	//M�todo respons�vel por buscar e apresentar valores presentes no Banco de Dados, atrav�s do Id
	public T GetByID (int id, int cd);
	
	//M�todo respons�vel por adicionar valores no Banco de Dados
	public int Add (T obj);
	
	//M�todo respons�vel por deletar valores do Banco de Dados
	public int Delete (int id, int cd);
	
	//M�todo respons�vel por atualizar valores do Banco de Dados
	public int Update (T obj);
}
