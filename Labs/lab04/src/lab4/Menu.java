package lab4;

import java.util.Scanner;

/**
* Representação de um menu que permite a escolha de opções voltadas ao gerenciamento de alunos.
*
* @author Arthur Guedes
*/
public class Menu {

	private static void verificaDado(String dado) {
		if (dado == null) {
			throw new NullPointerException ("Entrada inválida. Operação encerrada!");
		} else if (dado.trim().equals("")) {
			throw new IllegalArgumentException ("Entrada inválida. Operação encerrada!");
		}
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		ControleDeAlunos controleAluno = new ControleDeAlunos();
		
		while (true) {
			
			String opcao;
		
			System.out.println("\n(C)adastrar Aluno");
			System.out.println("(E)xibir Aluno");
			System.out.println("(N)ovo Grupo");
			System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
			System.out.println("(R)egistrar Aluno que Respondeu");
			System.out.println("(I)mprimir Alunos que Responderam");
			System.out.println("(O)ra, vamos fechar o programa!\n");
		
			System.out.print("Opção> ");
			opcao = entrada.nextLine();
			
			if (opcao.toUpperCase().equals("O")) {
				break;
			} else if (opcao.toUpperCase().equals("C")) {
				System.out.print("Matrícula: ");
				String matricula = entrada.nextLine();
				verificaDado(matricula);
				
				System.out.print("Nome: ");
				String nome = entrada.nextLine();
				verificaDado(nome);
				
				System.out.print("Curso: ");
				String curso = entrada.nextLine();
				verificaDado(curso);
				
				System.out.println(controleAluno.cadastrarAluno(matricula, nome, curso));
			} else if (opcao.toUpperCase().equals("E")) {
				System.out.print("Matrícula: ");
				String matricula = entrada.nextLine();
				verificaDado(matricula);
				
				System.out.println(controleAluno.consultarAluno(matricula));
			} else if (opcao.toUpperCase().equals("N")) {
				System.out.print("Grupo: ");
				String nomeGrupo = entrada.nextLine();
				verificaDado(nomeGrupo);
				
				System.out.println(controleAluno.cadastarGrupo(nomeGrupo));
			} else if (opcao.toUpperCase().equals("A")) {
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				String escolha = entrada.nextLine().toUpperCase();
				verificaDado(escolha);
				
				if (escolha.equals("A")) {
					System.out.print("\nMatricula: ");
					String matricula = entrada.nextLine();
					verificaDado(matricula);
					
					System.out.print("Grupo: ");
					String nomeGrupo = entrada.nextLine();
					verificaDado(nomeGrupo);
					
					System.out.println(controleAluno.alocarAluno(matricula, nomeGrupo));
				} else if (escolha.equals("I")) {
					System.out.print("\nGrupo: ");
					String nomeGrupo = entrada.nextLine();
					verificaDado(nomeGrupo);
					
					System.out.println(controleAluno.imprimirGrupo(nomeGrupo));
				}
			} else if (opcao.toUpperCase().equals("R")) { 
				System.out.print("\nMatricula: ");
				String matricula = entrada.nextLine();
				verificaDado(matricula);
				
				System.out.println(controleAluno.cadastrarAlunoQueRespondeuQuestao(matricula));
			} else if (opcao.toUpperCase().equals("I")) {
				System.out.println(controleAluno.imprimirAlunosQueResponderamQuestoes()); 
			} else {
				verificaDado(opcao);
				System.out.println("\nNenhuma das opções válidas foi selecionada. Tente novamente.");
			}
		}
		entrada.close();
	}
}