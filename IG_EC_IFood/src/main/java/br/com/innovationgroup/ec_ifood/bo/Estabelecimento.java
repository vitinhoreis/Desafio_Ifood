package br.com.innovationgroup.ec_ifood.bo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import br.com.innovationgroup.ec_ifood.dao.EstabelecimentoDAO;

public class Estabelecimento {
	
	//Atributos da Classe Estabelecimento
	private int codigo;
	private int codigoUsuarioCriacao;
	private int tipoLocalizacao;
	private int codigocategoria;
	private String cnpj;
	private String razaoSocial;
	private String nome;
	private String telefone;
	

	//Métodos Get/Set da Classe Estabelecimento	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigocategoria() {
		return codigocategoria;
	}
	public void setCodigocategoria(int codigocategoria) {
		this.codigocategoria = codigocategoria;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getCodigoUsuarioCriacao() {
		return codigoUsuarioCriacao;
	}
	public void setCodigoUsuarioCriacao(int codigoUsuarioCriacao) {
		this.codigoUsuarioCriacao = codigoUsuarioCriacao;
	}
	public int getTipoLocalizacao() {
		return tipoLocalizacao;
	}
	public void setTipoLocalizacao(int tipoLocalizacao) {
		this.tipoLocalizacao = tipoLocalizacao;
	}
	
	//Métodos de manipulação do Banco de Dados
	public int AdicionaEstabelecimento () {
		EstabelecimentoDAO eDao = new EstabelecimentoDAO();
		return eDao.Add(this);
	}
	
	public List<Estabelecimento> VisualizaEstabelecimentos () {
		EstabelecimentoDAO eDao = new EstabelecimentoDAO();
		return (List<Estabelecimento>) eDao.GetAll();
	}
	
	public Estabelecimento SelecionaEstabelecimento (int id, int cd) {
		EstabelecimentoDAO eDao = new EstabelecimentoDAO();
		return eDao.GetByID(id, cd);
	}
	
	public int RemoveEstabelecimento (int id, int cd) {
		EstabelecimentoDAO eDao = new EstabelecimentoDAO();
		return eDao.Delete(id, cd);
	}
		
	//Método toString
	@Override
	public String toString() {
		return "Estabelecimento [codigo=" + codigo + ", codigoUsuarioCriacao=" + codigoUsuarioCriacao
				+ ", tipoLocalizacao=" + tipoLocalizacao + ", codigocategoria=" + codigocategoria + ", cnpj=" + cnpj
				+ ", razaoSocial=" + razaoSocial + ", nome=" + nome + ", telefone=" + telefone + "]";
	}
	
}
