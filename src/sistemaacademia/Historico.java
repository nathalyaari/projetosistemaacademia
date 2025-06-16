package sistemaacademia;

public class Historico {
    private int id;
    private int idMembro;
    private String atividade;
    private String dataAtividade;
    private String tempoExecucao;

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

    public String getAtividade() {
        return atividade;
    }
    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getDataAtividade() {
        return dataAtividade;
    }
    public void setDataAtividade(String dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public String getTempoExecucao() {
        return tempoExecucao;
    }
    public void setTempoExecucao(String tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }
}
