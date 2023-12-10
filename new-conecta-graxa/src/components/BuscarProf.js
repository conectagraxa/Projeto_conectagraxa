import React, { useState, useEffect } from "react";
import "../assets/buscar-prof.css"
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import FotoPerfil from "../assets/img/foto do perfil.png"
import Compartilhar from "../assets/img/compartilhar.png"

function BuscarProf(){
    const bpCard = [
        {
            imagem: FotoPerfil,
            title_card: "Técnico de Som",
        },
        {
            imagem: FotoPerfil,
            title_card: "Técnico de Iluminação",
        },
        {
            imagem: FotoPerfil,
            title_card: "Técnico de Equipamentos",
        },
        {
            imagem: FotoPerfil,
            title_card: "Técnico de Som",
        },
        // {
        //     imagem: FotoPerfil,
        //     title_card: "Técnico de Som",
        // },
        // {
        //     imagem: FotoPerfil,
        //     title_card: "Técnico de Som",
        // }
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
        <section className="bp-fundo">
            <h2>Buscar profissionais</h2>
            <section className="bp-container">
                <section className="bp-filtros">
               
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
                <section className="bp-cards">
                    <section className={`bp-box1 ${bpScroll ? "scroll" : ""}`}>
                    {/* <section className="bp-box1 scroll"> */}
                        {bpCard.map((elemento, index) => (                            
                            <section className="bp-card" key={index}>
                                {/* <div> */}
                                    <img className="bp-compartilhar" width="24px" src={Compartilhar} alt="" />
                                {/* </div> */}
                                <img width="100px" src={elemento.imagem} alt="" />
                                <h3>{elemento.title_card}</h3>
                                <h4>Visualizar Perfil</h4>
                                <div className="bp-card-div">
                                    <input type="button" value="Candidatar-se" />
                                </div>
                            </section>
                        ))}
                    </section>
                    <section className={`bp-box2 ${bpScroll ? "scroll" : ""}`}>
                    {/* <section className="bp-box1 scroll"> */}
                        {bpCard.map((elemento, index) => (
                            <section className="bp-card" key={index}>
                                {/* <div> */}
                                    <img className="bp-compartilhar" width="24px" src={Compartilhar} alt="" />
                                {/* </div> */}
                                <img width="100px" src={elemento.imagem} alt="" />
                                <h3>{elemento.title_card}</h3>
                                <h4>Visualizar Perfil</h4>
                                <div className="bp-card-div">
                                    <input type="button" value="Candidatar-se" />
                                </div>
                            </section>
                        ))}
                    </section>
                </section>
            </section>
        </section>
    )
}
export default BuscarProf;