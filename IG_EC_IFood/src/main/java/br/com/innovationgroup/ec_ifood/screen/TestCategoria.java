package br.com.innovationgroup.ec_ifood.screen;

import br.com.innovationgroup.ec_ifood.bo.Categoria;

public class TestCategoria {
	
public static void main(String[] args) {
		
		Categoria c = new Categoria();
		c.setNome("Gerido por Mulheres");
		c.setDescricao("Nossa equipe de colaboradores é completamente formada por mulheres");

		
		System.out.println(c.VisualizaCategoria());
		//System.out.println("Categoria inserida. Registros afetados: " + c.AdicionaCategoria());
		//System.out.println("Categoria removida! Linhas afetadas: " + c.RemoveCategoria(1, 0));
		
	}

}
