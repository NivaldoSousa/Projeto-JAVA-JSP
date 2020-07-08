/* metodo para fazer as buscas dos usuarios e validaçoes no banco de dados, desse modo voce cria os usuarios no banco de dados 
 na hora de inserir os dados nos campos de login e senha, ira buscar no banco de dados*/

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class DaoLogin {

	private Connection connection;

	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}

public boolean validarLogin(String login, String senha) throws Exception{
	
	String sql = "select * from usuario where login ='"+login+"' and senha ='" +senha+ "'";
    PreparedStatement statement = connection.prepareStatement(sql);
    ResultSet resultset = statement.executeQuery();
    if (resultset.next()) {
    	return true; // possui usuario
    }else {
    	return false; // nao validou o usuario
    }
}

}
