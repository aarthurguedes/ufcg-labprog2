package lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {

	private Agenda agendaBasica;
	
	@BeforeEach
	public void criaAgenda() {
		agendaBasica = new Agenda();
	}
	
	@Test
	public void testCadastrarContato() {
		assertTrue(agendaBasica.cadastrarContato("Arthur", "Guedes", "4002-8922", 1));
		assertTrue(agendaBasica.cadastrarContato("Arthur", "Guedes", "4002-8922", 100));
		assertFalse(agendaBasica.cadastrarContato("Arthur", "Guedes", "4002-8922", 0));
		assertFalse(agendaBasica.cadastrarContato("Arthur", "Guedes", "4002-8922", 101));
	}
	
	@Test
	public void testPesquisarContato() {
		agendaBasica.cadastrarContato("Arthur", "Guedes", "4002-8922", 1);
		String retornoEsperado = "Arthur Guedes - 4002-8922\n";
		assertEquals(agendaBasica.pesquisarContato(1), retornoEsperado);
	}
	
	@Test
	public void testListarContatos() {
		agendaBasica.cadastrarContato("Arthur", "Guedes", "4002-8922", 1);
		agendaBasica.cadastrarContato("João", "Pedro", "4002-8922", 100);
		String retornoEsperado = "1 - Arthur Guedes\n100 - João Pedro\n";
		assertEquals(agendaBasica.listarContatos(), retornoEsperado);
	}
	
	@Test
	public void testEquals() {
		Agenda agenda2 = new Agenda();
		agendaBasica.cadastrarContato("Arthur", "Guedes", "4002-8922", 1);
		agenda2.cadastrarContato("Arthur", "Guedes", "4002-8922", 1);
		assertTrue(agendaBasica.equals(agenda2));
		agenda2.cadastrarContato("Arthur", "Guedes", "4002-8922", 2);
		assertFalse(agendaBasica.equals(agenda2)); 
	}
}
