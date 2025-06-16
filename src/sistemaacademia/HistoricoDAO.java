package sistemaacademia;

import java.sql.*;
import java.util.*;
import util.conexao;

public class HistoricoDAO {

    public void inserir(Historico h) {
        long inicio = System.currentTimeMillis();

        String sql = "INSERT INTO historico_atividades (ID_Membro, Atividade, Data_Atividade, Tempo_Execucao) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, h.getIdMembro());
            stmt.setString(2, h.getAtividade());
            stmt.setString(3, h.getDataAtividade()); // "yyyy-MM-dd"
            stmt.setString(4, h.getTempoExecucao()); // "hh:mm:ss"

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (inserir histórico): " + (fim - inicio) + " ms");
    }

    public List<Historico> listar() {
        long inicio = System.currentTimeMillis();
        List<Historico> lista = new ArrayList<>();

        String sql = "SELECT * FROM historico_atividades";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Historico h = new Historico();
                h.setId(rs.getInt("ID"));
                h.setIdMembro(rs.getInt("ID_Membro"));
                h.setAtividade(rs.getString("Atividade"));
                h.setDataAtividade(rs.getString("Data_Atividade"));
                h.setTempoExecucao(rs.getString("Tempo_Execucao"));
                lista.add(h);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (listar histórico): " + (fim - inicio) + " ms");

        return lista;
    }

    public void atualizar(Historico h) {
        long inicio = System.currentTimeMillis();

        String sql = "UPDATE historico_atividades SET ID_Membro=?, Atividade=?, Data_Atividade=?, Tempo_Execucao=? WHERE ID=?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, h.getIdMembro());
            stmt.setString(2, h.getAtividade());
            stmt.setString(3, h.getDataAtividade());
            stmt.setString(4, h.getTempoExecucao());
            stmt.setInt(5, h.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (atualizar histórico): " + (fim - inicio) + " ms");
    }

    public void excluir(int id) {
        long inicio = System.currentTimeMillis();

        String sql = "DELETE FROM historico_atividades WHERE ID=?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (excluir histórico): " + (fim - inicio) + " ms");
    }

    public List<Historico> buscarPorMembro(String termo) {
        List<Historico> lista = new ArrayList<>();
        String sql;

        boolean ehNumero = termo.matches("\\d+");

        if (ehNumero) {
            sql = "SELECT * FROM historico_atividades WHERE ID_Membro = ?";
        } else {
            sql = "SELECT * FROM historico_atividades WHERE ID_Membro IN (" +
                  "SELECT ID FROM membros WHERE LOWER(nome) LIKE LOWER(?)" +
                  ")";
        }

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (ehNumero) {
                stmt.setInt(1, Integer.parseInt(termo));
            } else {
                stmt.setString(1, "%" + termo + "%");
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Historico h = new Historico();
                h.setId(rs.getInt("ID"));
                h.setIdMembro(rs.getInt("ID_Membro"));
                h.setAtividade(rs.getString("Atividade"));
                h.setDataAtividade(rs.getString("Data_Atividade"));
                h.setTempoExecucao(rs.getString("Tempo_Execucao"));
                lista.add(h);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
