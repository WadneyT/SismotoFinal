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
import Negocio.NCliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        try {
           
            String acao = request.getParameter("acao");
            if (acao == null){
                acao = "listar";
            }
            NCliente n = new NCliente();

            // LISTAR
            if (acao.equals("listar")) {

                List<Cliente> lista = n.listar();

                request.setAttribute("lista", lista);

                request.getRequestDispatcher(
                    "listarCliente.jsp"
                ).forward(request, response);
            }

            // BUSCAR
            else if (acao.equals("buscar")) {

                Long id = Long.parseLong(
                    request.getParameter("id")
                );

                Cliente c = n.buscar(id);

                request.setAttribute("cliente", c);

                request.getRequestDispatcher(
                    "manterCliente.jsp"
                ).forward(request, response);
            }

            // DELETAR
            else if (acao.equals("deletar")) {

                Long id = Long.parseLong(
                    request.getParameter("id")
                );

                n.deletar(id);

                response.sendRedirect(
                    "ClienteController?acao=listar"
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

            Cliente c = new Cliente();

            c.setNome(
                request.getParameter("nome")
            );

            c.setTelefone(
                request.getParameter("telefone")
            );

            c.setEmail(
                request.getParameter("email")
            );

            c.setAtivo(true);

            NCliente n = new NCliente();

            String id = request.getParameter("id");

            // INSERIR
            if (id == null || id.equals("")) {

                n.salvar(c);

            }

            // ATUALIZAR
            else {

                c.setId(Long.parseLong(id));

                n.atualizar(c);

            }

            response.sendRedirect(
                "ClienteController?acao=listar"
            );

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}