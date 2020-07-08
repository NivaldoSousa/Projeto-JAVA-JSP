package servelet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import dao.DaoUsuario;

/**
 * Servlet implementation class ServeletPesquisa
 */
@WebServlet("/serveletPesquisa")
public class ServeletPesquisa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String descricaoPesquisa = request.getParameter("descricaoconsulta");
		if (descricaoPesquisa != null && !descricaoPesquisa.trim().isEmpty()) { /*trim() tira o espaço vazio do campo */
			try {
				List<BeanCursoJsp> listaPesquisa = daoUsuario.listar(descricaoPesquisa);

				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("usuario", listaPesquisa);
				view.forward(request, response);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
			try {
				request.setAttribute("usuario", daoUsuario.listar());
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			view.forward(request, response);
		}
	}
}
