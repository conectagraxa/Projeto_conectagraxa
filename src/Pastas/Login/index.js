import React from 'react';
import Icone from "./img-login/Icone Google.svg"
import Nossa from "./img-login/Nossa Logo.svg"



function LoginForm() {

    function ManipulaLogin() {
        let UsuarioValido = ('usuario')
        let SenhaValida = ('usuario')

        if (UsuarioValido === 'usuario' || SenhaValida === 'usuario') {
            window.location.href = "Home_comunidade";
        } else {
            alert('Usuário ou senha inválida')
        }

    };


    return (

        <div id="geral">
            <div className="bola1"></div>
            <div className="bola2"></div>

            <div className="fiel">
                <span>
                    <img className="logo1" src={Nossa} rel="imagem-logo" />
                </span>

                <h2 className="tema">bem-vindo</h2>

                <label for="email" className="nome">Email</label>
                <br />
                <input type="email" className="imp" name="email" id="email" placeholder="Entre com seu Email" required
                    autocomplete="email" autofocus  />
                <br />
                <br />
                <br />

                <label for="password" className="nome">
                    Senha
                </label>
                <br />
                <input type="password" className="imp" name="pass" id="pass" placeholder="***********" required  />
                <i id="olho" className="bi bi-eye-fill"></i>
                <br />
                <br />
                <input className='input-login' type="checkbox" name="lembrar_senha" id="lembrar_senha" />
                <label className="lembrar_senhaa" for="lembrar_senha">Lembrar senha</label>

                <strong>
                    <a className="esqueceu1" href="#" id="login" name="login">
                        Esqueceu a senha?
                    </a>
                </strong>
                <br />
                <br />
                <button id="login" onclick={ManipulaLogin} className="login">
                    Login
                </button>

                <br />

                <br />


                <a href="#">
                    <button id="func" className="google-login">
                        <img className='img-loginn'  src={Icone} rel='imagem de icone'  /> 
                        <span className="g"> Entrar com o google</span>
                    </button>
                </a>
                <br />
                <div>

                    <p className="cadastro-login">
                        Ainda não tem conta?
                        <strong>
                            <a href="#" className="cadastro-login a">
                                Criar uma
                            </a>
                        </strong>
                    </p>
                </div>

                <div className="bola3"></div>
                <div className="bola4"></div>
                <div>
                </div>
            </div>
        </div>
    )
}

export default LoginForm;

