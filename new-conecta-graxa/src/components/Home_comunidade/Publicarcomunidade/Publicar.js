import React, { useState } from "react";
// import './responsivopublicarcomuni/index.css'
import './index.css'
import IconPerfil from "../img/icon-perfil.png"

function Publicarcomunidade({ adicionarPostagem }) {
    const [postText, setPostText] = useState("");
    const [posterImage, setPosterImage] = useState(null);

    const handleTextChange = (e) => {
        setPostText(e.target.value);
    };

    const handleImageChange = (e) => {
        const imageFile = e.target.files[0];
        setPosterImage(URL.createObjectURL(imageFile));
    };

    const handlePublicarClick = () => {
        // Crie um objeto com o texto e a imagem e adicione ao estado do Peerfil
        const novaPostagem = {
            texto: postText,
            imagem: posterImage,
        };
        adicionarPostagem(novaPostagem);

        // Limpe os campos após a postagem
        setPostText("");
        setPosterImage(null);
    };

    return (
        <section className="geralpublicarc">
            <link rel="stylesheet" href="./Publicarcomunidade/index.css"></link>
            <h2 className="Novap">Nova Publicação</h2>
            
            <div className="perfilpublic-box1">
                <img className="imgp" src={IconPerfil} alt="Profile" />
                <input
                    className="putp"
                    type="text"
                    placeholder="Digite aqui suas ideias"
                    value={postText}
                    onChange={handleTextChange}
                ></input>
            </div>
            <div className="perfilpublic-box2">
                <span className="sp">
                    <input className="putpp" type="file" name="imagem"id="imagem"accept="image/*"
                        onChange={handleImageChange}></input>
                </span>
                <button className="butonp" onClick={handlePublicarClick}>Publicar</button>
            </div>
        </section>
    );
}

export default Publicarcomunidade;