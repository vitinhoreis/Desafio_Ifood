package br.com.innovationgroup.ec_ifood.bo;

import java.util.List;

import br.com.innovationgroup.ec_ifood.dao.CidadeDAO;

public class Cidade {
	
	private int codigo;
	private int codigoUf;
	private String nome;
		
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoUf() {
		return codigoUf;
	}
	public void setCodigoUf(int codigoUf) {
		this.codigoUf = codigoUf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Cidade> ListarCidades (int codUF) {
		CidadeDAO cDao = new CidadeDAO();
		return (List<Cidade>) cDao.GetAll(codUF);
	}

}
