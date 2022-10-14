<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Projeto Tarefas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!--<link href="estilo/reset.css" rel="stylesheet" type="text/css"/>-->
        <link href="estilo/splash.css" rel="stylesheet" type="text/css"/>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">            
            <header>
                <div id="logo"><img src="img/logo.png" width="100%"></div>
                <div id="titulo"><h1>Tarefas Notation</h1></div>
                <div id="menu">
                    <c:if test="${sessionScope.user != null}">
                        <a style="margin-left: 60px;" href="control?ac=logout">Sair</a>
                        <a href="control?ac=listarTarefas"><img src="img/menu.png" width="80%"></a><br>
                    </c:if>
                </div>
            </header>
            
            <main>
                <c:if test="${param.pg == null}">
                    <jsp:include page="pages/home.jsp"/>
                </c:if>
                <c:if test="${param.pg != null}">
                    <jsp:include page="pages/${param.pg}.jsp"/>
                </c:if>
                
                <c:if test="${param.msg!=null}">
                    <br><br><br>
                    <div class="msg-aviso">
                        <h4>${param.msg}</h4>
                    </div>
                </c:if>
            </main>
            
            <footer class="rodape">
                <c:if test="${sessionScope.user == null}">
                <div class="login"><a href="control?ac=login"><img src="img/login.png"></a></div>
                </c:if>
                <div class="home">
                    <a href="control?ac=home"><img src="img/home.png"></a>
                </div>
                
                <div class="mais-tarefa">
                    <c:if test="${sessionScope.user != null}">
                        <a href="control?ac=addTarefa"><img src="img/plus.png"><br>Tarefa</a>
                    </c:if> 
                </div>
                <div class="mais-categoria">
                    <c:if test="${sessionScope.user != null}">
                        <a href="control?ac=addCategoria"><img src="img/plus.png"><br>Categoria</a>
                    </c:if> 
                </div>
            </footer>
        </div>
    </body>
</html>
