package lab3;

import java.util.Scanner;

/**
* Representação de um menu que permite gerenciar contatos. Esse menu permite o cadastro
* e a visualização dos contatos. 
*
* @author Arthur Guedes
*/
public class Menu {
	
	public static void main (String[] args) {
		
		Agenda agenda = new Agenda();
		Scanner entrada = new Scanner(System.in);
		
		while (true) {
			System.out.println("(C)adastrar Contato");
			System.out.println("(L)istar Contatos");
			System.out.println("(E)xibir Contato");
			System.out.println("(S)air");
			System.out.print("\nOpção> ");
			
			String opcao = entrada.nextLine();
			
			if (opcao.equals("C")) {
				System.out.print("Posição: ");
				int posicao = Integer.parseInt(entrada.nextLine());
				
				if (posicao > 0 && posicao <= 100) {
					System.out.print("Nome: ");
					String nome = entrada.nextLine();
					if ("".equals(nome.trim())) {
						entrada.close();
						throw new IllegalArgumentException("Nome inválido");
					} 
					
					System.out.print("Sobrenome: ");
					String sobrenome = entrada.nextLine();
					if ("".equals(sobrenome.trim())) {
						entrada.close();
						throw new IllegalArgumentException("Sobrenome inválido");
					}
					
					System.out.print("Telefone: ");
					String numTelefone = entrada.nextLine();
					if ("".equals(numTelefone.trim())) {
						entrada.close();
						throw new IllegalArgumentException("Número inválido");
					}
					
					agenda.cadastrarContato(nome, sobrenome, numTelefone, posicao);
					
					System.out.println("CADASTRO REALIZADO!\n");
				} else {
					System.out.println("POSIÇÃO INVÁLIDA!\n");
				} 
			} else if (opcao.equals("L")) {
				System.out.println(agenda.listarContatos());
			} else if (opcao.equals("E")) {
				System.out.print("Contato> ");
				int posicaoContato = Integer.parseInt(entrada.nextLine());
				
				System.out.println(agenda.pesquisarContato(posicaoContato));
			} else if (opcao.equals("S")) {
				break;
			} else {
				System.out.println("OPÇÃO INVÁLIDA!\n"); 
			}
		}
		entrada.close();
	}
}
