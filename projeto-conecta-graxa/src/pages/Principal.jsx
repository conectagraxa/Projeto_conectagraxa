import React, { useState } from "react";
import "../assets/style-principal.css";
import Logo from "../assets/img/logo.png";
import Exit from "../assets/img/exit.png";
import Conexao from "../assets/img/conexao.png";
import EditarPerfil from "../components/EditarPerfil";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import BuscarProf from "../components/BuscarProf";
import Perfil from "../components/Perfil";
import VagasPubli from "../components/VagasPubli";

function Principal() {
    const [showModal, setShowModal] = useState(false);

    const fechar = () => {
        setShowModal(false);
    };

    return(
        <section className="principal">
            <BrowserRouter>
                <section className="section-left">
                    <img width="126px" src={Logo} alt="" />
                        <nav>
                            <ul>
                                <li><Link to="/perfil">Perfil</Link></li>
                                <li><Link to="">Comunidade</Link></li>
                                <li><Link to="/publicarvagas">Publicar Vagas</Link></li>
                                <li><Link to="/busca">Buscar Profissionais</Link></li>
                                <li><Link to="">Candidaturas</Link></li>
                            </ul>
                        </nav>
                        
                    <div onClick={() => {setShowModal(true)}}>
                        <img width="22px" src={Exit} alt="" />
                        <span>Sair</span>
                    </div>
                </section>
                <section className="section-center">
                    <section className="top">
                        <header>
                            <input type="search" name="" id="" />
                        </header>
                        {/* <section className="icon">
                            <div>
                                <img width="34px" src={Conexao} alt="" />
                            </div>
                        </section> */}
                    </section> 
                    <section className="feed">
                        <section>
                            {/* Os componentes entram aqui */}
                            {showModal && (
                            <EditarPerfil onClose={fechar}/>
                            )}
                            <Routes>
                                <Route path="/perfil" element={<Perfil/>} />
                                <Route path="/busca" element={<BuscarProf/>} />
                                <Route path="/publicarvagas" element={<VagasPubli/>} />
                            </Routes>
                        </section>
                    </section>
                </section>
                <section className="section-right">
                    <h3>Conexões</h3>
                    <p>Dúvidas? Veja as perguntas frequentes aqui.</p>
                </section>
            </BrowserRouter>
        </section>
    )
}
export default Principal;