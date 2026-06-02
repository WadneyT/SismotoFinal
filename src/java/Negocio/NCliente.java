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

import Model.Cliente;
import Persistencia.PCliente;

public class NCliente {

    PCliente p = new PCliente();

    public void salvar(Cliente c) throws Exception {

        p.salvar(c);

    }

    public void atualizar(Cliente c) throws Exception {

        p.atualizar(c);

    }

    public void deletar(Long id) throws Exception {

        p.deletar(id);

    }

    public Cliente buscar(Long id) throws Exception {

        return p.buscar(id);

    }

    public List<Cliente> listar() throws Exception {

        return p.listar();

    }
}