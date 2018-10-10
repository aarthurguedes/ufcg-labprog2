package lab4;

import java.util.ArrayList;
import java.util.HashMap;

/**
* Representação de um sistema base para o controle de alunos de Programação 2. O sistema permite o cadastro e consulta de
* alunos, além de inserí-lo em grupo(s) de estudo. Por fim, é possível registrar os alunos que responderem às perguntas 
* feitas pelo professor.
*
* @author Arthur Guedes
*/
public class ControleDeAlunos {
	
	/**
	* Mapa que representa os alunos, identificados unicamente por sua matrícula.
	*/
	private HashMap<String, Aluno> alunos;
	/**
	* Mapa que representa os grupos de estudo, indentificados unicamente pelo seu nome.
	*/
	private HashMap<String, GrupoDeEstudo> grupos;
	/**
	* LIsta que representa os alunos que responderam questões no quadro.
	*/
	private ArrayList<Aluno> alunosQueResponderamQuestoes;
	
	/**
	* Método auxiliar que verifica se uma String passada como parâmetro é null (NullPointerException) ou vazia (IllegalArgumentException).
	* Caso seja, o programa lança uma exceção.
	*
	* @param dado a String passada como parâmetro
	*/
	private void verificaDado(String dado) {
		if (dado == null) {
			throw new NullPointerException ("Parâmetro inválido. Operação encerrada!");
		} else if (dado.trim().equals("")) {
			throw new IllegalArgumentException ("Parâmetro inválido. Operação encerrada!");
		}
	}
	
	/**
	* Constrói o controle a partir do mapa dos alunos. 
	*
	*/
	public ControleDeAlunos() {
		alunos = new HashMap<>();
		grupos = new HashMap<>();
		alunosQueResponderamQuestoes = new ArrayList<>();
	}
	
	/**
	* Retorna o mapa de alunos. 
	*
	* @return a representação em HashMap dos alunos.
	*/
	public HashMap<String, Aluno> getAlunos() {
		return alunos;
	}
	
	/**
	* Retorna o mapa de grupos. 
	*
	* @return a representação em HashMap dos grupos.
	*/
	public HashMap<String, GrupoDeEstudo> getGrupos() {
		return grupos;
	}
	
	/**
	* Retorna uma String que representa se o cadastro do aluno foi efetuado ou se a matrícula já estava cadastrada. 
	*
	* @param matricula a matricula do aluno
	* @param nome o nome do aluno
	* @param curso o curso do aluno
	* @return o valor em String indicando se o cadastro foi efetuado.
	*/
	public String cadastrarAluno(String matricula, String nome, String curso) {
		verificaDado(matricula);
		verificaDado(nome);
		verificaDado(curso);
		
		if (alunos.containsKey(matricula)) { 
			return "MATRÍCULA JÁ CADASTRADA!";
		} else { 
			Aluno aluno = new Aluno(matricula, nome, curso);
			alunos.put(matricula, aluno);
			return "CADASTRO REALIZADO!";
		}
	}
	
	/**
	* Retorna uma String que representa o aluno caso esse esteja cadastrado. 
	* 
	* @param matricula a matricula do aluno
	* @return uma representação em String do aluno, se o mesmo estiver cadastrado.
	*/
	public String consultarAluno(String matricula) {
		verificaDado(matricula);
		
		if (alunos.containsKey(matricula)) {
			return "\n" + "Aluno: " + alunos.get(matricula).toString();
		} else {
			return "\nAluno não cadastrado.";
		}
	}
	
	/**
	* Retorna uma String que representa se o grupo foi cadastrado ou se o mesmo já existia. 
	* 
	* @param nome o nome do grupo
	* @return uma representação em String do cadastro (ou não) do grupo.
	*/
	public String cadastarGrupo(String nome) {
		verificaDado(nome);
		
		if (grupos.containsKey(nome.toLowerCase())) {
			return "GRUPO JÁ CADASTRADO!";
		} else {
			GrupoDeEstudo grupo = new GrupoDeEstudo(nome);
			grupos.put(nome.toLowerCase(), grupo);
			return "CADASTRO REALIZADO!"; 
		}
	}
	
	/**
	* Retorna uma String que representa se o aluno foi alocado em determinado grupo de estudo. 
	* 
	* @param matriculaAluno a matricula do aluno
	* @param nomeGrupo o nome do grupo
	* @return uma representação em String da alocação (ou não) do aluno no grupo. 
	*/
	public String alocarAluno(String matriculaAluno, String nomeGrupo) {
		verificaDado(matriculaAluno);
		verificaDado(nomeGrupo);
		
		if (alunos.containsKey(matriculaAluno) && grupos.containsKey(nomeGrupo.toLowerCase())) {
			grupos.get(nomeGrupo.toLowerCase()).cadastraAluno(alunos.get(matriculaAluno));
			return "ALUNO ALOCADO!";
		} else if (!alunos.containsKey(matriculaAluno)) {
			return "Aluno não cadastrado.";
		} else {
			return "Grupo não cadastrado.";
		}
	}
	
	/**
	* Retorna uma String que representa os alunos de um grupo de estudo, caso esse esteja cadastrado. 
	* 
	* @param grupo o nome do grupo
	* @return uma representação em String de um grupo ou a indicação de que esse grupo não foi cadastrado.  
	*/
	public String imprimirGrupo(String grupo) {
		verificaDado(grupo);
		
		if (grupos.containsKey(grupo.toLowerCase())) {
			return grupos.get(grupo.toLowerCase()).toString();
		} else {
			return "Grupo não cadastrado.";
		}
	}
	
	/**
	* Retorna uma String que representa se aluno que respondeu questão no quadro foi registrado. 
	* 
	* @param matricula a matricula do aluno
	* @return o valor em String indicando se o registro foi efetuado ou se o aluno não está cadastrado (a partir da sua matrícula).
	*/
	public String cadastrarAlunoQueRespondeuQuestao(String matricula) {
		verificaDado(matricula);
		
		if (alunos.containsKey(matricula)) {
			alunosQueResponderamQuestoes.add(alunos.get(matricula));
			return "ALUNO REGISTRADO!";
		} else {
			return "Aluno não cadastrado.";
		}
	}

	/**
	* Retorna uma String que representa os alunos que responderam questões no quadro. 
	*
	* @return uma representação em String dos alunos que responderam questões.  
	*/
	public String imprimirAlunosQueResponderamQuestoes() {
		String retorno = "\nAlunos:\n";
		int cont = 1;
		
		for (Aluno aluno: alunosQueResponderamQuestoes) {
			retorno += cont + ". " + aluno.toString() + "\n";
			cont++;
		}
		
		return retorno;
	}
}
