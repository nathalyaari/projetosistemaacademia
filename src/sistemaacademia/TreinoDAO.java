package sistemaacademia;

import java.sql.*;
import java.util.*;
import sistemaacademia.Treino;
import util.conexao;

public class TreinoDAO {

    public void inserir(Treino t) {
        String sql = "INSERT INTO treinos (ID_Membro, Tipo, Descricao, Duracao, Data_Inicio) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, t.getIdMembro());
            stmt.setString(2, t.getTipo());
            stmt.setString(3, t.getDescricao());
            stmt.setString(4, t.getDuracao());
            stmt.setString(5, t.getDataInicio());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Treino> listarPorMembro(int idMembro) {
        List<Treino> lista = new ArrayList<>();
        String sql = "SELECT * FROM treinos WHERE ID_Membro=?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMembro);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Treino t = new Treino();
                t.setId(rs.getInt("ID"));
                t.setIdMembro(rs.getInt("ID_Membro"));
                t.setTipo(rs.getString("Tipo"));
                t.setDescricao(rs.getString("Descricao"));
                t.setDuracao(rs.getString("Duracao"));
                t.setDataInicio(rs.getString("Data_Inicio"));

                lista.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(Treino t) {
        String sql = "UPDATE treinos SET Tipo=?, Descricao=?, Duracao=?, Data_Inicio=? WHERE ID=?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, t.getTipo());
            stmt.setString(2, t.getDescricao());
            stmt.setString(3, t.getDuracao());
            stmt.setString(4, t.getDataInicio());
            stmt.setInt(5, t.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM treinos WHERE ID=?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Treino> buscarPorMembro(String termo) {
        List<Treino> lista = new ArrayList<>();
        String sql = "SELECT * FROM treinos WHERE ID_Membro IN (SELECT ID FROM membros WHERE nome LIKE ?)";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + termo + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Treino h = new Treino();
                h.setId(rs.getInt("ID"));
                h.setIdMembro(rs.getInt("ID_Membro"));
                h.setTipo(rs.getString("Tipo"));
                h.setDescricao(rs.getString("Descrição"));
                h.setDuracao(rs.getString("Duração"));
                h.setDataInicio(rs.getString("Data_Inicio"));
                lista.add(h);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
