public class Projetos {

    private String nomeProjeto;
    private String descricaoProjeto;
    private String dataInicio;
    private String dataFim;
    private StatusProjeto statusProjeto;
    private Usuario gerente;

    // Construtor corrigido
    public Projetos(
        String nomeProjeto,
        String descricaoProjeto,
        String dataInicio,
        String dataFim,
        StatusProjeto statusProjeto,
        Usuario gerente
    ) {
        this.nomeProjeto = nomeProjeto;
        this.descricaoProjeto = descricaoProjeto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.statusProjeto = statusProjeto;
        this.gerente = gerente;
    }

    // GETTERS
    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public StatusProjeto getStatusProjeto() {
        return statusProjeto;
    }

    public Usuario getGerente() {
        return gerente;
    }

    // SETTERS
    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public void setStatusProjeto(StatusProjeto statusProjeto) {
        this.statusProjeto = statusProjeto;
    }

    public void setGerente(Usuario gerente) {
        this.gerente = gerente;
    }

    // Exibir projeto
    public void exibirProjeto() {
        System.out.println("Nome: " + nomeProjeto);
        System.out.println("Descrição: " + descricaoProjeto);
        System.out.println("Data início: " + dataInicio);
        System.out.println("Data fim: " + dataFim);
        System.out.println("Status: " + statusProjeto);
        System.out.println("Gerente: " + gerente);
    }
}