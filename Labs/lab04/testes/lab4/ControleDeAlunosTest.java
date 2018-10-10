package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleDeAlunosTest {
	
	private ControleDeAlunos controle;
	
	@BeforeEach
	public void criaControle() {
		controle = new ControleDeAlunos();
	}
	
	@Test
	public void testCadastrarAluno() {
		assertEquals("CADASTRO REALIZADO!", controle.cadastrarAluno("118110410", "Arthur", "Computação"));
		controle.cadastrarAluno("118110410", "Arthur", "Computação");
		assertEquals("MATRÍCULA JÁ CADASTRADA!", controle.cadastrarAluno("118110410", "Arthur", "Computação"));
	}
	
	@Test
	public void testConsultarAlunoInvalido() {
		assertThrows(NullPointerException.class, () -> controle.consultarAluno(null));
		assertThrows(IllegalArgumentException.class, () -> controle.consultarAluno(""));
	}
	
	@Test
	public void testConsultarAlunoValido() {
		assertEquals("\nAluno não cadastrado.", controle.consultarAluno("118110410"));
		controle.cadastrarAluno("118110410", "Arthur", "Computação");
		assertEquals("\n" + "Aluno: " + controle.getAlunos().get("118110410").toString(), controle.consultarAluno("118110410"));
	}
	
	@Test
	public void testCadastrarGrupoInvalido() {
		assertThrows(NullPointerException.class, () -> controle.cadastarGrupo(null));
		assertThrows(IllegalArgumentException.class, () -> controle.cadastarGrupo(""));
	}
	
	@Test
	public void testCadastrarGrupoValido() {
		assertEquals("CADASTRO REALIZADO!", controle.cadastarGrupo("Coleções"));
		controle.cadastarGrupo("Coleções");
		assertEquals("GRUPO JÁ CADASTRADO!", controle.cadastarGrupo("Coleções"));
	}
	
	@Test
	public void testAlocarAlunoEGrupoInvalido() {
		assertThrows(NullPointerException.class, () -> controle.alocarAluno(null, "Coleções"));
		assertThrows(IllegalArgumentException.class, () -> controle.alocarAluno("", "Coleções"));
		assertThrows(NullPointerException.class, () -> controle.alocarAluno("118110410", null));
		assertThrows(IllegalArgumentException.class, () -> controle.alocarAluno("118110410", ""));
	}
	
	@Test
	public void testAlocarAlunoEmGrupoValido() {
		assertEquals("Aluno não cadastrado.", controle.alocarAluno("118110410", "Coleções"));
		
		controle.cadastrarAluno("118110410", "Arthur", "Computação");
		assertEquals("Grupo não cadastrado.", controle.alocarAluno("118110410", "Coleções"));
		
		controle.cadastarGrupo("Coleções");
		assertEquals("ALUNO ALOCADO!", controle.alocarAluno("118110410", "Coleções"));
	} 
	
	@Test
	public void testImprimirGrupo() {
		assertEquals("Grupo não cadastrado.", controle.imprimirGrupo("Coleções"));
		
		controle.cadastrarAluno("118110410", "Arthur", "Computação");
		controle.cadastarGrupo("Coleções");
		controle.alocarAluno("118110410", "Coleções");
		assertEquals(controle.getGrupos().get("Coleções".toLowerCase()).toString(), controle.imprimirGrupo("Coleções"));
	}
	
	@Test
	public void testCadastrarAlunoQueRespondeuQuestao() {
		assertEquals("Aluno não cadastrado.", controle.cadastrarAlunoQueRespondeuQuestao("118110410"));
		controle.cadastrarAluno("118110410", "Arthur", "Computação");
		assertEquals("ALUNO REGISTRADO!", controle.cadastrarAlunoQueRespondeuQuestao("118110410"));
	}
	
	@Test
	public void testImprimirAlunosQueResponderamQuestoes() {
		controle.cadastrarAluno("118110410", "Arthur", "Computação");
		controle.cadastrarAlunoQueRespondeuQuestao("118110410");
		assertEquals("\nAlunos:\n" + "1. " + controle.getAlunos().get("118110410").toString() + "\n", 
				controle.imprimirAlunosQueResponderamQuestoes());
	}
}
