/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author User
 */

import Model.Produto;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PProduto {

    public void salvar(Produto p) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "INSERT INTO produto " +
            "(nome, descricao, preco, categoria, estoque, ativo) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setString(1, p.getNome());
        ps.setString(2, p.getDescricao());
        ps.setBigDecimal(3, p.getPreco());
        ps.setString(4, p.getCategoria());
        ps.setInt(5, p.getEstoque());
        ps.setBoolean(6, p.getAtivo());

        ps.execute();

        ps.close();
        con.close();
    }

    public void atualizar(Produto p) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "UPDATE produto SET " +
            "nome=?, descricao=?, preco=?, categoria=?, estoque=?, ativo=? " +
            "WHERE id=?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setString(1, p.getNome());
        ps.setString(2, p.getDescricao());
        ps.setBigDecimal(3, p.getPreco());
        ps.setString(4, p.getCategoria());
        ps.setInt(5, p.getEstoque());
        ps.setBoolean(6, p.getAtivo());
        ps.setLong(7, p.getId());

        ps.execute();

        ps.close();
        con.close();
    }

    public void deletar(Long id) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "DELETE FROM produto WHERE id=?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setLong(1, id);

        ps.execute();

        ps.close();
        con.close();
    }

    public Produto buscar(Long id) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "SELECT * FROM produto WHERE id=?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();

        Produto p = null;

        if (rs.next()) {

            p = new Produto();

            p.setId(rs.getLong("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            p.setPreco(rs.getBigDecimal("preco"));
            p.setCategoria(rs.getString("categoria"));
            p.setEstoque(rs.getInt("estoque"));
            p.setAtivo(rs.getBoolean("ativo"));
        }

        rs.close();
        ps.close();
        con.close();

        return p;
    }

    public List<Produto> listar() throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "SELECT * FROM produto";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Produto> lista =
            new ArrayList<Produto>();

        while (rs.next()) {

            Produto p = new Produto();

            p.setId(rs.getLong("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            p.setPreco(rs.getBigDecimal("preco"));
            p.setCategoria(rs.getString("categoria"));
            p.setEstoque(rs.getInt("estoque"));
            p.setAtivo(rs.getBoolean("ativo"));

            lista.add(p);
        }

        rs.close();
        ps.close();
        con.close();

        return lista;
    }
}