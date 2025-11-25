package br.com.henrique.cadastro.ui;

import br.com.henrique.cadastro.model.Cliente;
import br.com.henrique.cadastro.repository.ClienteRepository;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class CadastroUI {

    public int opcao;


    public void criarMenu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Cadastro de Clientes");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar todos");
        System.out.println("3 - Exibir cliente");
        System.out.println("4 - Excluir Cliente");
        System.out.println("5 - Atualizar cliente");
        System.out.println("6 - Sair");
        System.out.println("-----------------------");
        System.out.println();
        System.out.println("Escolha uma opcao (1-6):  ");

        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                cadastrarCliente();
                break;
                case 2:
                    System.out.println("Listar Todos");
                    break;
                    case 3:
                        System.out.println("Exibir Cliente");
                        break;
                        case 4:
                            System.out.println("Excluir Cliente");
                            break;
                            case 5:
                                System.out.println("Atualizar Cliente");
                                break;
                                case 6:
                                    System.out.println("Sair");
                                        break;

            default:
                System.out.println("Opção invalida! Escolha uma opcao (1-6) somente:");
                criarMenu();
                break;
        }
    }

    private void cadastrarCliente(){

        UUID id = UUID.randomUUID();

        Cliente cliente = new Cliente();
        cliente.id = id.toString();

        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.print("Nome do clientes: ");
        cliente.nome = sc.nextLine();

        System.out.print("Email do clientes: ");
        cliente.email = sc.nextLine();

        System.out.print("Salario do clientes: ");
        cliente.salario = sc.nextDouble();
        sc.nextLine(); // Gambirra do Scanner para limpar o cache

        System.out.print("Data de nascimento do clientes: ");
        String dataNascimento = sc.nextLine();

        dataNascimento = dataNascimento.replace("-", "/");
        String[] dataNascimentoSplit = dataNascimento.split("/");

        cliente.dataNascimento = LocalDate.of(
                Integer.parseInt(dataNascimentoSplit[2]),
                Integer.parseInt(dataNascimentoSplit[1]),
                Integer.parseInt(dataNascimentoSplit[0])
        );

        cliente.ExibirCliente();

        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.cadastrar();

    }

}
