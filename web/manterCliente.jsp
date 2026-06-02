<%-- 
    Document   : manterCliente
    Created on : 26/05/2026, 20:24:18
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">

    <title>Manter Cliente</title>
     <link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body>
<div class="container"></div>
    <jsp:include page="menu.jsp"/>

    <br/>
    <br/>

    <h4>Manter Cliente</h4>

    <form method="POST"
          action="ClienteController"
          name="manterCliente">

        <table>

            <tr>

                <td>ID</td>

                <td>

                    <input type="text"
                           readonly="readonly"
                           name="id"
                           size="10"
                           maxlength="10"
                           value="<c:out value="${cliente.id}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Nome</td>

                <td>

                    <input type="text"
                           name="nome"
                           size="30"
                           maxlength="100"
                           value="<c:out value="${cliente.nome}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Telefone</td>

                <td>

                    <input type="text"
                           name="telefone"
                           size="20"
                           maxlength="20"
                           value="<c:out value="${cliente.telefone}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Email</td>

                <td>

                    <input type="text"
                           name="email"
                           size="40"
                           maxlength="100"
                           value="<c:out value="${cliente.email}"/>"/>

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