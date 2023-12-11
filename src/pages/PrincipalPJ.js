import React, { useState, useEffect } from "react";
import "../assets/style-principal.css";
import Logo from "../assets/img/logo.png";
import Exit from "../assets/img/exit.png";
import Conexao from "../assets/img/conexao.png";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import BuscarProf from "../components/BuscarProf";
import Teste from "../components/Teste";
import VagasPubli from "../components/VagasPubli";
import Candidaturas from "../components/Candidaturas";
import FotoPerfil from "../assets/img/foto-conexoes.png"
import Oportunidades from "../components/Oportunidades";
import Candidaturas2 from "../components/pasta-candidaturas/Candidaturas";
import PerfilEmpresa from "../components/Perfilempresa/PerfilEmpresa";

function PrincipalPF() {
function deslogar(){
    localStorage.removeItem('id');

}

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

                <section className="section-left">
                    <img width="126px" src={Logo} alt="" />
                        <nav>
                            <ul>
                                <li>
                                    <Link to="/principalPJ/perfil">Perfil</Link>
                                </li>
                                <li>
                                    <Link to="/principalPJ/publicarVagas">Publicar vagas</Link>
                                </li>
                                <li>
                                    <Link to="/principalPJ/buscarProfissionais">Buscar profissionais</Link>
                                </li>
                                <li>
                                    <Link to="/principalPJ/candidaturas">Candidaturas</Link>
                                </li>
                            </ul>
                        </nav>

                        <Link onClick={deslogar} to="/">
                            
                            <div>
                                <img width="22px" src={Exit} alt="" />
                                <span>Sair</span>
                            </div>
                        </Link>
                    
                </section>
                <section className="section-center">
                    <section className="top">
                        <header>
                            <input className="buscar" type="search" name="" id="" placeholder="Buscar" />
                        </header>
                        {/* <section className="icon">
                            <div>
                                <img width="34px" src={Conexao} alt="" />
                            </div>
                        </section> */}
                    </section> 
                    <section className="feed">
                        <section>
                            <Routes>
                                <Route path="perfil" element={<PerfilEmpresa />} />
                                <Route path="publicarVagas" element={<VagasPubli />} />
                                <Route path="buscarProfissionais" element={<BuscarProf />} />
                                <Route path="candidaturas" element={<Candidaturas2 />} />
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
 
        </section>
    )
}
export default PrincipalPF;