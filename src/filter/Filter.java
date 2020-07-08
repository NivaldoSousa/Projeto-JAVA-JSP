
/* porque temos um filter? interceptar os dados da tela pra validar os dados e entregar para o banco de dados */
package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import connection.SingleConnection;
@WebFilter(urlPatterns = { "/*" })
public class Filter implements javax.servlet.Filter {
    
	private static Connection connection;
	
	@Override  
	public void destroy() {
		
	}
	
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
		arg2.doFilter(arg0, arg1);
		
		connection.commit();
		}catch (Exception e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
		
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		connection = SingleConnection.getConnection();
	}
	


}
