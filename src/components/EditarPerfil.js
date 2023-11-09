import React from "react";
import capa from './../assets/img/capa.png'
import perfil from './../assets/img/perfil.png'

function EditarPerfil() {
    return (
        <section>
            <h2>Editar Perfil</h2>
            <img src={capa} alt="capa" />
            <section>
                <img src={perfil} alt="perfil" />
            </section>
        </section>
    )
}
export default EditarPerfil;