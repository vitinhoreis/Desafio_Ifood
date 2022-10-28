package br.com.innovationgroup.ec_ifood.bo;

import java.sql.Date;
import java.util.List;

import br.com.innovationgroup.ec_ifood.dao.PremiacaoDAO;

public class Premiacao {
	
	//Atributos da Classe Premiacao
	private int codigo;
	private int codigoEstabelecimento;
	private String nome;
	private Date datapremio;
	private int classificacao;
	private String descricao;
	
	//Métodos Get/Set da Classe Premiacao
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDatapremio() {
		return datapremio;
	}
	public void setDatapremio(Date datapremio) {
		this.datapremio = datapremio;
	}
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//Métodos de manipulação do Banco de Dados
	public int AdicionaPremiacao () {
		PremiacaoDAO pDao = new PremiacaoDAO();
		return pDao.Add(this);
	}
	
	public List<Premiacao> VisualizaPremiacao () {
		PremiacaoDAO pDao = new PremiacaoDAO();
		return (List<Premiacao>) pDao.GetAll();
	}
	
	public Premiacao SelecionaPremiacao (int id, int cd) {
		PremiacaoDAO pDao = new PremiacaoDAO();
		return pDao.GetByID(id, cd);
	}
	
	public int RemovePremiacao (int id, int cd) {
		PremiacaoDAO pDao = new PremiacaoDAO();
		return pDao.Delete(id, cd);
	}
	
	//Método toString
	@Override
	public String toString() {
		return "Premiacao [codigo=" + codigo + ", codigoEstabelecimento=" + codigoEstabelecimento + ", nome=" + nome
				+ ", datapremio=" + datapremio + ", classificacao=" + classificacao + ", descricao=" + descricao + "]";
	}
	
}
