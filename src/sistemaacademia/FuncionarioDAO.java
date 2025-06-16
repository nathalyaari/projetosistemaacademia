package sistemaacademia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.conexao;

public class FuncionarioDAO {

    public boolean autenticar(String login, String senha) {
        String sql = "SELECT * FROM funcionarios WHERE Login = ? AND Senha = ?";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Se encontrou alguém, login válido

        } catch (SQLException e) {
            System.out.println("Erro ao autenticar funcionário: " + e.getMessage());
            return false;
        }
    }

    
    public Funcionario buscarFuncionario(String login) {
        String sql = "SELECT * FROM funcionarios WHERE Login = ?";
        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("ID"));
                f.setNome(rs.getString("Nome"));
                f.setCargo(rs.getString("Cargo"));
                f.setLogin(rs.getString("Login"));
                f.setSenha(rs.getString("Senha"));
                return f;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionário: " + e.getMessage());
        }
        return null;
    }
}
