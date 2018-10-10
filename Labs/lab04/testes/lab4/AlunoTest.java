package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {
	
	private Aluno aluno;
	
	@BeforeEach
	public void criaAluno() {
		aluno = new Aluno("118110410", "Arthur", "Computação");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("118110410", aluno.getMatricula());
		assertEquals("Arthur", aluno.getNome());
		assertEquals("Computação", aluno.getCurso());
	}
	
	@Test
	public void testMatriculaInvalida() {
		assertThrows(NullPointerException.class, () -> new Aluno(null, "Arthur", "Computação" ));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("", "Arthur", "Computação" ));
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(NullPointerException.class, () -> new Aluno("118110410", null, "Computação" ));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("118110410", "", "Computação" ));
	}
	
	@Test
	public void testCursoInvalido() {
		assertThrows(NullPointerException.class, () -> new Aluno("118110410", "Arthur", null));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("118110410", "Arthur", ""));
	}
	
	@Test
	public void testToString() {
		assertEquals("118110410 - Arthur - Computação", aluno.toString());
	}
	
	@Test
	public void testAlunosIguais() {
		Aluno aluno2 = new Aluno("118110410", "Matheus", "Medicina" );
		assertTrue(aluno.equals(aluno2));
	}
	
	@Test
	public void testAlunosDiferentes() {
		Aluno aluno2 = new Aluno("118110410", "Matheus", "Medicina" );
		Aluno aluno3 = new Aluno("120112420", "Arthur", "Computação");
		assertFalse(aluno.equals(aluno3));
		assertFalse(aluno2.equals(aluno3));
	}
}
