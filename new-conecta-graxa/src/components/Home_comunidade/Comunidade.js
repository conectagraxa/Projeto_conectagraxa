import React, { useState } from "react";
import Publicarcomunidade from "./Publicarcomunidade/Publicar.js";
import Exemplo from "./Exemplo/index.js";
// import Buscar from '../../components/Busca/index.js'
// import Navbar from "../../components/navbar/index.js";
// import Conexoes from "../../components/Conexoes/index.js"
import './index.css'
// import MenuProfissional from "../../components/menu-mobile-profissional/index.js"

function Comunidade() {
    const [postagens, setPostagens] = useState([]);

    const adicionarPostagem = (novaPostagem) => {
        setPostagens([...postagens, novaPostagem]);
    };

    return (
        <section className="ggeral">

            {/* <span className="menumobii">
                <MenuProfissional></MenuProfissional>
            </span> */}

            {/* <span className="navbarcomunit">
                <Buscar></Buscar>
            </span> */}
            {/* <span className="conecxoes" >
                <Conexoes></Conexoes>
            </span> */}
            <section className="publicarcomuni">
                <Publicarcomunidade adicionarPostagem={adicionarPostagem} />
            </section>
            <section className="geralperfil">
                <Exemplo Publicarcomunidade={Publicarcomunidade} />

                <div className="postagens-container">
                    {postagens.map((postagem, index) => (
                        <section key={index} className="postagem">
                            <p  >{postagem.texto}</p>
                            {postagem.imagem && (
                                <img
                                    src={postagem.imagem}
                                    alt="Postagem"
                                    style={{ maxWidth: "100%", maxHeight: "100%", }}
                                />
                            )}
                        </section>
                    ))}
                </div>
            </section>
            {/* <div className="navbarhomecomunit">
                <Navbar></Navbar>
            </div> */}

        </section>
    );
}

export default Comunidade;
