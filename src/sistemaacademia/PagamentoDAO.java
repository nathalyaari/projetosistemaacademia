package sistemaacademia;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import util.conexao;


public class PagamentoDAO {

    public void inserirPagamento(Pagamento p) {
        String sql = "INSERT INTO pagamentos (ID_Membro, Valor, Data_Pagamento, Status) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getIdMembro());
            stmt.setDouble(2, p.getValor());
            stmt.setString(3, p.getDataPagamento());
            stmt.setString(4, p.getStatus());

            stmt.executeUpdate();
            System.out.println("Pagamento inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir pagamento: " + e.getMessage());
        }
    }

    public List<Pagamento> listarPagamentos() {
        List<Pagamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM pagamentos";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pagamento p = new Pagamento();
                p.setId(rs.getInt("ID"));
                p.setIdMembro(rs.getInt("ID_Membro"));
                p.setValor(rs.getDouble("Valor"));
                p.setDataPagamento(rs.getString("Data_Pagamento"));
                p.setStatus(rs.getString("Status"));

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar pagamentos: " + e.getMessage());
        }

        return lista;
    }

    public void atualizarPagamento(Pagamento p) {
        String sql = "UPDATE pagamentos SET ID_Membro=?, Valor=?, Data_Pagamento=?, Status=? WHERE ID=?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getIdMembro());
            stmt.setDouble(2, p.getValor());
            stmt.setString(3, p.getDataPagamento());
            stmt.setString(4, p.getStatus());
            stmt.setInt(5, p.getId());

            stmt.executeUpdate();
            System.out.println("Pagamento atualizado com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pagamento: " + e.getMessage());
        }
    }
    
    public void atualizarStatusParaPago(int id, String data) {
    String sql = "UPDATE pagamentos SET Status = 'PAGO', Data_Pagamento = ? WHERE ID = ?";

    try (Connection conn = conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, data);
        stmt.setInt(2, id);
        stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao atualizar pagamento: " + e.getMessage());
    }
}
    
    public List<Pagamento> buscarPagamentosPorNome(String nome) {
    List<Pagamento> lista = new ArrayList<>();
    String sql = "SELECT p.ID, p.ID_Membro, m.Nome AS NomeMembro, p.Valor, p.Data_Pagamento, p.Status " +
                 "FROM pagamentos p INNER JOIN membros m ON p.ID_Membro = m.ID " +
                 "WHERE m.Nome LIKE ?";

    try (Connection conn = conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, "%" + nome + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Pagamento p = new Pagamento();
            p.setId(rs.getInt("ID"));
            p.setIdMembro(rs.getInt("ID_Membro"));
            p.setNomeMembro(rs.getString("NomeMembro"));
            p.setValor(rs.getDouble("Valor"));
            p.setDataPagamento(rs.getString("Data_Pagamento"));
            p.setStatus(rs.getString("Status"));
            lista.add(p);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}



    public void excluirPagamento(int id) {
        String sql = "DELETE FROM pagamentos WHERE ID=?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pagamento excluído com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir pagamento: " + e.getMessage());
        }
    }
}
