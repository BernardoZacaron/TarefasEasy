<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${requestScope.categorias}" var="c">
<div class="card-categoria">
    <div class="foto"><img src="img/categoria.png"></div>
    <div class="titulo"><h3>${c.nome}</h3></div>
    <div class="categoria-info">
        <p>${c.descricao}</p>
    </div>
</div>
</c:forEach>