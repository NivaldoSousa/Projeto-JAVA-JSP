package connection;
import java.sql.Connection;
import java.sql.DriverManager;

/** Responsavel por fazer a conexao com banco de dados **/

public class SingleConnection {

	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
private static Connection connection = null;

	static {
		conectar(); /** metodo para garanti que  sempre haja 
		             conexao com o banco de dados**/
	}

public SingleConnection() {
	conectar();
	
}

private static void conectar( ) {  /** metodo de erro na conexao, mostra uma mensagem**/
    try {
    	if(connection == null) {
    		Class.forName("org.postgresql.Driver");
    	connection = DriverManager.getConnection(banco, user, password);
    	connection.setAutoCommit(false);
    	}
    	
    }catch (Exception e) {
    	e.printStackTrace();/** caso der algum erro imprimir no console qual e o erro**/ 
    	throw new RuntimeException(" Erro ao conectar com o banco de dados");
    }
}

public static Connection getConnection() {
	return connection;
}



}


