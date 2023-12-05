import React from "react";
import logomobile from './imagens-menu-profissional/logomobile.svg'
import menulogo from './imagens-menu-profissional/menulogo.svg'
import './index.css'

function MenuProfissional() {
    
    const Abrirmodalmobi = () => {
        const modal = document.getElementById('geralmodalmobi');
        modal.style.display = "block";

        modal.addEventListener('click', (e) => {
            if (e.target === modal) {
                modal.style.display = "none";
            }
        });
    };

    return (
        <>
            <div className="home">
                <div className="overlap-5">
                    <img className="logo" alt="Logo" src={logomobile} />
                    <img className="menu" alt="Menu" onClick={Abrirmodalmobi} src={menulogo} />
                </div>
            </div>

            <div id="geralmodalmobi" className="geralmodalmobi">
                <div className="janelamodalmobi">
                    <div className="menu-item">Perfil</div>
                    <div className="menu-item">Comunidades</div>
                    <div className="menu-item">Oportunidades</div>
                    <div className="menu-item">Editar perfil</div>
                    <div className="menu-item">Sair</div>
                </div>
            </div>
        </>
    );
}

export default MenuProfissional;
