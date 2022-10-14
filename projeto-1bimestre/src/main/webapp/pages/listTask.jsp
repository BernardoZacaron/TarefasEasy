<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
<div class="card-tarefa">
    <div class="foto"><img src="img/tarefa.png"></div>
    <div class="titulo"><h3>Estudar Java</h3></div>
    <div class="tarefa-prazo">22/02/2002 (X horas gastas)</div>
    <div class="acoes">
        <div class="btn-concluir"><img src="img/concluir.png"></div>
        <div class="btn-editar"><img src="img/editar.png"></div>
        <div class="btn-excluir"><img src="img/excluir.png"></div>
    </div>
</div>
-->
<c:if test="${requestScope.tarefas.size() == 0}">
    <h3>Nenhuma tarefa cadastrada</h3>
</c:if>
    
<c:forEach items="${requestScope.tarefas}" var="t">
    <div class="card-tarefa">
        <div class="foto"><img src="img/tarefa.png"></div>
        <div class="titulo"><h3>${t.descricao}</h3></div>
        <div class="tarefa-prazo">${t.dataPlanejada} (${t.horasGastas} horas gastas)</div>
        
        <div class="acoes">                                             <!--esconder botão caso a tarefa já esteja concluida-->
            <div class="btn-concluir"><a href="control?ac=concluirTarefa" <c:if test="${t.concluida}">hidden</c:if><img src="img/concluir.png"></a></div>
            <div class="btn-editar"><a href="control?ac=editarTarefa&id=${t.id}"><img src="img/editar.png"></a></div>
            <div class="btn-excluir"><a href="#" data-id="${t.id}"><img src="img/excluir.png"></a></div>
        </div>
    </div>  
</c:forEach>

    <script>
        let botaoDelete = document.querySelectorAll(".btn-excluir");
        botaoDelete.map(b => {
            b.onclick = (e) =>{
                Swal.fire({
                    title: 'Deseja excluir permanentemente essa tarefa?',
                    showDenyButton: true,
                    showCancelButton: true,
                    confirmButtonText: 'Sim',
                    denyButtonText: `Excluir`,
                  }).then((result) => {
                    if (result.isConfirmed) {
                      window.location = "/control?ac=excluirTask?id="+e.target.dataset.id
                    } else if (result.isDenied) {
                      //Swal.fire('Changes are not saved', '', 'info')
                    }
                  })
            }
        });
    </script>
