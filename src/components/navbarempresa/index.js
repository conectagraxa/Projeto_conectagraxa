// Import React and CSS
import React from 'react';
import './styleempresa.css';
import logoempresa from './imagens-navbarempresa/logoempresa.png'
function Navbarempresa() {
  return (


      <div className="container_empresa">
      <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css'></link>

        <div className="top-container"></div>
        <div className="sidebar_empresa sidebar-left" style={{ float: 'left' }}>
          <div className="imagem-redonda_empresa">
            <img src={logoempresa} alt="Imagem Redonda" style={{ width: '100%', height: '100%' }} ></img>
          </div>
          <br />
          <br />
          <button className="botao_empresa">Perfil</button>
          <br />
          <button className="botao_empresa">Publicar vagas</button>
          <br />
          <button className="botao_empresa">Buscar Profissionais</button>
          <button className="botao_empresa">Candidaturas</button>

          <span className="exit_empresa">
            <span className='iccon_empresa' ><i className="bi bi-box-arrow-right"></i></span>
            <div className="sairr_empresa"> Sair</div>
          </span>
        </div>
      </div>



  );
};

export default Navbarempresa;
