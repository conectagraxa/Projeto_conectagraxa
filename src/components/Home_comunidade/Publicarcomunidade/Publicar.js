import React, { useState } from "react";
// import './responsivopublicarcomuni/index.css'
import './index.css'
import IconPerfil from "../img/icon-perfil.png"

function Publicarcomunidade({ adicionarPostagem }) {
    const [descricao, setDescricao] = useState("");
    const [image, setImage] = useState(null);

    const handleTextChange =  (e) => {
        setDescricao(e.target.value);

    };

    const handleImageChange = async (e) => {
        const imageFile = e.target.files[0];
        setImage(URL.createObjectURL(imageFile));

        const data = new FormData();
    data.append("file", image);
    data.append("upload_preset", "conectaGraxa");
    data.append("cloud_name", "ds6idfbqg");

    const response = await fetch("https://api.cloudinary.com/v1_1/ds6idfbqg/image/upload", {
      method: "POST",
      body: data,
    });

   
    };

    const handlePublicarClick = () => {
        // Crie um objeto com o texto e a imagem e adicione ao estado do Peerfil
        const novaPostagem = {
            texto: descricao,
            imagem: image,
        };
        adicionarPostagem(novaPostagem);

        // Limpe os campos após a postagem
        setDescricao("");
        setImage(null);
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
                    value={descricao}
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