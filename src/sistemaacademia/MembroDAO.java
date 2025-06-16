package sistemaacademia;

import util.conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembroDAO {

    // CREATE - Inserir membro
    public void inserirMembro(Membro m) {
        String sql = "INSERT INTO Membros (Nome, CPF, Email, Telefone, Data_Cadastro, Senha) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getCpf());
            stmt.setString(3, m.getEmail());
            stmt.setString(4, m.getTelefone());
            stmt.setString(5, m.getDataCadastro());
            stmt.setString(6, m.getSenha());


            stmt.executeUpdate();
            System.out.println("Membro inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir membro: " + e.getMessage());
        }
    }

   
    public List<Membro> listarMembros() {
        List<Membro> lista = new ArrayList<>();
        String sql = "SELECT * FROM membros";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Membro m = new Membro();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setCpf(rs.getString("cpf"));
                m.setTelefone(rs.getString("telefone"));
                m.setEmail(rs.getString("email"));
                m.setDataCadastro(rs.getString("data_cadastro"));
                m.setSenha(rs.getString("senha"));
                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar membros: " + e.getMessage());
        }

        return lista;
    }

    
    public void atualizarMembro(Membro m) {
        String sql = "UPDATE Membros SET Nome=?, CPF=?, Email=?, Telefone=?, Data_Cadastro=?, Senha=? WHERE ID=?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getCpf());
            stmt.setString(3, m.getEmail());
            stmt.setString(4, m.getTelefone());
            stmt.setString(5, m.getDataCadastro());
            stmt.setString(6, m.getSenha());
            stmt.setInt(7, m.getId());


            stmt.executeUpdate();
            System.out.println("Membro atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar membro: " + e.getMessage());
        }
    }

  
    public void excluirMembro(int id) {
        String sql = "DELETE FROM membros WHERE id=?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Membro excluído com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir membro: " + e.getMessage());
        }
    }
}

