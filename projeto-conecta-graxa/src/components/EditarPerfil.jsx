import React from "react";
import Capa from "../assets/img/capa.png"
import Perfil from "../assets/img/perfil.png"

function EditarPerfil() {
    return(
        <section>
           <h2>Editar Perfil</h2>
           <img src={Capa} alt="" />
           <section>
                <img src={Perfil} alt="" />
           </section>
        </section>
    )
}
export default EditarPerfil;