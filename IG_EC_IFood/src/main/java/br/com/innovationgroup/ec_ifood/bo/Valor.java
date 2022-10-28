package br.com.innovationgroup.ec_ifood.bo;

import java.util.List;

import br.com.innovationgroup.ec_ifood.dao.ValorDAO;

public class Valor {
	
	private int codigo;
	private int codigoEstabelecimento;
	private String descricao;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoEstabelecimento() {
		return codigoEstabelecimento;
	}
	public void setCodigoEstabelecimento(int codigoEstabelecimento) {
		this.codigoEstabelecimento = codigoEstabelecimento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//Métodos de manipulação do Banco de Dados
			public int AdicionaValor () {
				ValorDAO rDao = new ValorDAO();
				return rDao.Add(this);
			}
			
			public List<Valor> VisualizaValores () {
				ValorDAO rDao = new ValorDAO();
				return (List<Valor>) rDao.GetAll();
			}
			
			public Valor SelecionaValor (int id, int cd) {
				ValorDAO rDao = new ValorDAO();
				return rDao.GetByID(id, cd);
			}
			
			public int RemoveResponsavel (int id, int cd) {
				ValorDAO rDao = new ValorDAO();
				return rDao.Delete(id, cd);
			}
	

}
