package sistemaacademia;

public class Treino {
    private int id;
    private int idMembro;
    private String tipo;
    private String descricao;
    private String duracao; 
    private String dataInicio; 

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdMembro() {
        return idMembro;
    }
    public void setIdMembro(int idMembro) {
        this.idMembro = idMembro;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDuracao() {
        return duracao;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
}

