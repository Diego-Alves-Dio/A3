public class Tarefa {

    private String nomeTarefa;
    private String descricaoTarefa;
    private Usuario responsavel;
    private String status;

    public Tarefa(String nomeTarefa, String descricaoTarefa,
                  Usuario responsavel, String status) {

        this.nomeTarefa = nomeTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.responsavel = responsavel;
        this.status = status;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public String getStatus() {
        return status;
    }

    public void exibirTarefa() {

        System.out.println("Tarefa: " + nomeTarefa);
        System.out.println("Descrição: " + descricaoTarefa);

        if (responsavel != null) {
            System.out.println("Responsável: "
                    + responsavel.getNome());
        }

        System.out.println("Status: " + status);
    }
}
    
