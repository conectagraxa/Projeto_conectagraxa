import React, {useState} from "react";
import "./index.css";
import image7 from './imagensEmpresas/capa.png'
import image6 from './imagensEmpresas/perfil.png'
// import Navbarempresa from '../navbarempresa/index.js'
// import Busca from '../Busca/index.js'
// import Conexoes from '../Conexoes/index.js'
import SobreMimPopup from './popap/index.js'
import EditarPerfilPF from "../EditarPerfilPF.js";

function PerfilProfissional() {
    const [showModal, setShowModal] = useState(false);

    const fechar = () => {
        setShowModal(false);
    };

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
        <section className="perfilemre">
            {showModal && (
                <EditarPerfilPF onClose={fechar}/>
            )}
            {/* <div className="Conexoesperfilempre"><Conexoes></Conexoes></div>
            <div className="Buscaempresaperfill"><Busca></Busca></div>
            <div className="navbarempressaperfil"><Navbarempresa></Navbarempresa></div> */}


            <section className="regalperfilempresaa">
                <section className="painelperfil">
                    <div className="fotocapaempresa">
                        <img src={image7} alt="imagemdeperfil" style={{ width: '100%', height: '100%', objectFit: 'cover' }} ></img>
                    </div>
                    <section className="perfil-js-container">
                        <section className="perfil-pj-box2">
                            <div className="fotoperfilempresa">
                                <img src={image6} alt="imagemdeperfil" style={{ width: '100%', height: '100%', objectFit: 'cover' }}  ></img>
                            </div>
                            <div className="nomebutempressa">
                                <div className="segmento-localidade">
                                    <h2 className="nomeempress">Iury Silva da Costa</h2>
                                    <p className="segmentoempresa">Técnico de iluminação</p>
                                    <p className="localidadeempresa">Recife-PE</p>
                                </div>

                                

                                <button onClick={() => {setShowModal(true)}} className="nutperfilempresa" >Editar Perfil</button>
                                
                                
                            </div>
                        </section>
                    
                        <section className="dobremimempresa">
                            <section className="perfil-pj-sub-box3">
                                <h4 className="sobremimempresa2">Sobre mim</h4>
                                <div className="caixasobremimempresa">
                                    
                                    <button className="Editarsobremimperfil" onClick={openPopup}>Editar</button>
                                </div>
                                
                            </section>
                                <p>{sobreMimText}</p>
                                {isPopupOpen && (
                                <SobreMimPopup onSave={handleSaveSobreMim} onClose={closePopup} />
                            )}
                        </section>

                        {/* {isPopupOpen && (
                            <SobreMimPopup onSave={handleSaveSobreMim} onClose={closePopup} />
                        )} */}

                        <section>

                        </section>
                    </section>
                </section>

            </section >
        </section >
    )
};

export default PerfilProfissional;
