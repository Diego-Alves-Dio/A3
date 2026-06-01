import java.util.ArrayList;
import java.util.Scanner;
 
public class Principal {
    public static void main(String[] args) {
 
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Usuario> usuarios = new ArrayList<>();
            ArrayList<Equipes> equipes = new ArrayList<>();
            ArrayList<Projetos> projetos = new ArrayList<>();
            ArrayList<Tarefa> tarefas = new ArrayList<>();
 
            int opcao;
 
            do {
                // Exibir menu
                System.out.println("\n=================================");
                System.out.println(" SISTEMA DE GESTÃO DE PROJETOS");
                System.out.println("=================================");

                System.out.println("\nUSUÁRIOS");
                System.out.println("1  - Cadastrar usuário");
                System.out.println("2  - Listar usuários");

                System.out.println("\nEQUIPES");
                System.out.println("3  - Cadastrar equipe");
                System.out.println("4  - Exibir equipes");
                System.out.println("7  - Remover usuário da equipe");
                System.out.println("8  - Remover projeto da equipe");

                System.out.println("\nPROJETOS");
                System.out.println("5  - Cadastrar projeto");
                System.out.println("6  - Exibir projetos");

                System.out.println("\nTAREFAS");
                System.out.println("11 - Cadastrar tarefa");
                System.out.println("12 - Exibir tarefas");

                System.out.println("\nRELATÓRIOS");
                System.out.println("9  - Gerar relatório");

                System.out.println("\nSISTEMA");
                System.out.println("10 - Sair");

                System.out.print("\nEscolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); //quebra de linha
 
                switch (opcao) {
 
                    case 1:
                        // Cadastrar usuário
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Digite o cargo: ");
                        String cargo = scanner.nextLine();
                        System.out.print("Digite o email: ");
                        String email = scanner.nextLine();
                        System.out.print("Digite o login: ");
                        String login = scanner.nextLine();
                        System.out.print("Digite a senha: ");
                        String senha = scanner.nextLine();
 
                        System.out.println("Escolha o perfil:");
                        System.out.println("1 - ADMIN");
                        System.out.println("2 - GERENTE");
                        System.out.println("3 - FUNCIONARIO");
 
                        int perfilOpcao = scanner.nextInt();
                        scanner.nextLine(); //quebra de linha
 
                        PerfilAcesso perfil;
                        switch (perfilOpcao) {
                            case 1:
                                perfil = PerfilAcesso.ADMINISTRADOR;
                                break;
                            case 2:
                                perfil = PerfilAcesso.GERENTE;
                                break;
                            default:
                                perfil = PerfilAcesso.COLABORADOR;
                        }
 
                        usuarios.add(new Usuario(nome, cpf, cargo, email, login, senha, perfil));
                        System.out.println("Usuário cadastrado com sucesso!");
                        break;
 
                    case 2:
                        // Listar usuários
                        if (usuarios.isEmpty()) {
                            System.out.println("Nenhum usuário cadastrado.");
                        } else {
                            for (Usuario u : usuarios) {
                                System.out.println("Nome: "   + u.getNome());
                                System.out.println("CPF: "    + u.getCpf());
                                System.out.println("Cargo: "  + u.getCargo());
                                System.out.println("Email: "  + u.getEmail());
                                System.out.println("Login: "  + u.getLogin());
                                System.out.println("Perfil: " + u.getPerfil());
                                System.out.println("-----------------------");
                            }
                        }
                        break;
 
                    case 3:
                        // Cadastrar equipe
                        System.out.print("Digite o nome da equipe: ");
                        String nomeEquipe = scanner.nextLine();
                        System.out.print("Digite a descricao da equipe: ");
                        String descricaoEquipe = scanner.nextLine();
                        Usuario liderEquipe = null;

                        System.out.println("Usuários disponíveis:");

                        for (int i = 0; i < usuarios.size(); i++) {
                             System.out.println(
                             (i + 1) + " - " +
                            usuarios.get(i).getNome()
                           );
                        }

                            System.out.print("Escolha o líder da equipe: ");
                            int indiceLider = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (indiceLider >= 0 &&
                                indiceLider < usuarios.size()) {

                                liderEquipe = usuarios.get(indiceLider);

                        } else {

                            System.out.println("Líder inválido.");
                            break;
                }
 
                        // Adicionar membros
                        ArrayList<Usuario> membroEquipe = new ArrayList<>();
                        System.out.println("Digite os nomes dos membros (deixe em branco para parar):");
                        String membro = scanner.nextLine();
                        while (!membro.isEmpty()) {
                            membroEquipe.add(new Usuario(membro, "", "", "", "", "",PerfilAcesso.COLABORADOR));
                            membro = scanner.nextLine();
                        }
 
                        // Adicionar projetos
                        ArrayList<Projetos> projetosEquipe = new ArrayList<>();
                        System.out.println("Digite os nomes dos projetos da equipe (deixe em branco para parar):");
                        String projetoNome = scanner.nextLine();
                        while (!projetoNome.isEmpty()) {
                            projetosEquipe.add(new Projetos(projetoNome, "", "", "", StatusProjeto.PLANEJADO, null));
                            projetoNome = scanner.nextLine();
                        }
 
                        equipes.add(new Equipes(nomeEquipe, descricaoEquipe, liderEquipe, membroEquipe, projetosEquipe));
                        System.out.println("Equipe cadastrada com sucesso!");
                        break;
 
                    case 4:
                        // Exibir equipes
                        if (equipes.isEmpty()) {
                            System.out.println("Nenhuma equipe cadastrada.");
                        } else {
                            for (Equipes e : equipes) {
                                e.exibirEquipe();
                                System.out.println("-----------------------");
                            }
                        }
                        break;
 
                    case 5:
                        // Cadastrar projeto
                        System.out.print("Digite o nome do projeto: ");
                        String nomeProjeto = scanner.nextLine();
                        System.out.print("Digite a descrição do projeto: ");
                        String descricaoProjeto = scanner.nextLine();
                        System.out.print("Digite a data de início do projeto: ");
                        String dataInicio = scanner.nextLine();
                        System.out.print("Digite a data de fim do projeto: ");
                        String dataFim = scanner.nextLine();
 
                        System.out.println("Escolha o status:");
                        System.out.println("1 - PLANEJADO");
                        System.out.println("2 - EM ANDAMENTO");
                        System.out.println("3 - CONCLUIDO");
                        System.out.println("4 - CANCELADO");
 
                        int statusOpcao = scanner.nextInt();
                        scanner.nextLine(); //quebra de linha
 
                        StatusProjeto statusProjeto;
                        switch (statusOpcao) {
                            case 1:
                                statusProjeto = StatusProjeto.PLANEJADO;
                                break;
                            case 2:
                                statusProjeto = StatusProjeto.EM_ANDAMENTO;
                                break;
                            case 3:
                                statusProjeto = StatusProjeto.CONCLUIDO;
                                break;
                            default:
                                statusProjeto = StatusProjeto.CANCELADO;
                        }
 

                        ArrayList<Usuario> gerentes = new ArrayList<>();

                        System.out.println("\nGerentes disponíveis:");

                        for (Usuario u : usuarios) {

                            if (u.getPerfil() == PerfilAcesso.GERENTE) {

                                gerentes.add(u);

                                System.out.println(
                                    gerentes.size() + " - " +
                                    u.getNome()
                                );
                            }
                        }

                        if (gerentes.isEmpty()) {
                            System.out.println("Nenhum gerente cadastrado.");
                            break;
                        }

                        System.out.print("Escolha o gerente responsável: ");
                        int escolhaGerente = scanner.nextInt();
                        scanner.nextLine();

                        Usuario gerenteSelecionado =
                            gerentes.get(escolhaGerente - 1);

                            projetos.add(new Projetos(
                            nomeProjeto,
                            descricaoProjeto,
                            dataInicio,
                            dataFim,
                            statusProjeto,
                            gerenteSelecionado
                        )
                    );

                    System.out.println("Projeto cadastrado com sucesso!");
                    break;

                    case 6:
                        // Exibir projetos
                        if (projetos.isEmpty()) {
                            System.out.println("Nenhum projeto cadastrado.");
                        } else {
                            for (Projetos p : projetos) {
                                System.out.println("Nome do Projeto: "        + p.getNomeProjeto());
                                System.out.println("Descrição do Projeto: "   + p.getDescricaoProjeto());
                                System.out.println("Data de Início: "         + p.getDataInicio());
                                System.out.println("Data de Fim: "            + p.getDataFim());
                                if (p.getGerente() != null) {
                                System.out.println("Gerente Responsável: " + p.getGerente().getNome());
                            }
                                System.out.println("Status do Projeto: "      + p.getStatusProjeto());
                                System.out.println("-----------------------");
                            }
                        }
                        break;
 
                    case 7:
                        // Remover usuário de uma equipe
                        if (equipes.isEmpty()) {
                            System.out.println("Nenhuma equipe cadastrada.");
                            break;
                        }
 
                        System.out.println("Equipes disponíveis:");
                        for (int i = 0; i < equipes.size(); i++) {
                            System.out.println((i + 1) + " - " + equipes.get(i).getNomeEquipe());
                        }
                        System.out.print("Escolha o número da equipe: ");
                        int indiceEquipeUsuario = scanner.nextInt() - 1;
                        scanner.nextLine(); //quebra de linha
 
                        if (indiceEquipeUsuario < 0 || indiceEquipeUsuario >= equipes.size()) {
                            System.out.println("Equipe inválida.");
                            break;
                        }
 
                        Equipes equipeAlvoUsuario = equipes.get(indiceEquipeUsuario);
                        ArrayList<Usuario> membros = equipeAlvoUsuario.getMembrosEquipe();
 
                        if (membros.isEmpty()) {
                            System.out.println("Esta equipe não possui membros.");
                            break;
                        }
 
                        System.out.println("Membros da equipe \"" + equipeAlvoUsuario.getNomeEquipe() + "\":");
                        for (int i = 0; i < membros.size(); i++) {
                            System.out.println((i + 1) + " - " + membros.get(i).getNome());
                        }
                        System.out.print("Escolha o número do membro a remover: ");
                        int indiceMembro = scanner.nextInt() - 1;
                        scanner.nextLine(); //quebra de linha
 
                        if (indiceMembro < 0 || indiceMembro >= membros.size()) {
                            System.out.println("Membro inválido.");
                        } else {
                            String nomeMembro = membros.get(indiceMembro).getNome();
                            membros.remove(indiceMembro);
                            System.out.println("Usuário \"" + nomeMembro + "\" removido da equipe com sucesso!");
                        }
                        break;
 
                    case 8:
                        // Remover projeto de uma equipe
                        if (equipes.isEmpty()) {
                            System.out.println("Nenhuma equipe cadastrada.");
                            break;
                        }
 
                        System.out.println("Equipes disponíveis:");
                        for (int i = 0; i < equipes.size(); i++) {
                            System.out.println((i + 1) + " - " + equipes.get(i).getNomeEquipe());
                        }
                        System.out.print("Escolha o número da equipe: ");
                        int indiceEquipeProjeto = scanner.nextInt() - 1;
                        scanner.nextLine(); // consumir quebra de linha
 
                        if (indiceEquipeProjeto < 0 || indiceEquipeProjeto >= equipes.size()) {
                            System.out.println("Equipe inválida.");
                            break;
                        }
 
                        Equipes equipeAlvoProjeto = equipes.get(indiceEquipeProjeto);
                        ArrayList<Projetos> projetosDaEquipe = equipeAlvoProjeto.getProjetosEquipe();
 
                        if (projetosDaEquipe.isEmpty()) {
                            System.out.println("Esta equipe não possui projetos.");
                            break;
                        }
 
                        System.out.println("Projetos da equipe \"" + equipeAlvoProjeto.getNomeEquipe() + "\":");
                        for (int i = 0; i < projetosDaEquipe.size(); i++) {
                            System.out.println((i + 1) + " - " + projetosDaEquipe.get(i).getNomeProjeto());
                        }
                        System.out.print("Escolha o número do projeto a remover: ");
                        int indiceProjeto = scanner.nextInt() - 1;
                        scanner.nextLine(); // consumir quebra de linha
 
                        if (indiceProjeto < 0 || indiceProjeto >= projetosDaEquipe.size()) {
                            System.out.println("Projeto inválido.");
                        } else {
                            String nomeProjRem = projetosDaEquipe.get(indiceProjeto).getNomeProjeto();
                            projetosDaEquipe.remove(indiceProjeto);
                            System.out.println("Projeto \"" + nomeProjRem + "\" removido da equipe com sucesso!");
                        }
                        break;
 
                    case 9:
                        // Gerar relatorio
                        gerarRelatorio(usuarios, equipes, projetos);
                        break;

                    case 11:
                        // Cadastrar tarefa
                        System.out.print("Digite o nome da tarefa: ");
                        String nomeTarefa = scanner.nextLine();

                        System.out.print("Digite a descrição da tarefa: ");
                        String descricaoTarefa = scanner.nextLine();

                        Tarefa tarefa = new Tarefa(
                        nomeTarefa,
                        descricaoTarefa,
                        null,
                        "PENDENTE"
                        );

                         tarefas.add(tarefa);

                        System.out.println("Tarefa cadastrada com sucesso!");
                        break;

                     case 12:
                        // Exibir tarefas
                        if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                        } else {
                        for (Tarefa t : tarefas) {
                        t.exibirTarefa();
                        System.out.println("-----------------------");
                        }
                        }
                        break;

                    case 10:
                        // Sair
                         System.out.println("Saindo...");
                         break;

                        default:
                        System.out.println("Opção inválida. Tente novamente.");
                        }
 
                        } while (opcao != 10);
                        }
                        }
                        public static void gerarRelatorio(
                        ArrayList<Usuario> usuarios,
                        ArrayList<Equipes> equipes,
                        ArrayList<Projetos> projetos) {

                        System.out.println("\n===== RELATÓRIO GERAL =====");

                        System.out.println("\nUSUÁRIOS");
                        System.out.println("Total de usuários: " + usuarios.size());

                        int admins = 0;
                        int gerentes = 0;
                        int colaboradores = 0;

                        for (Usuario u : usuarios) {
                        if (u.getPerfil() == PerfilAcesso.ADMINISTRADOR) {
                        admins++;
                        } else if (u.getPerfil() == PerfilAcesso.GERENTE) {
                        gerentes++;
                        } else {
                        colaboradores   ++;
                        }
                        }

                        System.out.println("Administradores: " + admins);
                        System.out.println("Gerentes: " + gerentes);
                        System.out.println("Colaboradores: " + colaboradores);

                        System.out.println("\nEQUIPES");
                        System.out.println("Total de equipes: " + equipes.size());

                        System.out.println("\nPROJETOS");
                        System.out.println("Total de projetos: " + projetos.size());

                        System.out.println("\nProjetos cadastrados:");

                        for (Projetos p : projetos) {
                        System.out.println(
                        p.getNomeProjeto()
                        + " - "
                        + p.getStatusProjeto()
                        );
        }
    }
}

 