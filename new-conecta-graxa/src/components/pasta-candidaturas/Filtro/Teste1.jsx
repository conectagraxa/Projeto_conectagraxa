import React, { useState } from "react";
import "./Teste1.css"
import Close from '../imagens/close.jpeg'
function Teste1() {

    const [showTodosModal, setShowTodosModal] = useState(false);
    const [showIdadeModal, setShowIdadeModal] = useState(false);
    const [showGeneroModal, setShowGeneroModal] = useState(false);
    const [showFuncaoModal, setShowFuncaoModal] = useState(false);
    const [showEtniaModal, setShowEtniaModal] = useState(false);

    const handleTodosClick = () => setShowTodosModal(true);
    const handleIdadeClick = () => setShowIdadeModal(true);
    const handleGeneroClick = () => setShowGeneroModal(true);
    const handleFuncaoClick = () => setShowFuncaoModal(true);
    const handleEtniaClick = () => setShowEtniaModal(true);

    const closeTodosClick = () => setShowTodosModal(false);
    const closeIdadeClick = () => setShowIdadeModal(false);
    const closeGeneroClick = () => setShowGeneroModal(false);
    const closeFuncaoClick = () => setShowFuncaoModal(false);
    const closeEtniaClick = () => setShowEtniaModal(false);

    return (
        <div className="rectangle">
            <div className="filtros">
                <div className="overlap-group">
                    <div className="equipamentos-wrapper" onClick={handleEtniaClick}>
                        <div className="equipamentos">Etnia</div>
                    </div>
                    <div className="palco-wrapper" onClick={handleFuncaoClick}>
                        <div className="text-wrapper">Função</div>
                    </div>
                </div>
                <div className="ilumina-o-wrapper" onClick={handleGeneroClick}>
                    <div className="text-wrapper">Gênero</div>
                </div>
                <div className="div-wrapper" onClick={handleTodosClick}>
                    <div className="text-wrapper">Todos</div>
                </div>
                <div id="openModal" className="udio-e-som-wrapper" onClick={handleIdadeClick}>
                    <div className="text-wrapper">Idade</div>
                </div>
                <div className="hp">
                    {showTodosModal && <div className="popaptodos" id="popaptodos">
                        <div className="modaltodos">

                            <ul className="opc">
                                <span className="cloo"><img onClick={closeTodosClick} src={Close} alt="" ></img></span>
                                <li className="todosopc">Todos</li>
                                <li className="todosopc1">Idade</li>
                                <li className="todosopc2">Gênero</li>
                                <li className="todosopc3">Função</li>
                                <li className="todosopc4">Etnia</li>

                            </ul>
                        </div>
                    </div>}

                    {showIdadeModal && <div className="popapidade" id="popapidade">
                        <div className="modaltodos">

                            <ul className="opc">
                                <span className="cloo"><img onClick={closeIdadeClick} src={Close} alt="" ></img></span>
                                <li className="todosopc">18 a 24 anos</li>
                                <li className="todosopc1">25 a 30</li>
                                <li className="todosopc2">31 a 40</li>
                                <li className="todosopc3">+ 40 anos</li>
                                <li className="todosopc4"></li>

                            </ul>
                        </div>
                    </div>}

                    {showGeneroModal && <div className="popapgenero" id="popapgenero">
                        <div className="modaltodos">

                            <ul className="opc">
                                <span className="cloo"><img onClick={closeGeneroClick} src={Close} alt="" ></img></span>
                                <li className="todosopc">Mulher Cis</li>
                                <li className="todosopc1">Homem cis</li>
                                <li className="todosopc2">Mulher Trans</li>
                                <li className="todosopc3">Hom transem</li>
                                <li className="todosopc4">Não Binário</li>

                            </ul>
                        </div>
                    </div>}

                    {showFuncaoModal && <div className="popapfuncao" id="popapfuncao">
                        <div className="modaltodos">

                            <ul className="opc">
                                <span className="cloo"><img onClick={closeFuncaoClick} src={Close} alt="" ></img></span>
                                <li className="todosopc">Audio e som</li>
                                <li className="todosopc1">Ilunimação</li>
                                <li className="todosopc2">Palco</li>
                                <li className="todosopc3">Equipamentos</li>
                                <li className="todosopc4">Etnia</li>

                            </ul>
                        </div>
                    </div>}
                    {showEtniaModal && <div className="popapetnia" id="popapetnia">
                        <div className="modaltodos">

                            <ul className="opc">
                                <span className="cloo"><img onClick={closeEtniaClick} src={Close} alt="" ></img></span>
                                <li className="todosopc">Preto</li>
                                <li className="todosopc1">Pardo</li>
                                <li className="todosopc2">Amarelo</li>
                                <li className="todosopc3">Branco</li>
                                <li className="todosopc4">Etnia</li>

                            </ul>
                        </div>
                    </div>}
                </div>
            </div>

        </div>
    );
};

export default Teste1;
