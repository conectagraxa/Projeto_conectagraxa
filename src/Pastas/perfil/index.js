import React, { useState } from "react";
import Publicarcomunidade from "./Publicarcomunidade";
import Exemplo from "./Exemplo";

function Peerfil() {
    const [postagens, setPostagens] = useState([]);

    const adicionarPostagem = (novaPostagem) => {
        setPostagens([...postagens, novaPostagem]);
    };

    return (
        <div className="ggeral">
            <Publicarcomunidade adicionarPostagem={adicionarPostagem} />

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
        </div>
    );
}

export default Peerfil;
