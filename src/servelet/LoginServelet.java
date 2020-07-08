package servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import dao.DaoLogin;

@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoLogin daologin = new DaoLogin();

	public LoginServelet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();

			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {

				if (daologin.validarLogin(login, senha)) {// acesso ok
					RequestDispatcher dispatcher = request.getRequestDispatcher("acessoliberado.jsp");
					dispatcher.forward(request, response);
				
				} else {// acesso negado
					RequestDispatcher dispatcher = request.getRequestDispatcher("acessonegado.jsp");
					dispatcher.forward(request, response);
				}
			}else { // acesso sem dado no campo de login e senha
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
