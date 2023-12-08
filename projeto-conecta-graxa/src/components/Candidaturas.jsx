import React, { useState, useEffect } from "react";
import "../assets/candidaturas.css"
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import FotoPerfil from "../assets/img/perfil-empresa.png"
import Editar from "../assets/img/editar.png"

function Candidaturas () {
    const bpCard = [
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        {
            imagem: FotoPerfil,
            title_card: "Técnico de Som",
        }
    ];

    const [bpScroll, setBpScroll] = useState(false);

    useEffect(() => {
        if (bpCard.length > 4) {
          setBpScroll(true);
        } else {
          setBpScroll(false);
        }
    }, [bpCard]);

    return (
        <section className="candi-fundo">
            <h2>Candidaturas</h2>
            <section className="candi-container">
                <section className="candi-filtros">
               
                    <nav>
                        <ul>
                            <li><Link to="">Todos</Link></li>
                            <li><Link to="">Áudio e Som</Link></li>
                            <li><Link to="">Iluminação</Link></li>
                            <li><Link to="">Palco</Link></li>
                            <li><Link to="">Equipamentos</Link></li>
                        </ul>
                    </nav>
                  
                </section>
                <section className={`candi-cards ${bpScroll ? "candi-scroll" : ""}`}>
                    <section className="candi-box1">
                    {/* <section className="candi-box1 scroll"> */}
                        {bpCard.map((elemento, index) => (                            
                            <section className="candi-card" key={index}>
                                {/* <div> */}
                                    <img className="candi-compartilhar" width="14px" src={Editar} alt="" />
                                {/* </div> */}
                                <img width="120px" src={elemento.imagem} alt="" />
                                <h3>{elemento.title_card}</h3>
                                <div className="candi-card-div">
                                    <input type="button" value="Visualizar Vaga" />
                                </div>
                            </section>
                        ))}
                    </section>
                </section>
            </section>
        </section>
    )
}
export default Candidaturas;