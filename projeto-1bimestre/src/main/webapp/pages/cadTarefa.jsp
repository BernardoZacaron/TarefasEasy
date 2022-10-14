<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Cadastrar nova tarefa</h3>
<br>
<form action="control" method="post">
    <c:if test="${sessionScope.tarefa == null}">
    <input type="hidden" name="ac" value="saveTarefa">
    </c:if>
    <c:if test="${sessionScope.tarefa != null}">
    <input type="hidden" name="ac" value="saveTarefaAlterada">
    <input type="hidden" name="id" value="${sessionScope.tarefa.id}">
    </c:if>
    
    <div class="form-group">
        <label for="descricao">Descrição</label>
        <textarea class="form-control" id="descricao" name="descricao" rows="3">${requestScope.tarefa.descricao}</textarea>
     </div>
    
    <div class="form-group">
        <label for="categoria">Categoria</label>
        <select name="categoria" name="categoria" id="categoria">
            <c:forEach items="${requestScope.categorias}" var="c">
                <option value="${c.id}"  <c:if test="${c.id == requestScope.tarefa.id}">selected</c:if>>${c.nome}</option>
            </c:forEach>
        </select>
        
        <label for="dataPlanejada">Data planejada</label>
        <input type="date" name="dataPlanejada" id="dataPlanejada" value="${requestScope.tarefa.dataPlanejada}">
     </div>
    
    <button type="submit" class="btn btn-primary">Cadastrar</button>
</form>