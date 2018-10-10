package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoDeEstudoTest {

	private GrupoDeEstudo grupo;
	
	@BeforeEach
	public void criaGrupo() {
		grupo = new GrupoDeEstudo("Coleções");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("Coleções", grupo.getNome());
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(NullPointerException.class, () -> new GrupoDeEstudo(null));
		assertThrows(IllegalArgumentException.class, () -> new GrupoDeEstudo(""));	
	}
	
	@Test  
	public void testCadastraAlunoInvalido() {
		assertThrows(NullPointerException.class, () -> grupo.cadastraAluno(null));
	}
	
	@Test
	public void testCadastraAlunoValido() {
		Aluno aluno = new Aluno("118110410", "Arthur", "Computação");
		grupo.cadastraAluno(aluno);
		assertTrue(grupo.getAlunos().contains(aluno));
	}
	
	@Test
	public void testToString() {
		Aluno aluno = new Aluno("118110410", "Arthur", "Computação");
		grupo.cadastraAluno(aluno);
		assertEquals("\nAlunos do grupo " + grupo.getNome() + ":\n" + "* " + aluno.toString() + "\n", grupo.toString());
	}
	
	@Test
	public void testGruposIguais() {
		GrupoDeEstudo grupo2 = new GrupoDeEstudo("Coleções");
		assertTrue(grupo.equals(grupo2));
	}
	
	@Test
	public void testGruposDiferentes() {
		GrupoDeEstudo grupo2 = new GrupoDeEstudo("Coleções");
		GrupoDeEstudo grupo3 = new GrupoDeEstudo("Collections");
		assertFalse(grupo.equals(grupo3));
		assertFalse(grupo2.equals(grupo3));
	}
}