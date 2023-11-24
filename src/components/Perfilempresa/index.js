import React from "react";
import "./index.css";
import image7 from './imagensEmpresas/image 7.svg'
import image6 from './imagensEmpresas/image 6.svg'
import Navbarempresa from '../navbarempresa/index.js'
import Busca from '../Busca/index.js'
import Conexoes from '../Conexoes/index.js'



function PerfilEmpresas() {
    return (
        <div className="perfilemre">

            <div className="Conexoesperfilempre"><Conexoes></Conexoes></div>
            <span className="Buscaempresaperfill"><Busca></Busca></span>
            <span className="navbarempressaperfil"><Navbarempresa></Navbarempresa></span>


            <div className="regalperfilempresaa">
                <div className="painelperfil">
                    <div className="fotocapaempresa"><img src={image7} alt="imagemdeperfil" style={{ width: '100%', height: '100%', objectFit: 'cover' }} ></img></div>
                    <div className="fotoperfilempresa"><img src={image6} alt="imagemdeperfil" style={{ width: '100%', height: '100%', objectFit: 'cover' }}  ></img></div>
                    <div className="nome-but-empressa">
                        <h1 className="nomeempress"></h1>
                        <button>Editar Perfil</button>
                    </div>
                    <div className="segmento-localidade">
                        <p className="segmentoempresa">Eventos</p>
                        <p className="localidadeempresa">Recife</p>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default PerfilEmpresas
