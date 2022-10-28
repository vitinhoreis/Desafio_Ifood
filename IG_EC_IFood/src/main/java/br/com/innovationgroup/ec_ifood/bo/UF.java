package br.com.innovationgroup.ec_ifood.bo;

import java.util.List;

import br.com.innovationgroup.ec_ifood.dao.UFDAO;

public class UF {
	
	private int codigo;
	private String sigla;
	private String nome;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<UF> Listar () {
		UFDAO cDao = new UFDAO();
		return (List<UF>) cDao.GetAll();
	}

}
