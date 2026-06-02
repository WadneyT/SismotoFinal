<%-- 
    Document   : listarProduto
    Created on : 26/05/2026, 20:24:55
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
     <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
<div class="container"></div>
    <jsp:include page="menu.jsp"/>

    <br/>
    <br/>

    <h4>Lista de Produtos</h4>

    <br/>

    <form name="listarProduto"
          action="ProdutoController"
          method="GET">

        <div>

            <table border="1" style="width: 90%">

                <thead>

                    <tr>

                        <th>ID</th>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Preço</th>
                        <th>Categoria</th>
                        <th>Estoque</th>
                        <th colspan="2">Ação</th>

                    </tr>

                </thead>

                <tbody>

                    <c:forEach items="${lista}" var="produto">

                        <tr>

                            <td>
                                <c:out value="${produto.id}"/>
                            </td>

                            <td>
                                <c:out value="${produto.nome}"/>
                            </td>

                            <td>
                                <c:out value="${produto.descricao}"/>
                            </td>

                            <td>
                                <c:out value="${produto.preco}"/>
                            </td>

                            <td>
                                <c:out value="${produto.categoria}"/>
                            </td>

                            <td>
                                <c:out value="${produto.estoque}"/>
                            </td>

                            <td>

                                <a href="ProdutoController?acao=buscar&id=<c:out value="${produto.id}"/>">

                                    Editar

                                </a>

                            </td>

                            <td>

                                <a href="ProdutoController?acao=deletar&id=<c:out value="${produto.id}"/>"
                                   onclick="return confirm('Confirma a exclusão?')">

                                    Excluir

                                </a>

                            </td>

                        </tr>

                    </c:forEach>

                </tbody>

                <tfoot>

                    <tr>

                        <td align="center" colspan="8">

                            <a href="manterProduto.jsp">

                                Novo Produto

                            </a>

                        </td>

                    </tr>

                </tfoot>

            </table>

        </div>

    </form>

</body>

</html>