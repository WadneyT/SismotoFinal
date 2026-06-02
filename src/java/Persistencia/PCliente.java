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

import Model.Cliente;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PCliente {

    public void salvar(Cliente c) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "INSERT INTO cliente " +
            "(nome, telefone, email, ativo) " +
            "VALUES (?, ?, ?, ?)";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setString(1, c.getNome());
        ps.setString(2, c.getTelefone());
        ps.setString(3, c.getEmail());
        ps.setBoolean(4, c.getAtivo());

        ps.execute();

        ps.close();
        con.close();
    }

    public void atualizar(Cliente c) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "UPDATE cliente SET " +
            "nome=?, telefone=?, email=?, ativo=? " +
            "WHERE id=?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setString(1, c.getNome());
        ps.setString(2, c.getTelefone());
        ps.setString(3, c.getEmail());
        ps.setBoolean(4, c.getAtivo());
        ps.setLong(5, c.getId());

        ps.execute();

        ps.close();
        con.close();
    }

    public void deletar(Long id) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "DELETE FROM cliente WHERE id=?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setLong(1, id);

        ps.execute();

        ps.close();
        con.close();
    }

    public Cliente buscar(Long id) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "SELECT * FROM cliente WHERE id=?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();

        Cliente c = null;

        if (rs.next()) {

            c = new Cliente();

            c.setId(rs.getLong("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEmail(rs.getString("email"));
            c.setAtivo(rs.getBoolean("ativo"));
        }

        rs.close();
        ps.close();
        con.close();

        return c;
    }

    public List<Cliente> listar() throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "SELECT * FROM cliente";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Cliente> lista =
            new ArrayList<Cliente>();

        while (rs.next()) {

            Cliente c = new Cliente();

            c.setId(rs.getLong("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEmail(rs.getString("email"));
            c.setAtivo(rs.getBoolean("ativo"));

            lista.add(c);
        }

        rs.close();
        ps.close();
        con.close();

        return lista;
    }
}