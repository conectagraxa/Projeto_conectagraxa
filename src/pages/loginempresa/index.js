import React, { useState } from 'react';
import Nossa from "./img-login/Nossa Logo.svg"
import { GoogleLogin } from '@react-oauth/google';
import { GoogleOAuthProvider } from '@react-oauth/google';
import jwt_decode, { jwtDecode } from 'jwt-decode';
import './index.css'
import { Navigate, useNavigate } from 'react-router-dom'
import Api from '../../services/Api';


export default function LoginFormEmpresa() {

    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [logado, setLogado] = useState(false);
    const [name, setName] = useState('');

    const navigate = useNavigate();

    async function login(e) {
        e.preventDefault();

        const data = {
            email,
            senha,
            logado,
        };

        try {
            const response = await Api.put('empresa/login', data);
            localStorage.setItem('email', email);
            setLogado(true);


            navigate('/PrincipalPJ');
        } catch (err) {
            alert('Email ou senha inválidos, caso não tenha uma conta, cadastra-se');
        }

    }


   

    return (




        <div id="geral">
            <div className="bola1"></div>
            <div className="bola2"></div>

            <div className="fiel">

                <span>
                    <img className="logo1" src={Nossa} rel="imagem-logo" />
                </span>

                <h2 className="tema">bem-vindo</h2>
                <form onSubmit={login}>

                    <label for="email" className="nome">Email</label>
                    <br />
                    <input type="email"
                        value={email}
                        onChange={e => setEmail(e.target.value)}
                        className="imp" name="email" id="email" placeholder="Entre com seu Email" required
                        autocomplete="email" autofocus />
                    <br />
                    <br />
                    <br />

                    <label for="password" className="nome">
                        Senha
                    </label>
                    <br />
                    <input value={senha}
                        onChange={e => setSenha(e.target.value)}

                        type="password" className="imp" name="pass" id="pass" placeholder="***********" required />
                    <i id="olho" className="bi bi-eye-fill"></i>

                    <br />
                    <br />
                    <input value={senha}
                        onChange={e => setSenha(e.target.value)}
                        className='input-login' type="checkbox" name="lembrar_senha" id="lembrar_senha" />
                    <label className="lembrar_senhaa" for="lembrar_senha">Lembrar senha</label>

                    <strong>
                        <a className="esqueceu1" href="#" id="Login" name="login">
                            Esqueceu a senha?
                        </a>
                    </strong>
                    <br />
                    <br />

                    <button id="login" className="login" type='submit'> Login  </button>

                </form>

                <br />

                <br />


                <span className='apigoogle' >
                    <GoogleOAuthProvider clientId="758578177861-0ckcl4g5las642anqov57e49tp0mbitr.apps.googleusercontent.com">
                        <GoogleLogin
                            onSuccess={credentialResponse => {
                                console.log(credentialResponse)
                                const details = jwtDecode(credentialResponse.credential);
                                console.log(details);
                                const response = Api.put('empresa/loginGoogleEmpresa', details);
                                localStorage.setItem('email', details.email);
                                setLogado(true);
                                //   navigate('/Home_comunidade');
                            }}
                            onError={() => {
                                console.log('Login Failed')
                            }}
                        />
                    </GoogleOAuthProvider>
                </span>
                <br />
                <div>

                    <p className="cadastro-login">
                        Ainda não tem conta?
                        <strong>
                            <a href="/CadastroPJ" className="cadastro-login a">
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
        </div >

    )

}
