import React, { useState } from "react";
import "../assets/style-principal.css";
import Logo from "../assets/img/logo.png"
import Exit from "../assets/img/exit.png"
import Conexao from "../assets/img/conexao.png"
import EditarPerfil from "../components/EditarPerfil"

function Principal() {
    const [minimizar, setMinimizar] = useState();

    function mover() {
        if (minimizar=true){

        }
    }

    return(
        <section className="principal">
            <section className="section-left">
                <img width="126px" src={Logo} alt="" />
                <nav>
                    <ul>
                        <li>Perfil</li>
                        <li>Publicar Vagas</li>
                        <li>Buscar Profissionais</li>
                        <li>Candidaturas</li>
                    </ul>
                </nav>
                <div>
                    <img width="22px" src={Exit} alt="" />
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
                            <img width="34px" src={Conexao} alt="" />
                        </div>
                    </section>
                </section> 
                <section className="feed">
                    <section>
                        {/* Os componentes entram aqui */}
                        <EditarPerfil/>
                    </section>
                </section>
            </section>
            <section className="section-right">
                <h3>Conexões</h3>
                <p>Dúvidas? Veja as perguntas frequentes aqui.</p>
            </section>
        </section>
    )
}
export default Principal;