import React from 'react';
import './responsive/index.css'
import './index.css'

import circulo1 from './imagem/circulo1.svg'
import circulo2 from './imagem/circulo2.svg'
import circulo3 from './imagem/circulo3.svg'
import circulo4 from './imagem/circulo4.svg'
import Ellipse1 from './imagem/Ellipse1.svg'
import Ellipse2 from './imagem/Ellipse2.svg'
import Ellipse3 from './imagem/Ellipse3.svg'
import Ellipse4 from './imagem/Ellipse4.svg'
import Ellipse5 from './imagem/Ellipse5.svg'
import GitHub from './imagem/GitHub.svg'
import Help from './imagem/Help.svg'
import paralax from './imagem/paralax.svg'
import imagem1 from './imagem/imagem1.svg'
import InstagramCircle from './imagem/InstagramCircle.svg'
import LinkedinCircled from './imagem/LinkedInCircled.svg'
import logo2 from './imagem/logo2.png'
import MovieProjectores from './imagem/MovieProjector.svg'
import Profiles from './imagem/Profiles.svg'
import Rectangle02 from './imagem/Rectangle02.svg'
import Rectangle03 from './imagem/Rectangle03.svg'
import logo from './imagem/logo.svg'


function Home() {


    // Função para abrir o modal
    const abrirModal = () => {
        const modal = document.getElementById('janela-modal');
        modal.style.display = 'block';

        modal.addEventListener('click', (e) => {
            if (e.target === modal) {
                modal.style.display = 'none';
            }
        });

    };

    const abrirModal2 = () => {
        const modal = document.getElementById('janela-modal2');
        modal.style.display = 'block';

        modal.addEventListener('click', (e) => {
            if (e.target === modal) {
                modal.style.display = 'none';
            }
        });

    };
    return (
        <div>
            <link rel="stylesheet" href="indexx.css" />
            <link rel='srylesheet' href='./responsive/index.css'></link>
            <div className='patri' ></div>
            <nav className="topo">
                <div className="t">
                    <div className="logo">
                        <img src={logo} alt="" />
                    </div>
                    <div className="to" onClick={abrirModal2}>Cadastre-se </div>
                    <div className="to0" onClick={abrirModal}> Entrar</div>
                </div>
            </nav>


            <div className="inicio">
                <div className="nomepr">
                    <div className="nomepr1">
                        <h1 className="titlev">
                            <h1 className="c1">Um lugar onde</h1>
                            <h1 className="c2">todos se conectam</h1>
                            <h1 className="c3">Venha fazer parte </h1>
                            <h1 className="c4">dessa equipe!</h1>
                        </h1>

                        <span className="otoes">
                            <a href="/CadastroPF">
                                <button className="bb1">Comece já</button>
                            </a>
                            <a href="/FormPje">
                                <button className="bb2">Contratar</button>
                            </a>
                        </span>
                    </div>
                </div>
            </div>


            <div className="ima">
                <span className="ima1">
                    <img src={Ellipse1} alt="Eclipse1" />
                </span>
                <span className="ima2">
                    <img src={Ellipse2} alt="" />
                </span>
                <span className="ima3">
                    <img src={Ellipse3} alt="" />
                </span>
                <span className="ima4">
                    <img src={Ellipse4} alt="" />
                </span>
                <span className="ima5">
                    <img src={Ellipse5} alt="" />
                </span>
                <span className="ima6">
                    <img src={circulo1} alt="" />
                </span>
                <span className="ima7">
                    <img src={circulo2} alt="" />
                </span>
                <span className="ima8">
                    <img src={circulo3} alt="" />
                </span>
                <span className="ima9">
                    <img src={circulo4} alt="" />
                </span>
            </div>

            <div className="geral">
                <div className="slider">
                    <h1 className="veja">Veja algumas oportunidades! </h1>

                    <div className="slides">
                        <input type="radio" name="radio_btn" id="radio1" />
                        <input type="radio" name="radio_btn" id="radio2" />
                        <input type="radio" name="radio_btn" id="radio3" />
                        <input type="radio" name="radio_btn" id="radio4" />

                        <div className="slide-first">
                            <img src={imagem1} alt="imagem1" />
                        </div>
                        <div className="slide">
                            <img src={Rectangle02} alt="imagem2" />
                        </div>
                        <div className="slide">
                            <img src={Rectangle03} alt="imagem3" />
                        </div>
                        <div className="slide">
                            <img src={paralax} alt="imagem4" />
                        </div>

                        <div className="navegation-auto">
                            <div className="auto-btn1"></div>
                            <div className="auto-btn2"></div>
                            <div className="auto-btn3"></div>
                            <div className="auto-btn4"></div>
                        </div>

                        <div className="manuel-navegation">
                            <label htmlFor="radio1" className="manuel-btn"></label>
                            <label htmlFor="radio2" className="manuel-btn"></label>
                            <label htmlFor="radio3" className="manuel-btn"></label>
                            <label htmlFor="radio4" className="manuel-btn"></label>
                        </div>
                    </div>
                </div>
            </div>

            <div className="quadg">
                <div className="quag1">
                    <h1 className="text">Temos o que você procura</h1>

                    <a className='ancoragem' href="FormPje">
                        <div className="q1">

                            <span className="namee">
                                <img src={Profiles} alt="" />
                                <span className="namen" >Quero contratar</span>
                            </span>
                            <br />
                            <span className="namee1">
                                Quero utilizar a plataforma para contratar serviços.
                            </span>
                        </div></a>

                        <a className='ancoragem' href="CadastroPF">
                    <div className="q2">
                        <span className="namee">
                            <img src={MovieProjectores} alt="" />
                            <a className='ancoragem' href="CadastroPF"> <span className="namen">Quero trabalhar</span></a>
                        </span>
                        <br />
                        <span className="namee1">
                            Quero utilizar a plataforma para divulgar o meu trabalho
                            fazendo com que ele seja visto e alcance as pessoas.
                        </span>
                    </div></a>
                    
                    <div className="q3">
                        <span className="namee3">
                            <img src={Help} alt="" />
                            <span className="namen1">Dúvidas</span>
                        </span>
                        <br />
                        <span className="namee1">
                            Tenho algumas dúvidas referente à plataforma, divulgação dos
                            serviços, acesso, entre outros.
                        </span>
                    </div>
                </div>
            </div>

            <footer id="fotv">
                <div className="logo3">
                    <img src={logo2} alt="" />
                </div>
                <ul className="footv">
                    <li className="ftv">
                        <a href='https://www.instagram.com/conectagraxa/?utm_source=ig_web_button_share_sheet&igshid=OGQ5ZDc2ODk2ZA=='><img src={InstagramCircle} alt="" /></a>
                    </li>
                    <li className="ftv">
                        < a href='https://www.linkedin.com/in/conecta-graxa-506210298/'> <img src={LinkedinCircled} alt="" /></a>
                    </li>
                    <li className="ftv">
                        <img src={GitHub} alt="" />
                    </li>
                </ul>
            </footer>

            <div className="janela-modal" id="janela-modal">
                <div className="modal">
                    <a className='nv' href='LoginFormEmpresa'> <button className="but">Empresa</button></a>
                    <a className='nv' href='LoginForm'> <button className="but">Profissional</button></a>
                </div>
            </div>

            <div className="janela-modal2" id="janela-modal2">
                <div className="modal2">
                    <a className='nv' href='FormPje'> <button className="but2">Empresa</button></a>
                    <a className='nv' href='CadastroPF'> <button className="but2">Profissional</button></a>
                </div>
            </div>

        </div>



    )

}

export default Home