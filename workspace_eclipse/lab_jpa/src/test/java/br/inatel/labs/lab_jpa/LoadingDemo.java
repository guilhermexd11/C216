package br.inatel.labs.lab_jpa;

import java.time.LocalDate;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.jps.service.NotaCompraService;
import br.inatel.labs.lab_jpa.entity.NotaCompra;
import br.inatel.labs.lab_jpa.entity.NotaCompraItem;

@SpringBootTest
public class LoadingDemo {

	@Autowired
	private NotaCompraService service;
	
	@Test
	public void demoPlanejandoConsulta() {
	  try {
	    NotaCompra nota = service.buscarNotaCompraPeloIdComListaItem( 1L );

	    List<NotaCompraItem> listaNotaCompraItem = nota.getListaNotaCompraItem();
	    
	    for(NotaCompraItem item : listaNotaCompraItem) {
	    	System.out.println(item);
	    }
	    System.out.println("Se chegou até aqui, o planejamento da consulta funcionou");

	  } catch (Exception e) {
	    e.printStackTrace();
	  }
	}


	@Test
	public void demoEagerLoading() {
		try {
			NotaCompraItem item = service.buscarNotaCompraItemPeloId( 1L );

			LocalDate dataEmissao = item.getNotaCompra().getDataEmissao();

			System.out.println(dataEmissao);

			System.out.println("Aconteceu carregamento EAGER");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void demoLazyLoading() {
		try {
			NotaCompra nota = service.buscarNotaCompraPeloId( 1L );

			int tamanho = nota.getListaNotaCompraItem().size();

			System.out.println( tamanho );

		} catch (Exception e) {
			System.out.println("O carregamento foi LAZY e por isso lançou exception");
			e.printStackTrace();
		}
	}
	
	

}
