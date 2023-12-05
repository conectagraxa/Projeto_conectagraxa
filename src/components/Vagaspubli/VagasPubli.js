import React from "react"
import "./style2.css"

function VagasPubli () {
    return(
        <section className="container_page">
            <section className="title_oportu">
                <h2 className="textmid1_side">Publicar oportunidade</h2>
            </section>
            <div className="profil88">
                <div className="profil_dentro">
                    <p className="vaga_campo">Título da vaga:</p>
                    <input class="input_mid" type="text" placeholder="Ex.:Vaga de técnico..."/>
                </div>
                <div className="profil_dentro">
                    <p className="vaga_campo">Categoria da vaga:</p>
                        <select class="input_mid">
                            <option>Som</option>
                            <option>Áudio</option>
                            <option>Iluminação</option>
                            <option>Palco</option>
                            <option>Equipamentos</option>
                        </select>
                </div>
                <div className="profil_dentro">
                    <p className="vaga_campo">Descrição da vaga:</p>
                    <input class="input_mid2" type="text" placeholder="Ex.:Operar sistemas de som e equipamentos de áudio durante o evento..."/>
                </div>
                <div class="profil_dentro">
                    <p className="vaga_campo">Contatos/links:</p>
                    <input class="input_mid" type="text" placeholder="https:www.vaga.com.br"/>
                </div>  
                
            </div>
            <div class="profil_dentro2">
                <button id="profilutton">Publicar</button>   
            </div>
        </section>
    )
}
export default VagasPubli;