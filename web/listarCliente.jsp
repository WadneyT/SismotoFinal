<%-- 
    Document   : listarCliente
    Created on : 26/05/2026, 20:24:07
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>
     <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
<div class="container"></div>
    <jsp:include page="menu.jsp"/>

    <br/>
    <br/>

    <h4>Lista de Clientes</h4>

    <br/>

    <form name="listarCliente"
          action="ClienteController"
          method="GET">

        <div>

            <table border="1" style="width: 70%">

                <thead>

                    <tr>

                        <th>ID</th>
                        <th>Nome</th>
                        <th>Telefone</th>
                        <th>Email</th>
                        <th colspan="2">Ação</th>

                    </tr>

                </thead>

                <tbody>

                    <c:forEach items="${lista}" var="cliente">

                        <tr>

                            <td>
                                <c:out value="${cliente.id}"/>
                            </td>

                            <td>
                                <c:out value="${cliente.nome}"/>
                            </td>

                            <td>
                                <c:out value="${cliente.telefone}"/>
                            </td>

                            <td>
                                <c:out value="${cliente.email}"/>
                            </td>

                            <td>

                                <a href="ClienteController?acao=buscar&id=<c:out value="${cliente.id}"/>">

                                    Editar

                                </a>

                            </td>

                            <td>

                                <a href="ClienteController?acao=deletar&id=<c:out value="${cliente.id}"/>"
                                   onclick="return confirm('Confirma a exclusão?')">

                                    Excluir

                                </a>

                            </td>

                        </tr>

                    </c:forEach>

                </tbody>

                <tfoot>

                    <tr>

                        <td align="center" colspan="6">

                            <a href="manterCliente.jsp">

                                Novo Cliente

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