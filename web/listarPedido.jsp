<%-- 
    Document   : listarPedido
    Created on : 26/05/2026, 20:25:28
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>Lista de Pedidos</title>
     <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
<div class="container"></div>
    <jsp:include page="menu.jsp"/>

    <br/>
    <br/>

    <h4>Lista de Pedidos</h4>

    <br/>

    <form name="listarPedido" action="PedidoController"  method="GET">

        <div>

            <table border="1" style="width: 80%">

                <thead>

                    <tr>

                        <th>ID</th>
                        <th>Data</th>
                        <th>Total</th>
                        <th>Status</th>
                        <th>Cliente</th>
                        <th colspan="2">Ação</th>

                    </tr>

                </thead>

                <tbody>

                    <c:forEach items="${lista}" var="pedido">

                        <tr>

                            <td>
                                <c:out value="${pedido.id}"/>
                            </td>

                            <td>
                                <c:out value="${pedido.data}"/>
                            </td>

                            <td>
                                <c:out value="${pedido.total}"/>
                            </td>

                            <td>
                                <c:out value="${pedido.status}"/>
                            </td>

                            <td>
                                <c:out value="${pedido.cliente.id}"/>
                            </td>

                            <td>

                                <a href="PedidoController?acao=buscar&id=<c:out value="${pedido.id}"/>">

                                    Editar

                                </a>

                            </td>

                            <td>

                                <a href="PedidoController?acao=deletar&id=<c:out value="${pedido.id}"/>"
                                   onclick="return confirm('Confirma a exclusão?')">

                                    Excluir

                                </a>

                            </td>

                        </tr>

                    </c:forEach>

                </tbody>

                <tfoot>

                    <tr>

                        <td align="center" colspan="7">

                            <a href="manterPedido.jsp">

                                Novo Pedido

                            </a>

                        </td>

                    </tr>

                </tfoot>

            </table>

        </div>

    </form>
<footer>
    Projeto Final - Sistemas de Informação | Universidade Estadual de Goiás
</footer>
</body>

</html>