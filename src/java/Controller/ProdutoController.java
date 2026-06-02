/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author User
 */
import Model.Produto;
import Negocio.NProduto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProdutoController")
public class ProdutoController extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        try {

            String acao = request.getParameter("acao");

            NProduto n = new NProduto();

            // LISTAR
            if (acao.equals("listar")) {

                List<Produto> lista = n.listar();

                request.setAttribute("lista", lista);

                request.getRequestDispatcher(
                    "listarProduto.jsp"
                ).forward(request, response);
            }

            // BUSCAR
            else if (acao.equals("buscar")) {

                Long id = Long.parseLong(
                    request.getParameter("id")
                );

                Produto p = n.buscar(id);

                request.setAttribute("produto", p);

                request.getRequestDispatcher(
                    "manterProduto.jsp"
                ).forward(request, response);
            }

            // DELETAR
            else if (acao.equals("deletar")) {

                Long id = Long.parseLong(
                    request.getParameter("id")
                );

                n.deletar(id);

                response.sendRedirect(
                    "ProdutoController?acao=listar"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        try {

            Produto p = new Produto();

            p.setNome(
                request.getParameter("nome")
            );

            p.setDescricao(
                request.getParameter("descricao")
            );

            p.setPreco(
                new BigDecimal(
                    request.getParameter("preco")
                )
            );

            p.setCategoria(
                request.getParameter("categoria")
            );

            p.setEstoque(
                Integer.parseInt(
                    request.getParameter("estoque")
                )
            );

            p.setAtivo(true);

            NProduto n = new NProduto();

            String id = request.getParameter("id");

            // INSERIR
            if (id == null || id.equals("")) {

                n.salvar(p);

            }

            // ATUALIZAR
            else {

                p.setId(Long.parseLong(id));

                n.atualizar(p);

            }

            response.sendRedirect(
                "ProdutoController?acao=listar"
            );

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}