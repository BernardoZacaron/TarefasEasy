<h3>Cadastrar nova categoria</h3>
<br>
<form action="control" method="post">
    <input type="hidden" name="ac" value="saveCategoria">
    <div class="form-group">
        <label for="nome">Nome</label>
        <input type="text" class="form-control" id="nome" name="nome">
    </div>
    <div class="form-group">
        <label for="descricao">Descrição</label>
        <textarea class="form-control" id="descricao" name="descricao" rows="3"></textarea>
     </div>
    <button type="submit" class="btn btn-primary">Cadastrar</button>
</form>