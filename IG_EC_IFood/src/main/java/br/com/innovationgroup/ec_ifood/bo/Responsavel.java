package br.com.innovationgroup.ec_ifood.bo;

import java.util.List;

import br.com.innovationgroup.ec_ifood.dao.ResponsavelDAO;

public class Responsavel {
	
	//Atributos da Classe Responsavel
	private long codigo;
	private long codigoEstabelecimento;
	private String nome;
	private String cpf;
	private String rg;
	
	//Métodos Get/Set da Classe Responsavel
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodigoEstabelecimento() {
		return codigoEstabelecimento;
	}
	public void setCodigoEstabelecimento(long codigoEstabelecimento) {
		this.codigoEstabelecimento = codigoEstabelecimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
		
	//Métodos de manipulação do Banco de Dados
		public int AdicionaResponsavel () {
			ResponsavelDAO rDao = new ResponsavelDAO();
			return rDao.Add(this);
		}
		
		public List<Responsavel> VisualizaResponsaveis () {
			ResponsavelDAO rDao = new ResponsavelDAO();
			return (List<Responsavel>) rDao.GetAll();
		}
		
		public Responsavel SelecionaResponsavel (int id, int cd) {
			ResponsavelDAO rDao = new ResponsavelDAO();
			return rDao.GetByID(id, cd);
		}
		
		public int RemoveResponsavel (int id, int cd) {
			ResponsavelDAO rDao = new ResponsavelDAO();
			return rDao.Delete(id, cd);
		}
	
	//Método toString
	@Override
	public String toString() {
		return "Responsavel [codigo=" + codigo + ", codigoEstabelecimento=" + codigoEstabelecimento + ", nome=" + nome
				+ ", cpf=" + cpf + ", rg=" + rg + "]";
	}
	
}
