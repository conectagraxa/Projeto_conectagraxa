import React, {useState} from "react";
import "./index.css";
import image7 from './imagensEmpresas/image 7.svg'
import image6 from './imagensEmpresas/image 6.svg'
import Navbarempresa from '../navbarempresa/index.js'
import Busca from '../Busca/index.js'
import Conexoes from '../Conexoes/index.js'
import SobreMimPopup from './popap/index.js'



function PerfilEmpresas() {

    const [sobreMimText, setSobreMimText] = useState("");
    const [isPopupOpen, setIsPopupOpen] = useState(false);

    const handleSaveSobreMim = (text) => {
        setSobreMimText(text);
    };

    const openPopup = () => {
        setIsPopupOpen(true);
    };

    const closePopup = () => {
        setIsPopupOpen(false);
    };

    return (
        <div className="perfilemre">

            <div className="Conexoesperfilempre"><Conexoes></Conexoes></div>
            <div className="Buscaempresaperfill"><Busca></Busca></div>
            <div className="navbarempressaperfil"><Navbarempresa></Navbarempresa></div>


            <div className="regalperfilempresaa">
                <div className="painelperfil">
                    <div className="fotocapaempresa"><img src={image7} alt="imagemdeperfil" style={{ width: '100%', height: '100%', objectFit: 'cover' }} ></img></div>
                    <div className="fotoperfilempresa"><img src={image6} alt="imagemdeperfil" style={{ width: '100%', height: '100%', objectFit: 'cover' }}  ></img></div>
                    <div className="nomebutempressa">
                        <h2 className="nomeempress">MUSICAL CASA</h2>
                        <button className="nutperfilempresa" >Editar Perfil</button>
                    </div>
                    <div className="segmento-localidade">
                        <p className="segmentoempresa">Eventos</p>
                        <p className="localidadeempresa">Recife-PE</p>
                    </div>

                    <div className="dobremimempresa">
                        <h4 className="sobremimempresa2">Sobre mim</h4>
                        <div className="caixasobremimempresa">
                            <p>{sobreMimText}</p>
                            <button className="Editarsobremimperfil" onClick={openPopup}>Editar</button>
                        </div>
                    </div>

                    {isPopupOpen && (
                        <SobreMimPopup onSave={handleSaveSobreMim} onClose={closePopup} />
                    )}
                </div>

            </div >
        </div >
    )
};

export default PerfilEmpresas
