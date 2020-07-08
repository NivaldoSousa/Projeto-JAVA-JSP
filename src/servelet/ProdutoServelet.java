package servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Produtos;
import dao.DaoProdutos;

@WebServlet("/salvarProduto")
public class ProdutoServelet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DaoProdutos daoprodutos = new DaoProdutos();

	public ProdutoServelet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String acao = request.getParameter("acao")!=null ? request.getParameter("acao") : "listartodos";
			String user = request.getParameter("user");

			if (acao.equalsIgnoreCase("delete")) {
				daoprodutos.delete(user);

				RequestDispatcher view = request.getRequestDispatcher("CadastroProdutos.jsp");
				request.setAttribute("produtotabela", daoprodutos.listar());
				view.forward(request, response);
			} else if (acao.equalsIgnoreCase("editar")) {
				Produtos produtos = daoprodutos.consultar(user);

				RequestDispatcher view = request.getRequestDispatcher("CadastroProdutos.jsp");
				request.setAttribute("user", produtos);
				view.forward(request, response);

			} else if (acao.equalsIgnoreCase("listartodos")) {
				RequestDispatcher view = request.getRequestDispatcher("CadastroProdutos.jsp");
				request.setAttribute("produtotabela", daoprodutos.listar());
				view.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			try {
				RequestDispatcher view = request.getRequestDispatcher("CadastroProdutos.jsp");
				request.setAttribute("produtotabela", daoprodutos.listar());
				view.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String quantidade = request.getParameter("quantidade");
			String valor = request.getParameter("valor");
			Produtos produtotabela = new Produtos();

			produtotabela.setId(!id.isEmpty() ? Long.parseLong(id) : null);
			produtotabela.setNome(nome);
			produtotabela.setQuantidade(quantidade);
			produtotabela.setValor(valor);

			try {

				boolean podeInserir = true;
				if (nome == null || nome.isEmpty()) {
					request.setAttribute("msg", " Nome do produto deve ser informado!");
					request.setAttribute("user", produtotabela);

				} else if (quantidade == null || quantidade.isEmpty()) {
					request.setAttribute("msg", " Quantidade deve ser informado!");
					request.setAttribute("user", produtotabela);

				} else if (valor == null || valor.isEmpty()) {
					request.setAttribute("msg", " Valor deve ser informado!");
					request.setAttribute("user", produtotabela);

				} else if (id == null || id.isEmpty() && !daoprodutos.validarNome(nome)) {
					request.setAttribute("msg", "Produto ja existe com o mesmo nome!");
					request.setAttribute("user", produtotabela);
				
				} else if (id == null || id.isEmpty() && daoprodutos.validarNome(nome)) {
					request.setAttribute("msg", "Produto cadastrado!");

					daoprodutos.salvar(produtotabela);
				}

				if (id != null && !id.isEmpty() && podeInserir) {
					if (!daoprodutos.validarNomeUpdate(nome, id)) {
						request.setAttribute("msg", "Produto ja existe com o mesmo nome!");
						request.setAttribute("user", produtotabela);
					} else {
						daoprodutos.atualizar(produtotabela);
					}
				}

				RequestDispatcher view = request.getRequestDispatcher("CadastroProdutos.jsp");
				request.setAttribute("produtotabela", daoprodutos.listar());
				view.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
