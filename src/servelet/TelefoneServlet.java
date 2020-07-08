package servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import beans.Telefone;
import dao.DaoTelefone;
import dao.DaoUsuario;
import jdk.jshell.spi.ExecutionControl.ExecutionControlException;

@WebServlet("/salvarTelefone")
public class TelefoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	private DaoTelefone daotelefone = new DaoTelefone();

	public TelefoneServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			String acao = request.getParameter("acao");
			if (acao.endsWith("addFone")) {

				String user = request.getParameter("user");
				if (user != null) {
					BeanCursoJsp usuario = daoUsuario.consultar(user);

					request.getSession().setAttribute("userEscolhido", usuario);
					request.setAttribute("userEscolhido", usuario);

					RequestDispatcher view = request.getRequestDispatcher("telefone.jsp");
					request.setAttribute("telefone", daotelefone.listar(usuario.getId()));

					view.forward(request, response);

				}

				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("usuario", daoUsuario.listar());
				view.forward(request, response);

			} else if (acao.endsWith("deleteFone")) {
				String foneId = request.getParameter("foneId");
				daotelefone.delete(foneId);

				BeanCursoJsp beanCursoJsp = (BeanCursoJsp) request.getSession().getAttribute("userEscolhido");

				RequestDispatcher view = request.getRequestDispatcher("telefone.jsp");
				request.setAttribute("telefone", daotelefone.listar(beanCursoJsp.getId()));
				request.setAttribute("msg", "Telefone Removido!");
				view.forward(request, response);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BeanCursoJsp beanCursoJsp = (BeanCursoJsp) request.getSession().getAttribute("userEscolhido");

			String numero = request.getParameter("numero");
			String tipo = request.getParameter("tipo");

			String acao = request.getParameter("acao");
			if (acao == null || (acao != null && !acao.equalsIgnoreCase("Voltar"))) {

				if (numero == null || (numero != null && numero.isEmpty())) {
					RequestDispatcher view = request.getRequestDispatcher("telefone.jsp");
					request.setAttribute("telefone", daotelefone.listar(beanCursoJsp.getId()));
					request.setAttribute("msg", "Informe o Numero de Telefone!");
					view.forward(request, response);
				} else {
					Telefone telefone = new Telefone();
					telefone.setNumero(numero);
					telefone.setTipo(tipo);
					telefone.setUsuario(beanCursoJsp.getId());

					daotelefone.salvar(telefone);

					request.getSession().setAttribute("userEscolhido", beanCursoJsp);
					request.setAttribute("userEscolhido", beanCursoJsp);

					RequestDispatcher view = request.getRequestDispatcher("telefone.jsp");
					request.setAttribute("telefone", daotelefone.listar(beanCursoJsp.getId()));
					request.setAttribute("msg", "Telefone cadastrado!");
					view.forward(request, response);
				}

			} else {
				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("usuario", daoUsuario.listar());
				view.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
