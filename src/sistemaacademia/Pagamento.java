package sistemaacademia;

public class Pagamento {
    private int id;
    private int idMembro;
    private double valor;
    private String dataPagamento;
    private String status;
    private String nomeMembro;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdMembro() { return idMembro; }
    public void setIdMembro(int idMembro) { this.idMembro = idMembro; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(String dataPagamento) { this.dataPagamento = dataPagamento; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getNomeMembro() { return nomeMembro; }
    public void setNomeMembro(String nomeMembro) { this.nomeMembro = nomeMembro;
}

}
