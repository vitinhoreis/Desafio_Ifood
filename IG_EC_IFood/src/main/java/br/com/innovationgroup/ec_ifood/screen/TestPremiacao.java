package br.com.innovationgroup.ec_ifood.screen;

import java.time.LocalDate;

import br.com.innovationgroup.ec_ifood.bo.Premiacao;

public class TestPremiacao {
	
public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		Premiacao p = new Premiacao();
		p.setCodigoEstabelecimento(1);
		p.setNome("Melhor Restaurante");
		p.setDatapremio(java.sql.Date.valueOf(hoje));
		p.setClassificacao(1);
		p.setDescricao("Eleito o melhor restaurante de São Paulo");
		

		
		System.out.println(p.VisualizaPremiacao());
		//System.out.println("Categoria inserida. Registros afetados: " + p.AdicionaPremiacao());
		//System.out.println("Categoria removida! Linhas afetadas: " + p.RemovePremiacao(6));
		
	}

}
