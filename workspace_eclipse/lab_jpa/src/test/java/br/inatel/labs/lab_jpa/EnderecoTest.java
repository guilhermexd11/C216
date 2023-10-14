package br.inatel.labs.lab_jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.jps.service.EnderecoService;
import br.inatel.labs.lab_jpa.entity.Endereco;

@SpringBootTest
public class EnderecoTest {
	
	@Autowired
	private EnderecoService service;
	
	@Test
	public void testarUUIDGeradoPeloJPAListener() {
		
		Endereco endereco = new Endereco();
		endereco.setRua("Av. Joao de Camargo");
		endereco.setCidade("Santa Rita");
		endereco.setNumero("510");
		endereco.setUf("MG");
		
		service.salvar(endereco);
		
		System.out.println(endereco);
	}
}
