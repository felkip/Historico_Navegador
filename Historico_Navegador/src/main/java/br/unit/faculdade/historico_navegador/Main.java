package br.unit.faculdade.historico_navegador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner mouse = new Scanner(System.in);
        Navegador navegador = new Navegador(10);
        int opcao;
        
        do {
            System.out.print("\n--- Menu do Navegador ---");
            System.out.println("\n1. Visitar página");
            System.out.println("2. Voltar");
            System.out.println("3. Avançar");
            System.out.println("4. Exibir página atual");
            System.out.println("5. Sair");
            System.out.print("\n---> Escolha uma opção: ");

            opcao = mouse.nextInt();
            mouse.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a URL da página: ");
                    String url = mouse.nextLine();
                    navegador.visitarPagina(url);
                    break;
                case 2:
                    try {
                        String paginaAnterior = navegador.voltar();
                        System.out.println("Página anterior: " + paginaAnterior);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        String paginaAvancada = navegador.avancar();
                        System.out.println("Página avançada: " + paginaAvancada);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        String paginaAtual = navegador.exibirHistorico();
                        System.out.println("Página atual: " + paginaAtual);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Saindo do navegador...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 10);
            
            
        
    }
}
