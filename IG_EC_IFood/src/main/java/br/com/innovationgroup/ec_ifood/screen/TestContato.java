package br.com.innovationgroup.ec_ifood.screen;

import br.com.innovationgroup.ec_ifood.bo.Contato;

public class TestContato {
	
public static void main(String[] args) {
		
		Contato c = new Contato();
		c.setNome("Alfdasredo");
		c.setEmail("user1234@emdasail.com");
		c.setTelefone("95865789");
		

		
		//System.out.println(c.VisualizaContato());
		System.out.println("Categoria inserida. Registros afetados: " + c.AdicionaContato());
		//System.out.println("Categoria removida! Linhas afetadas: " + c.RemoveContato(6));
		
	}

}
