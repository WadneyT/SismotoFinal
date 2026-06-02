/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author User
 */

import java.util.List;

import Model.Pedido;
import Persistencia.PPedido;

public class NPedido {

    PPedido p = new PPedido();

    public void salvar(Pedido ped) throws Exception {

        p.salvar(ped);

    }

    public void atualizar(Pedido ped) throws Exception {

        p.atualizar(ped);

    }

    public void deletar(Long id) throws Exception {

        p.deletar(id);

    }

    public Pedido buscar(Long id) throws Exception {

        return p.buscar(id);

    }

    public List<Pedido> listar() throws Exception {

        return p.listar();

    }
}