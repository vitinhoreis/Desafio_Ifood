package br.com.innovationgroup.ec_ifood.dao;

import java.util.List;

public interface IDataHandler <T> {

	//Método responsável por buscar e listar todos os valores presentes no Banco de Dados
	public List<?> GetAll ();
	
	//Método responsável por buscar e apresentar valores presentes no Banco de Dados, através do Id
	public T GetByID (int id, int cd);
	
	//Método responsável por adicionar valores no Banco de Dados
	public int Add (T obj);
	
	//Método responsável por deletar valores do Banco de Dados
	public int Delete (int id, int cd);
	
	//Método responsável por atualizar valores do Banco de Dados
	public int Update (T obj);
}
