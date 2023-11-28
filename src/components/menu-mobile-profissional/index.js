import React from "react";
import logomobile from './imagens-menu-profissional/logomobile.svg'
import menulogo from './imagens-menu-profissional/menulogo.svg'
import './index.css'

function MenuProfissional() {
    return (
        <div className="geral-menu-profissional">
            <div className="logomobille">
                <img className="imagemlogomobile" src={logomobile} alt="imagemlogomobile"></img>
                <img className="imagemlogohamburguer" src={menulogo} alt="imagem do menu da logo"></img>
            </div>
        </div>
    )
}
export default MenuProfissional