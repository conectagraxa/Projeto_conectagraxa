// Import React and CSS
import React from 'react';
import './responsivenavbar/index.css'
import './style.css';
import logo from './imagens-navbar/logo.png'
function Navbar() {
  return (


    <div className="containernavbar">
      <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css'></link>

      <div className="top-container"></div>
      <div className="imagem-redonda">
        <img src={logo} alt="Imagem Redonda" style={{ width: '100%', height: '100%' }} ></img>
      </div>
      <br />
      <br />
      <button className="botaonavbar">Perfil</button>
      <br />
      <button className="botaonavbar">Comunidade</button>
      <br />
      <button className="botaonavbar">Oportunidades</button>
      <span className="exit">
        <span className='iccon' ><i className="bi bi-box-arrow-right"></i></span>
        <div className="sairr"> Sair</div>
      </span>
    </div>



  );
};

export default Navbar;
