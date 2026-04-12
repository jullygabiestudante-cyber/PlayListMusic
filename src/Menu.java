import java.util.Scanner;

public class Menu {

    public void exibirMenu() {

        Scanner sc = new Scanner(System.in);
        int id, index, capacidade, opcao, valor;

        System.out.println("===== CONFIGURAÇÃO DA PLAYLIST =====");

        System.out.print("Digite a capacidade máxima: ");
        capacidade = sc.nextInt();


        PlayList musicas = new PlayList(capacidade);

        do {
            System.out.println("\n===== MENU PLAYLIST =====");
            System.out.println("1 - Adicionar Música no início");
            System.out.println("2 - Adicionar Música ao final");
            System.out.println("3 - Inserir em posição específica");
            System.out.println("4 - Remover Primeira");
            System.out.println("5 - Remover Última");
            System.out.println("6 - Remover por Índice");
            System.out.println("7 - Remover por ID (valor)");
            System.out.println("8 - Procurar (Find)");
            System.out.println("9 - Pegar (Get)");
            System.out.println("10 - Alterar (Set)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID da Música: ");
                    id = sc.nextInt();
                    musicas.addFirst(id); // Corrigido para addFirst
                    break;

                case 2:
                    System.out.print("Digite o ID da Música: ");
                    id = sc.nextInt();
                    musicas.addLast(id);
                    break;

                case 3:
                    System.out.print("Digite o ID: ");
                    id = sc.nextInt();
                    System.out.print("Digite a posição (índice): ");
                    index = sc.nextInt();
                    musicas.insertAt(index, id);
                    break;

                case 4:
                    musicas.removeFirst();
                    break;

                case 5:
                    musicas.removeLast();
                    break;

                case 6:
                    System.out.print("Qual índice deseja excluir: ");
                    index = sc.nextInt();
                    musicas.removeAt(index);
                    break;

                case 7:
                    System.out.print("Qual ID deseja remover: ");
                    valor = sc.nextInt();
                    musicas.remove(valor);
                    break;

                case 8:
                    System.out.print("Digite o ID que procura: ");
                    id = sc.nextInt();
                    musicas.find(id);
                    break;

                case 9:
                    System.out.print("Qual índice deseja consultar: ");
                    index = sc.nextInt();
                    musicas.get(index);
                    break;

                case 10:
                    System.out.print("Digite o novo ID: ");
                    valor = sc.nextInt();
                    System.out.print("Digite o índice: ");
                    index = sc.nextInt();
                    musicas.set(index, valor);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}