<%-- 
    Document   : manterPedido
    Created on : 26/05/2026, 20:25:09
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">

    <title>Manter Pedido</title>
     <link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body>
<div class="container"></div>
    <jsp:include page="menu.jsp"/>

    <br/>
    <br/>

    <h4>Manter Pedido</h4>

    <form method="POST"
          action="PedidoController"
          name="manterPedido">

        <table>

            <tr>

                <td>ID</td>

                <td>

                    <input type="text"
                           readonly="readonly"
                           name="id"
                           size="10"
                           maxlength="10"
                           value="<c:out value="${pedido.id}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Data</td>

                <td>

                    <input type="date"
                           name="data"
                           value="<c:out value="${pedido.data}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Total</td>

                <td>

                    <input type="text"
                           name="total"
                           size="15"
                           maxlength="15"
                           value="<c:out value="${pedido.total}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Status</td>

                <td>

                    <input type="text"
                           name="status"
                           size="20"
                           maxlength="30"
                           value="<c:out value="${pedido.status}"/>"/>

                </td>

            </tr>

            <tr>

                <td>ID Cliente</td>

                <td>

                    <input type="text"
                           name="cliente_id"
                           size="10"
                           maxlength="10"
                           value="<c:out value="${pedido.cliente.id}"/>"/>

                </td>

            </tr>

            <tr>

                <td>&nbsp;</td>
                <td>&nbsp;</td>

            </tr>

            <tr>

                <td colspan="2" align="center">

                    <input type="submit"
                           value="Salvar"/>

                    <input type="button"
                           value="Voltar"
                           onclick="history.go(-1)"/>

                </td>

            </tr>

        </table>

    </form>
<footer>
    Projeto Final - Sistemas de Informação | Universidade Estadual de Goiás
</footer>
</body>

</html>