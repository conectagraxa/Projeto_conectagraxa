import React from "react";
import "../../../assets/style-principal.css";

import logo from '../../../assets/img/logo.png'
import exit from '../../../assets/img/exit.png'
import conexao from '../../../assets/img/conexao.png'
import EditarPerfil from './../../../components/EditarPerfil'

function Principal() {
    return (
        <div>
            <section className="principal">
                <section className="section-left">
                    <img width="126px" src={logo} alt="" />
                    <nav>
                        <ul className="bab" >
                            <li className="beb"  >Perfil</li>
                            <li className="beb" >Publicar Vagas</li>
                            <li className="beb" >Buscar Profissionais</li>
                            <li className="beb" >Candidaturas</li>
                        </ul>
                    </nav>
                    <div>
                        <img width="22px" src={exit} alt="" />
                        <span>Sair</span>
                    </div>
                </section>
                <section className="section-center">
                    <section className="top">
                        <header>
                            <input type="search" name="" id="" />
                        </header>
                        <section className="icon">
                            <div>
                                <img width="34px" src={conexao} alt="" />
                            </div>
                        </section>
                    </section>
                    <section className="feed">
                        <section>
                            {/* Os componentes entram aqui */}
                            <EditarPerfil />
                        </section>
                    </section>
                </section>
                <section className="section-right">
                    <h3>Conexões</h3>
                    <p>Dúvidas? Veja as perguntas frequentes aqui.</p>
                </section>
            </section>
        </div>
    )
}
export default Principal;