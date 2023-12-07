// Import React and CSS
import React from 'react';
import './style.css';
import logoUser from './imagens-NavBarUser/logoUser.png';

function Navbarempresa() {
  return (


      <div className="container_user">
      <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css'></link>

        <div className="sidebar_user sidebar-left_user" style={{ float: 'left' }}>

            
        <div className="container-elements-sidebar">
                
            <div className="imagem-redonda_user">
              <img src={logoUser} alt="Imagem Redonda" style={{ width: '100%', height: '100%' }} ></img>
            </div>
            
            <div className='navContainer'>
              <button className="botao_selected">Perfil</button>
              <button className="botao_user">Comunidade</button>
              <button className="botao_user">Oportunidades</button>
            </div>
            
            <span className="exit_user">
              <span className='iccon_user' ><i className="bi bi-box-arrow-right"></i></span>
              <div className="sairr_user"> Sair</div>
            </span>
          </div >

          </div>
      </div>



  );
};

export default Navbarempresa;
