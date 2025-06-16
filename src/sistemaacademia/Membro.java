package sistemaacademia;

public class Membro {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String dataCadastro;
    private String senha;
    

   
    public Membro() {}

 
    public Membro(String nome,int id, String cpf, String telefone, String email, String dataCadastro, String senha) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.senha = senha;
    }

  
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(String dataCadastro) { this.dataCadastro = dataCadastro; }
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
