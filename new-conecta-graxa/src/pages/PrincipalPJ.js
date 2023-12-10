import React, { useState, useEffect } from "react";
import "../assets/style-principal.css";
import Logo from "../assets/img/logo.png";
import Exit from "../assets/img/exit.png";
import Conexao from "../assets/img/conexao.png";
import EditarPerfil from "../components/EditarPerfil";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import BuscarProf from "../components/BuscarProf";
import Perfil from "../components/Perfil";
import VagasPubli from "../components/VagasPubli";
import Candidaturas from "../components/Candidaturas";
import FotoPerfil from "../assets/img/foto-conexoes.png"
import Oportunidades from "../components/Oportunidades";

function PrincipalPJ() {
    const [showModal, setShowModal] = useState(false);

    const fechar = () => {
        setShowModal(false);
    };

    const conexaoCard = [
        {
            imagem: FotoPerfil,
            title_card: "Lívia Gomes",
            desc_card: "Técnica de som",
        },
        {
            imagem: FotoPerfil,
            title_card: "Matheus Gomes",
            desc_card: "Técnico de luz",
        },
        {
            imagem: FotoPerfil,
            title_card: "Leandro Marques",
            desc_card: "Técnico de eletricidade",
        },
        {
            imagem: FotoPerfil,
            title_card: "Lívia Gomes",
            desc_card: "Técnica de som",
        },
        {
            imagem: FotoPerfil,
            title_card: "Matheus Gomes",
            desc_card: "Técnico de luz",
        },
        {
            imagem: FotoPerfil,
            title_card: "Leandro Marques",
            desc_card: "Técnico de eletricidade",
        },
        // {
        //     imagem: FotoPerfil,
        //     title_card: "Matheus Gomes",
        //     desc_card: "Técnico de luz",
        // },
        // {
        //     imagem: FotoPerfil,
        //     title_card: "Leandro Marques",
        //     desc_card: "Técnico de eletricidade",
        // }
    ];

    const [conexaoScroll, setConexaoScroll] = useState(false);

    useEffect(() => {
        if (conexaoCard.length > 7) {
            setConexaoScroll(true);
        } else {
            setConexaoScroll(false);
        }
    }, [conexaoCard]);

    return(
        <section className="principal">
            <BrowserRouter>
                <section className="section-left">
                    <img width="126px" src={Logo} alt="" />
                        <nav>
                            <ul>
                                <li><Link to="/perfil">Perfil</Link></li>
                                <li><Link to="">Comunidade</Link></li>
                                <li><Link to="/oportunidades">Oportunidades</Link></li>
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
                            <input type="search" name="" id="" placeholder="Buscar" />
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
                                <Route path="/candidaturas" element={<Candidaturas/>} />
                                <Route path="/oportunidades" element={<Oportunidades/>} />
                            </Routes>
                        </section>
                    </section>
                </section>
                <section className="section-right">
                    <h3>Conexões</h3>
                    <section className={`box-conexoes ${conexaoCard ? "conexao-scroll" : ""}`}>
                        {conexaoCard.map((elemento, index) => (                            
                                <section className="conexao-card" key={index}>
                                    <img width="74px" src={elemento.imagem} alt="" />
                                    <div className="conexao-card-div">
                                        <h3>{elemento.title_card}</h3>
                                        <h4>{elemento.desc_card}</h4>
                                        <input type="button" value="Conectar" />
                                    </div>
                                </section>
                            ))}
                    </section>
                    <p>Dúvidas? Veja as perguntas frequentes aqui.</p>
                </section>
            </BrowserRouter>
        </section>
    )
}
export default PrincipalPJ;