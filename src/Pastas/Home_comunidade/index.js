import React, { useState } from "react";
import Publicarcomunidade from "./Publicarcomunidade";
import Exemplo from "./Exemplo";
import Buscar from '../Busca/index.js'
import Navbar from "../navbar/index.js";

function Home_comunidade() {
    const [postagens, setPostagens] = useState([]);

    const adicionarPostagem = (novaPostagem) => {
        setPostagens([...postagens, novaPostagem]);
    };

    return (
        <body>
            <div className="ggeral">


                <span className="navbarcomunit">
                    <Buscar></Buscar>
                </span>
                <span className="publicarcomuni">
                    <Publicarcomunidade adicionarPostagem={adicionarPostagem} />
                </span>
                <div className="geralperfil">
                    <Exemplo Publicarcomunidade={Publicarcomunidade} />

                    <div className="postagens-container">
                        {postagens.map((postagem, index) => (
                            <div key={index} className="postagem">
                                <p  >{postagem.texto}</p>
                                {postagem.imagem && (
                                    <img
                                        src={postagem.imagem}
                                        alt="Postagem"
                                        style={{ maxWidth: "100%", maxHeight: "100%", }}
                                    />
                                )}
                            </div>
                        ))}
                    </div>
                </div>
                <span className="navbarhomecomunit">
                    <Navbar></Navbar>

                </span>
            </div>
        </body>
    );
}

export default Home_comunidade;
