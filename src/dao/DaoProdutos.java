package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.Produtos;
import connection.SingleConnection;

public class DaoProdutos {

	private Connection connection;

	public DaoProdutos() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Produtos produtotabela) {

		try {

			String sql = "insert into produtotabela(nome, quantidade, valor) values (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, produtotabela.getNome());
			insert.setString(2, produtotabela.getQuantidade());
			insert.setString(3, produtotabela.getValor());
			insert.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public List<Produtos> listar() throws Exception {

		List<Produtos> listar = new ArrayList<Produtos>();

		String sql = "select * from produtotabela";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Produtos produtos = new Produtos();
			produtos.setId(resultSet.getLong("id"));
			produtos.setNome(resultSet.getString("nome"));
			produtos.setQuantidade(resultSet.getString("quantidade"));
			produtos.setValor(resultSet.getString("valor"));

			listar.add(produtos);
		}

		return listar;
	}

	public void delete(String id) {
		try {
			String sql = "delete from produtotabela where id = '" + id + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public boolean validarNome(String nome) throws Exception {
		String sql = "select count(1) as qtd from produtotabela where nome='" + nome + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {

			return resultSet.getInt("qtd") <= 0; /* Return True */
		}
		return false;
	}

	public boolean validarNomeUpdate(String nome, String id) throws Exception {
		String sql = "select count(1) as qtd from produtotabela where nome='" + nome + "'and id <> " + id;

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {

			return resultSet.getInt("qtd") <= 0; /* Return True */
		}
		return false;

	}

	public Produtos consultar(String id) throws Exception {
		String sql = "select * from produtotabela where id= '" + id + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Produtos produtos = new Produtos();
			produtos.setId(resultSet.getLong("id"));
			produtos.setNome(resultSet.getString("nome"));
			produtos.setQuantidade(resultSet.getString("quantidade"));
			produtos.setValor(resultSet.getString("valor"));

			return produtos;
		}
		return null;
	}

	public void atualizar(Produtos produtotabela) {
		try {
			String sql = "update produtotabela set nome = ?, quantidade = ?, valor = ? where id = " + produtotabela.getId();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, produtotabela.getNome());
			preparedStatement.setString(2, produtotabela.getQuantidade());
			preparedStatement.setString(3, produtotabela.getValor());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}

}
