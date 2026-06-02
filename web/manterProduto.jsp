<%-- 
    Document   : manterJSP
    Created on : 26/05/2026, 20:24:29
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">

    <title>Manter Produto</title>
     <link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body>
<div class="container"></div>
    <jsp:include page="menu.jsp"/>

    <br/>
    <br/>

    <h4>Manter Produto</h4>

    <form method="POST"
          action="ProdutoController"
          name="manterProduto">

        <table>

            <tr>

                <td>ID</td>

                <td>

                    <input type="text"
                           readonly="readonly"
                           name="id"
                           size="10"
                           maxlength="10"
                           value="<c:out value="${produto.id}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Nome</td>

                <td>

                    <input type="text"
                           name="nome"
                           size="30"
                           maxlength="100"
                           value="<c:out value="${produto.nome}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Descrição</td>

                <td>

                    <input type="text"
                           name="descricao"
                           size="50"
                           maxlength="255"
                           value="<c:out value="${produto.descricao}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Preço</td>

                <td>

                    <input type="text"
                           name="preco"
                           size="15"
                           maxlength="15"
                           value="<c:out value="${produto.preco}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Categoria</td>

                <td>

                    <input type="text"
                           name="categoria"
                           size="20"
                           maxlength="50"
                           value="<c:out value="${produto.categoria}"/>"/>

                </td>

            </tr>

            <tr>

                <td>Estoque</td>

                <td>

                    <input type="text"
                           name="estoque"
                           size="10"
                           maxlength="10"
                           value="<c:out value="${produto.estoque}"/>"/>

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