package br.com.innovationgroup.ec_ifood.bo;

import java.util.List;

import br.com.innovationgroup.ec_ifood.dao.GeolocalizacaoDAO;

public class Geolocalizacao {

	//Atributos da Classe Geolocalizacao
	private long codigo;
	private long codigoEstabelecimento;
	private String geoCode;
	private String complemento;
	
	//Métodos Get/Set da Classe Geolocalizacao
	public long getCodigoEstabelecimento() {
		return codigoEstabelecimento;
	}
	public void setCodigoEstabelecimento(long codigoEstabelecimento) {
		this.codigoEstabelecimento = codigoEstabelecimento;
	}
	public String getGeoCode() {
		return geoCode;
	}
	public void setGeoCode(String geoCode) {
		this.geoCode = geoCode;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	//Métodos de manipulação do Banco de Dados
	public int AdicionaGeolocalizacao () {
		GeolocalizacaoDAO gDao = new GeolocalizacaoDAO();
		return gDao.Add(this);
	}
	
	public List<Geolocalizacao> VisualizaGeolocalizacao () {
		GeolocalizacaoDAO gDao = new GeolocalizacaoDAO();
		return (List<Geolocalizacao>) gDao.GetAll();
	}
	
	public Geolocalizacao SelecionaGeolocalizacao (int id, int cd) {
		GeolocalizacaoDAO gDao = new GeolocalizacaoDAO();
		return gDao.GetByID(id, cd);
	}
	
	public int RemoveGeolocalizacao (int id, int cd) {
		GeolocalizacaoDAO gDao = new GeolocalizacaoDAO();
		return gDao.Delete(id, cd);
	}
	
	//Método toString
	@Override
	public String toString() {
		return "Geolocalizacao [codigo=" + codigo + ", codigoEstabelecimento=" + codigoEstabelecimento + ", geoCode="
				+ geoCode + ", complemento=" + complemento + "]";
	}

}
