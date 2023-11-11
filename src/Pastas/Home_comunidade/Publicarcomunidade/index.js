import React, { useState } from "react";

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
        <div className="geralpublicarc">


            <link rel="stylesheet" href="./Publicarcomunidade/index.css"></link>
            <div className="Novap">Nova Publicação</div>

            <div className="perfilpublic">
                <img className="imgp" src="" alt="Profile" />
                <input
                    className="putp"
                    type="text"
                    placeholder="Digite aqui suas ideias"
                    value={postText}
                    onChange={handleTextChange}
                ></input>
            </div>
            <div className="perfilpublic1">
                <span className="sp">
                    <input className="putpp" type="file" name="imagem"id="imagem"accept="image/*"
                        onChange={handleImageChange}></input>
                </span>
                <button className="butonp" onClick={handlePublicarClick}>Publicar</button>
            </div>
        </div>
    );
}

export default Publicarcomunidade;