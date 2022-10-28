package br.com.innovationgroup.ec_ifood.bo;

import java.util.List;

import br.com.innovationgroup.ec_ifood.dao.CategoriaDAO;

public class Categoria {

	//Atributos da Classe Categoria
	private int codigo;
	private String nome;
	private String descricao;
	
	//Métodos Get/Set da Classe Categoria
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//Métodos de manipulação do Banco de Dados
	public int AdicionaCategoria () {
		CategoriaDAO cDao = new CategoriaDAO();
		return cDao.Add(this);
	}
	
	public List<Categoria> VisualizaCategoria () {
		CategoriaDAO cDao = new CategoriaDAO();
		return (List<Categoria>) cDao.GetAll();
	}
	
	public Categoria SelecionaCategoria (int id, int cd) {
		CategoriaDAO cDao = new CategoriaDAO();
		return cDao.GetByID(id, cd);
	}
	
	public int RemoveCategoria (int id, int cd) {
		CategoriaDAO cDao = new CategoriaDAO();
		return cDao.Delete(id, cd);
	}
	
	//Método toString
	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
	
}
