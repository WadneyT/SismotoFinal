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

import Model.Cliente;
import Model.Pedido;
import Negocio.NPedido;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PedidoController")
public class PedidoController extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        try {

            String acao = request.getParameter("acao");

            NPedido n = new NPedido();

            // LISTAR
            if (acao.equals("listar")) {

                List<Pedido> lista = n.listar();

                request.setAttribute("lista", lista);

                request.getRequestDispatcher(
                    "listarPedido.jsp"
                ).forward(request, response);
            }

            // BUSCAR
            else if (acao.equals("buscar")) {

                Long id = Long.parseLong(
                    request.getParameter("id")
                );

                Pedido p = n.buscar(id);

                request.setAttribute("pedido", p);

                request.getRequestDispatcher(
                    "manterPedido.jsp"
                ).forward(request, response);
            }

            // DELETAR
            else if (acao.equals("deletar")) {

                Long id = Long.parseLong(
                    request.getParameter("id")
                );

                n.deletar(id);

                response.sendRedirect(
                    "PedidoController?acao=listar"
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

            Pedido p = new Pedido();

            p.setData(
                Date.valueOf(
                    request.getParameter("data")
                )
            );

            p.setTotal(
                Double.parseDouble(
                    request.getParameter("total")
                )
            );

            p.setStatus(
                request.getParameter("status")
            );

            Cliente c = new Cliente();

            c.setId(
                Long.parseLong(
                    request.getParameter("cliente_id")
                )
            );

            p.setCliente(c);

            NPedido n = new NPedido();

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
                "PedidoController?acao=listar"
            );

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}