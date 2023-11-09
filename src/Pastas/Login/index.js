import React from 'react';



function LoginForm() {

    function manipulaLogin() {
        let UsuarioValido = ('usuario')
        let SenhaValida = ('usuario')

        if (UsuarioValido === 'usuario' || SenhaValida === 'usuario') {
            window.location.href = "/Principal";
        } else {
            alert('Usuário ou senha inválida')
        }

    };


    return (
        <div>
            <link rel="stylesheet" href="index.css" /><link
                rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" />

            <div id="geral">
                <div className="bola1"></div>
                <div className="bola2"></div>

                <fieldset className="fiel">
                    <span>
                        <img className="logo1" src="imagem/logo1.svg" alt="" />
                    </span>

                    <h2 className="tema">bem-vindo</h2>

                    <label htmlFor="email" className="nome">Email</label>
                    <br></br>
                    <input
                        type="email"
                        className="imp"
                        name="email"
                        id="email"
                        placeholder="Entre com seu Email"
                        required
                        autoComplete="email"
                        autoFocus
                        style={{ padding: '15px' }}
                    />
                    <br></br>
                    <br></br>
                    <br></br>

                    <label htmlFor="password" className="nome">
                        Senha
                    </label>
                    <br></br>
                    <input
                        type="password"
                        className="imp"
                        name="pass"
                        id="pass"
                        placeholder="***********"
                        required
                        style={{ padding: '15px' }}
                    />
                    <i id="olho" className="bi bi-eye-fill"></i>
                    <br></br>
                    <br></br>

                    <input type="checkbox" name="lembrar_senha" id="lembrar_senha" />
                    <label className="lembrar_senhaa" htmlFor="lembrar_senha">Lembrar senha</label>

                    <strong>
                        <a className="esqueceu1" href="#" id="login" name="login">
                            Esqueceu a senha?
                        </a>
                    </strong>
                    <br></br>
                    <br></br>
                    <button id="login" onClick={manipulaLogin} className="login">
                        Login
                    </button>

                    <br /> <br></br>

                    <a href="#">
                        <button id="func" className="google">
                            <svg className="gg" xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="50"
                                height="25"
                                viewBox="0 0 45 45">

                            </svg>
                            <span className="g"> Entrar com o google</span>
                        </button>
                    </a>
                    <br></br>

                    <p className="cadastro">
                        Ainda não tem conta?{' '}
                        <strong>
                            <a href="#" className="cadastro a">
                                Criar uma
                            </a>
                        </strong>
                    </p>
                </fieldset>

                <div className="bola3"></div>
                <div className="bola4"></div>
            </div>
        </div>






    )
}

export default LoginForm;

