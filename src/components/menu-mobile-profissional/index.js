import React from "react";
import logomobile from './imagens-menu-profissional/logomobile.svg'
import menulogo from './imagens-menu-profissional/menulogo.svg'
import './index.css'


function MenuProfissional() {
    return (
        <>
            <div className="home">
                <div className="overlap-5">
                    <img className="logo" alt="Logo" src={logomobile} />

                    <img className="menu" alt="Menu" src={menulogo} />
                </div>

            </div>


            {/* refazer o modal a mão msm   esse é so um exemplo*/}
            <div className="menumodalmobi">
                <div className="div">
                    <div className="group">
                        <div className="overlap-group-wrapper">
                            <div className="overlap-group">
                                <div className="text-wrapper">Perfil</div>
                            </div>
                        </div>
                        <div className="overlap-wrapper">
                            <div className="overlap-group">
                                <div className="text-wrapper">Comunidades</div>
                            </div>
                        </div>
                        <div className="div-wrapper">
                            <div className="overlap-group">
                                <div className="text-wrapper">Oportunidades</div>
                            </div>
                        </div>
                        <div className="group-2">
                            <div className="overlap-group">
                                <div className="text-wrapper">Editar perfil</div>
                            </div>
                        </div>
                        <div className="group-3">
                            <div className="overlap-group">
                                <div className="text-wrapper">Sair</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </>

    );
};
export default MenuProfissional