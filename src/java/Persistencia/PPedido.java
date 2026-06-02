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
import Model.Pedido;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PPedido {

    public void salvar(Pedido p) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "INSERT INTO pedido " +
            "(data, total, status, cliente_id) " +
            "VALUES (?, ?, ?, ?)";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setDate(1, p.getData());
        ps.setDouble(2, p.getTotal());
        ps.setString(3, p.getStatus());
        ps.setLong(4, p.getCliente().getId());

        ps.execute();

        ps.close();
        con.close();
    }

    public void atualizar(Pedido p) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "UPDATE pedido SET " +
            "data=?, total=?, status=?, cliente_id=? " +
            "WHERE id=?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setDate(1, p.getData());
        ps.setDouble(2, p.getTotal());
        ps.setString(3, p.getStatus());
        ps.setLong(4, p.getCliente().getId());
        ps.setLong(5, p.getId());

        ps.execute();

        ps.close();
        con.close();
    }

    public void deletar(Long id) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "DELETE FROM pedido WHERE id=?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setLong(1, id);

        ps.execute();

        ps.close();
        con.close();
    }

    public Pedido buscar(Long id) throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "SELECT * FROM pedido WHERE id=?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();

        Pedido p = null;

        if (rs.next()) {

            p = new Pedido();

            Cliente c = new Cliente();

            c.setId(rs.getLong("cliente_id"));

            p.setId(rs.getLong("id"));
            p.setData(rs.getDate("data"));
            p.setTotal(rs.getDouble("total"));
            p.setStatus(rs.getString("status"));
            p.setCliente(c);
        }

        rs.close();
        ps.close();
        con.close();

        return p;
    }

    public List<Pedido> listar() throws Exception {

        Connection con = Conexao.conectar();

        String sql =
            "SELECT * FROM pedido";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Pedido> lista =
            new ArrayList<Pedido>();

        while (rs.next()) {

            Pedido p = new Pedido();

            Cliente c = new Cliente();

            c.setId(rs.getLong("cliente_id"));

            p.setId(rs.getLong("id"));
            p.setData(rs.getDate("data"));
            p.setTotal(rs.getDouble("total"));
            p.setStatus(rs.getString("status"));
            p.setCliente(c);

            lista.add(p);
        }

        rs.close();
        ps.close();
        con.close();

        return lista;
    }
}
