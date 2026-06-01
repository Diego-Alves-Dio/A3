import java.util.ArrayList;
public class Equipes {
    public String nomeEquipe;
    public String descricaoEquipe;
    private Usuario liderEquipe;
    public ArrayList<Usuario> membrosEquipe;
    public ArrayList<Projetos> projetosEquipe;

    public Equipes(String nomeEquipe, String descricaoEquipe, Usuario liderEquipe, ArrayList<Usuario> membrosEquipe, ArrayList<Projetos> projetosEquipe) {
    this.nomeEquipe = nomeEquipe;
    this.descricaoEquipe = descricaoEquipe;
    this.liderEquipe = liderEquipe;
    this.membrosEquipe = membrosEquipe;
    this.projetosEquipe = projetosEquipe;
    }

    public void adicionarMembro(Usuario usuario) {
    membrosEquipe.add(usuario);
    }

    public void adicionarProjeto(Projetos projeto) {
    projetosEquipe.add(projeto);
    }

    public void exibirEquipe() {
    System.out.println("Nome da Equipe: " + nomeEquipe);
    System.out.println("Descricao: " + descricaoEquipe);
    System.out.println("Líder da Equipe: " + liderEquipe);
    System.out.println("Membros da Equipe:");
    for (Usuario membro : membrosEquipe) {
        System.out.println("- " + membro.getNome());
    }
    System.out.println("Projetos da Equipe:");
    for (Projetos projeto : projetosEquipe) {
        System.out.println("- " + projeto.getNomeProjeto());
    }
    }

    //Get
    public String getNomeEquipe() {
    return nomeEquipe;
    }
    public String getDescricaoEquipe() {
    return descricaoEquipe;
    }
    public Usuario getLiderEquipe() {
    return liderEquipe;
    }
    public ArrayList<Usuario> getMembrosEquipe() {
    return membrosEquipe;
    }
    public ArrayList<Projetos> getProjetosEquipe() {
    return projetosEquipe;
    }

    //Setter
    public void setNomeEquipe(String nomeEquipe) {
    this.nomeEquipe = nomeEquipe;
    }
    public void setDescricaoEquipe(String descricaoEquipe) {
    this.descricaoEquipe = descricaoEquipe;   
    }
    public void setLiderEquipe(Usuario liderEquipe) {
    this.liderEquipe = liderEquipe;
    }
    public void setMembrosEquipe(ArrayList<Usuario> membrosEquipe) {
    this.membrosEquipe = membrosEquipe;
    }
    public void setProjetosEquipe(ArrayList<Projetos> projetosEquipe) {
    this.projetosEquipe = projetosEquipe;
    }
}

