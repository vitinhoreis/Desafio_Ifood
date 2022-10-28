package br.com.innovationgroup.ec_ifood.bo;

import java.util.List;

import br.com.innovationgroup.ec_ifood.dao.ContatoDAO;

public class Contato {
	
	//Atributos da Classe Contato
	private int codigo;
	private String nome;
	private String email;
	private String  telefone;
	
	//Métodos Get/Set da Classe Contato
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//Métodos de manipulação do Banco de Dados
	public int AdicionaContato () {
		ContatoDAO cDao = new ContatoDAO();
		return cDao.Add(this);
	}
	
	public List<Contato> VisualizaContato () {
		ContatoDAO cDao = new ContatoDAO();
		return (List<Contato>) cDao.GetAll();
	}
	
	public Contato SelecionaContato (int id, int cd) {
		ContatoDAO cDao = new ContatoDAO();
		return cDao.GetByID(id, cd);
	}
	
	public int RemoveContato (int id, int cd) {
		ContatoDAO cDao = new ContatoDAO();
		return cDao.Delete(id, cd);
	}
	
	//Método toString
	@Override
	public String toString() {
		return "Contato [codigo=" + codigo + ", nome=" + nome
				+ ", email=" + email + ", telefone=" + telefone + "]";
	}
	
}
