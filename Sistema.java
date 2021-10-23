import java.util.Scanner;

public class Sistema {

    public static void imprimeMenu() {
        System.out.println(" ");
        System.out.println("O que você quer fazer agora?");
        System.out.println(" ");
        System.out.println("1. Adicionar um novo cliente");
        System.out.println("2. Visualizar a lista de clientes atual");
        System.out.println("3. Visualizar os dados de um cliente");
        System.out.println("4. Ver a quantidade de clientes adimplentes e inadimplentes");
        System.out.println("5. Lista de clientes inadimplentes");
        System.out.println("6. Modificar dados de um cliente");
        System.out.println(" ");
        System.out.println("Digite uma opção:");
    }

    public static void adicionarCliente(Clientes cliente){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número da matrícula");
        cliente.setMatricula(sc.nextInt());
        System.out.println("Digite o nome do cliente:");
        cliente.setNome(sc.next());
        System.out.println("Digite a atividade do cliente dentre as opções:");
        System.out.println("- Musculação");
        System.out.println("- Ginástica");
        System.out.println("- Natação");
        System.out.println("- Crossfit");
        System.out.println("- Dança");
        System.out.println("- Luta");
        cliente.setAtividade(sc.next());
        System.out.println("Defina o status de pagamento:");
        System.out.println("Devedor? Digite (S) para Sim ou (N) para Não");
        char devendo = sc.next().charAt(0);
        if (devendo == Character.toLowerCase('S') || devendo == 's') {
            cliente.setDevedor(true);
            System.out.println("Digite a quantidade devida:");
            cliente.setQuantDevida(sc.nextDouble());
        }
    }

    public static void imprimeListaCliente(Clientes[] clientes, int contador) {
        System.out.println("Lista de todos os clientes matriculados:");
        System.out.println(" ");
        for (int i = 0; i <= contador; i++) {
            System.out.println("Matrícula: "+clientes[i].getMatricula());
            System.out.println("Nome: "+clientes[i].getNome());
            System.out.println("Atividade: "+clientes[i].getAtividade());
            System.out.println("Inadimplência: "+clientes[i].getDevedor());
            System.out.println("Quantia devida: "+clientes[i].getQuantDevida());
            System.out.println("--------------------------------------");
        }
    }

    public static void imprimeCliente(int matricula, Clientes[] clientes, int contador) {
        int inicio = 0;
        int fim = contador+1;
        while (inicio < fim) {
            if (clientes[inicio].getMatricula() == matricula) {
                System.out.println("Nome: " + clientes[inicio].getNome());
                System.out.println("Atividade: " + clientes[inicio].getAtividade());
                System.out.println("Inadimplência: " + clientes[inicio].getDevedor());
                System.out.println("Quantia devida: " + clientes[inicio].getQuantDevida());
                System.out.println("--------------------------------------");
                break;
            } else {
                inicio += 1;
            }
        }
    }

    public static void imprimeListaPagamento(Clientes[] clientes, int maximo) {
        int contaDevedor = 0;
        int contaPagador = 0;
        for (int i = 0; i <= maximo; i++) {
            if (clientes[i].getDevedor()) {
                contaDevedor++;
            } else {
                contaPagador++;
            }
        }
        System.out.println("Quantidade de clientes devendo: "+contaDevedor);
        System.out.println("Quantidade de clientes em dia: "+contaPagador);
    }

    public static void imprimeListaInadimplentes(Clientes[] clientes, int maximo) {
        Clientes[] vetorInadimplencia = new Clientes[maximo];
        for (int i = 0; i < vetorInadimplencia.length; i++) {
            vetorInadimplencia[i] = new Clientes();
        }
        int contador = 0;
        double atual;
        for (int i = 0; i < maximo; i++) {
            if (clientes[i].getDevedor()) {
                vetorInadimplencia[contador] = clientes[i];
                contador++;
            }
        }
        for (int j = 1; j < vetorInadimplencia.length; j++) {
            atual = vetorInadimplencia[j].getQuantDevida();
            int k = j - 1;
            while (k > 0 && vetorInadimplencia[k].getQuantDevida() < atual) {
                vetorInadimplencia[k+1] = vetorInadimplencia[k];
                k = k - 1;
            }
            vetorInadimplencia[k+1].setQuantDevida(atual);
        }
        System.out.println("Lista dos devedores:");
        for (int i = 0; i < contador; i++) {
            System.out.print(i+1+" ");
            System.out.println("Nome do cliente: "+vetorInadimplencia[i].getNome());
            System.out.println("  Quantidade devida: "+vetorInadimplencia[i].getQuantDevida());

        }
    }
    public static void modificaCliente(int numeroMatricula, Clientes[] clientes, int maximo) {
        Scanner sc = new Scanner(System.in);
        int inicio = 0;
        int fim = maximo;
        int meio;
        int achado = 0;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (clientes[meio].getMatricula() == numeroMatricula) {
                achado = meio;
                break;
            } else if (clientes[meio].getMatricula() < numeroMatricula) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        System.out.println("Digite o nome do cliente:");
        clientes[achado].setNome(sc.next());
        System.out.println("Digite a atividade do cliente dentre as opções:");
        System.out.println("- Musculação");
        System.out.println("- Ginástica");
        System.out.println("- Natação");
        System.out.println("- Crossfit");
        System.out.println("- Dança");
        System.out.println("- Luta");
        clientes[achado].setAtividade(sc.next());
        System.out.println("Defina o status de pagamento:");
        System.out.println("Devedor? Digite (S) para Sim ou (N) para Não");
        char devendo = sc.next().charAt(0);
        if (devendo == Character.toLowerCase('S') || devendo == 's') {
            clientes[achado].setDevedor(true);
            System.out.println("Digite a quantidade devida:");
            clientes[achado].setQuantDevida(sc.nextDouble());
        } else if (devendo == Character.toLowerCase('N') || devendo == 'n'){
            clientes[achado].setDevedor(false);
            clientes[achado].setQuantDevida(0.0);
        }
    }

    public static void main(String[] args) {
        Clientes[] cliente = new Clientes[15];
        Scanner sc = new Scanner(System.in);

        int selecao;
        int contador = 0;
        System.out.println("Olá, querido(a) funcionário(a)!");
        System.out.println("Bem vindo(a) ao sistema da Academia Corpo Mole!");
        do {
            imprimeMenu();
            selecao = sc.nextInt();
            while (selecao < 1 || selecao > 6) {
                System.out.println("Opção inválida. Digite novamente");
                imprimeMenu();
                selecao = sc.nextInt();
            }
            if (selecao == 1) {
                cliente[contador] = new Clientes();
                adicionarCliente(cliente[contador]);
                contador++;
                if (contador >= 15) {
                    System.out.println("Capacidade máxima atingida. Não é possível adicionar mais alunos");
                }
            }
            if (selecao == 2) {
                imprimeListaCliente(cliente, contador-1);
            }
            if (selecao == 3) {
                System.out.println("Digite o número da matrícula:");
                int matricula = sc.nextInt();
                imprimeCliente(matricula, cliente, contador-1);
            }
            if (selecao == 4) {
                imprimeListaPagamento(cliente, contador-1);
            }
            if (selecao == 5) {
                imprimeListaInadimplentes(cliente, contador);
            }
            if (selecao == 6) {
                System.out.println("Digite o número da matrícula a ser modificada:");
                int numero = sc.nextInt();
                modificaCliente(numero, cliente, contador-1);
            }
        } while (true);
    }
}

