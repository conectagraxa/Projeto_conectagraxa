import React, { useState, useEffect } from "react";
import "../assets/style-oportunidades.css"
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import FotoPerfil from "../assets/img/perfil-empresa.png"
import Editar from "../assets/img/editar.png"
import Compartilhar from "../assets/img/compartilhar.png"

function Oportunidades () {
    const bpCard = [
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        {
            imagem: FotoPerfil,
            title_card: "Vaga para Técnicos de Som 2024",
        },
        // {
        //     imagem: FotoPerfil,
        //     title_card: "Vaga para Técnicos de Som 2024",
        // },
        // {
        //     imagem: FotoPerfil,
        //     title_card: "Vaga para Técnicos de Som 2024",
        // },
        // {
        //     imagem: FotoPerfil,
        //     title_card: "Vaga para Técnicos de Som 2024",
        // },
        // {
        //     imagem: FotoPerfil,
        //     title_card: "Vaga para Técnicos de Som 2024",
        // },
        // {
        //     imagem: FotoPerfil,
        //     title_card: "Vaga para Técnicos de Som 2024",
        // },
        // {
        //     imagem: FotoPerfil,
        //     title_card: "Vaga para Técnicos de Som 2024",
        // },
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
        <section className="op-fundo">
            <h2>Oportunidades</h2>
            <section className="op-container">
                <section className="op-filtros">
               
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
                <section className="op-cards">
                        <section className="op-box1">
                            <h2>Editais e Eventos</h2>
                        {/* <section className="bp-box1 scroll"> */}
                            <section className="op-sub-box1">
                                {/* <section className="op-scroll-box1"> */}
                                    {bpCard.map((elemento, index) => (                            
                                        <section className="op-card" key={index}>
                                            {/* <div> */}
                                                <img className="op-compartilhar" width="24px" src={Compartilhar} alt="" />
                                            {/* </div> */}
                                            <img width="100px" src={elemento.imagem} alt="" />
                                            <h3>{elemento.title_card}</h3>
                                            <h4>Visualizar Perfil</h4>
                                            <div className="op-card-div">
                                                <input type="button" value="Candidatar-se" />
                                            </div>
                                        </section>
                                    ))}
                                {/* </section> */}
                            </section>
                        </section>
                        <section className="op-box2">
                            <h2>Capacitações</h2>
                        {/* <section className="bp-box1 scroll"> */}
                            <section className="op-sub-box2">
                                {/* <section className="op-scroll-box2"> */}
                                    {bpCard.map((elemento, index) => (
                                        <section className="op-card" key={index}>
                                            {/* <div> */}
                                                <img className="op-compartilhar" width="24px" src={Compartilhar} alt="" />
                                            {/* </div> */}
                                            <img width="100px" src={elemento.imagem} alt="" />
                                            <h3>{elemento.title_card}</h3>
                                            <h4>Visualizar Perfil</h4>
                                            <div className="op-card-div">
                                                <input type="button" value="Candidatar-se" />
                                            </div>
                                        </section>
                                    ))}
                                {/* </section> */}
                            </section>
                        </section>
                        <section className="op-box3">
                            <h2>Histórico</h2>
                        {/* <section className="bp-box1 scroll"> */}
                            <section className="op-sub-box3">
                                {/* <section className="op-scroll-box3"> */}
                                    {bpCard.map((elemento, index) => (
                                        <section className="op-card" key={index}>
                                            {/* <div> */}
                                                <img className="op-compartilhar" width="24px" src={Compartilhar} alt="" />
                                            {/* </div> */}
                                            <img width="100px" src={elemento.imagem} alt="" />
                                            <h3>{elemento.title_card}</h3>
                                            <h4>Visualizar Perfil</h4>
                                            <div className="op-card-div">
                                                <input type="button" value="Candidatar-se" />
                                            </div>
                                        </section>
                                    ))}
                                {/* </section> */}
                            </section>
                        </section>
                </section>
            </section>
        </section>
    )
}
export default Oportunidades;