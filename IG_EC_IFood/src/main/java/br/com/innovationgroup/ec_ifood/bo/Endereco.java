package br.com.innovationgroup.ec_ifood.bo;

import java.util.List;

import br.com.innovationgroup.ec_ifood.dao.EnderecoDAO;

public class Endereco {

	private int codigo;
	private int codigoEstabelecimento;
	private String logradouro;
	private String nrEndereco;
	private long cep;
	private int codigoCidade;
	private String complemento;
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public long getCodigoEstabelecimento() {
		return codigoEstabelecimento;
	}
	public void setCodigoEstabelecimento(int codigoEstabelecimento) {
		this.codigoEstabelecimento = codigoEstabelecimento;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNrEndereco() {
		return nrEndereco;
	}
	public void setNrEndereco(String nrEndereco) {
		this.nrEndereco = nrEndereco;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}
	public int getCidade() {
		return codigoCidade;
	}
	public void setCidade(int codigoCidade) {
		this.codigoCidade = codigoCidade;
	}
		
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	//Métodos de manipulação do Banco de Dados
	public int AdicionaEndereco () {
		EnderecoDAO eDao = new EnderecoDAO();
		return eDao.Add(this);
	}
	
	public List<Endereco> VisualizaEnderecos () {
		EnderecoDAO eDao = new EnderecoDAO();
		return (List<Endereco>) eDao.GetAll();
	}
	
	public Endereco SelecionaEndereco (int id, int cd) {
		EnderecoDAO eDao = new EnderecoDAO();
		return eDao.GetByID(id, cd);
	}
	
	public int RemoveEndereco (int id, int cd) {
		EnderecoDAO eDao = new EnderecoDAO();
		return eDao.Delete(id, cd);
	}

	//Método toString
	@Override
	public String toString() {
		return "Endereco [codigo=" + codigo + ", codigoEstabelecimento=" + codigoEstabelecimento + ", logradouro="
				+ logradouro + ", endereco=" + nrEndereco + ", cep=" + cep + ", complemento=" + complemento + "]";
	}
	
}
