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

import Model.Produto;
import Persistencia.PProduto;

public class NProduto {

    PProduto p = new PProduto();

    public void salvar(Produto pdt) throws Exception {

        p.salvar(pdt);

    }

    public void atualizar(Produto pdt) throws Exception {

        p.atualizar(pdt);

    }

    public void deletar(Long id) throws Exception {

        p.deletar(id);

    }

    public Produto buscar(Long id) throws Exception {

        return p.buscar(id);

    }

    public List<Produto> listar() throws Exception {

        return p.listar();

    }
}