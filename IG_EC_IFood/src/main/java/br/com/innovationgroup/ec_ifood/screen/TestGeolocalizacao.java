package br.com.innovationgroup.ec_ifood.screen;

import br.com.innovationgroup.ec_ifood.bo.Geolocalizacao;

public class TestGeolocalizacao {
	
public static void main(String[] args) {
		
		Geolocalizacao g = new Geolocalizacao();
		g.setCodigoEstabelecimento(1);
		g.setGeoCode("FHP2+2G SP");
		g.setComplemento("imperador");

		
		//System.out.println(g.VisualizaGeolocalizacao());
		//System.out.println("Categoria inserida. Registros afetados: " + g.AdicionaGeolocalizacao());
		//System.out.println("Categoria removida! Linhas afetadas: " + g.RemoveGeolocalizacao(6));
		
	}

}
