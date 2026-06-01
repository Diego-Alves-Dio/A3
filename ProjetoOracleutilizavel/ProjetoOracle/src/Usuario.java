public class Usuario {
    //Tudo em private paor ser o cadastro do usuario
    private String nome;
    private String cpf;
    private String cargo;
    private String email;
    private String login;
    private String senha;
    private PerfilAcesso perfil;

    public Usuario(
    String nome,
    String cpf,
    String cargo,
    String email,
    String login,
    String senha,
    PerfilAcesso perfil
) {

    this.nome = nome;
    this.cpf = cpf;
    this.cargo = cargo;
    this.email = email;
    this.login = login;
    this.senha = senha;
    this.perfil = perfil;
}
    
       
    
    //Get
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public PerfilAcesso getPerfil() {
    return perfil;
}

    
    //Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setPerfil(PerfilAcesso perfil) {
    this.perfil = perfil;
}
    
    //Exibir cadastro do usuario
    public void exibirUsuario() {
    System.out.println("Nome: " + nome);
    System.out.println("Cargo: " + cargo);
    System.out.println("CPF: " + cpf);
    System.out.println("Email: " + email);
    System.out.println("login: " + login);
    System.out.println("Perfil: " + perfil);

    }



    public static void add(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
