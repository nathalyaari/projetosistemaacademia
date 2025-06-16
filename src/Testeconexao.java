import util.conexao;
import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Connection conn = conexao.conectar();
        if (conn != null) {
            System.out.println("Conectado com sucesso!");
        } else {
            System.out.println("Falha na conexão.");
        }
    }
}
