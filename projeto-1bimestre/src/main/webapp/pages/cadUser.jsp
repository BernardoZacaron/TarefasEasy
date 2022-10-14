        <h1>Bem-vindo!!</h1>
        <br>
        <form action="control" method="post" class="form-login">
            <div class="tela-login">
                <input type="hidden" name="ac" value="saveUser"/>
                <div>
                    <label for="cadNome"><b>Nome completo</b></label>
                    <input type="text" name="cadNome" value="${requestScope.user.nome}" required>
                </div>
                <div>
                    <label for="cadEmail"><b>Email</b></label>
                    <input type="text" name="cadEmail" value="${requestScope.user.email}" required>
                </div>
                <div>
                    <label for="login"><b>Login</b></label>
                    <input type="text" name="cadLogin" value="${requestScope.user.login}" required>
                </div>
                <div>
                    <label for="senha"><b>Senha</b></label>
                    <input type="password" name="cadSenha" required>
                </div>
                <div>
                    <button type="submit">Registrar</button>
                </div>
                <span style="color: red; background-color: grey;">${requestScope.msg}</span>
            </div>
        </form>

