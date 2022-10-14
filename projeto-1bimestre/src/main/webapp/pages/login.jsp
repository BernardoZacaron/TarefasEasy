        <h1>Bem-vindo!!</h1>
        <br>
        <form action="control" method="post" class="form-login">
            <div class="tela-login">
                <input type="hidden" name="ac" value="verifyLogin"/>
                <div>
                    <label for="login"><b>Login</b></label>
                    <input type="text" name="login" required>
                </div>
                <div>
                    <label for="senha"><b>Senha</b></label>
                    <input type="password" name="senha" required>
                </div>
                <div>
                    <button type="submit">Entrar</button>
                </div>
                <a href="control?ac=cadUsuario">Registrar usuário</a><br>
                <span style="color: red; background-color: grey;">${requestScope.msg}</span>
            </div>
        </form>

