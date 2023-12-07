import React from "react";
import "./index.css";
import photoPerfil from './imagens/foto do perfil.png';
import bg from './imagens/Fundo.png';
import NavBarUser from '../NavBarUser/index.js';
import BuscaUser from '../BuscaUser/index.js';
import Conexoes from '../Conexoes/index.js';



function PerfilUsuario() {
    return (
        <div className="perfilUser">
            
            <link rel='stylesheet' href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.18.0/dist/css/bootstrap-icons.min.css"></link>

            <div className="Conexoesperfilempre"><Conexoes></Conexoes></div>
            <div className="Buscaempresaperfill"><BuscaUser></BuscaUser></div>
            <div className="navbarempressaperfil"><NavBarUser></NavBarUser></div>


            <div className="containerPerfilUser">
                <div className="painelperfil">
                    
                    <div className="fotocapaempresa"><img src={bg} alt="imagemdeperfil" style={{ width: '100%', height: '100%', objectFit: 'cover' }} ></img></div>
                    
                    
                    <div className="fotoContainer">
                        
                    <div className="fotoPerfilUser"><img src={photoPerfil} alt="imagemdeperfil" style={{ width: '100%', height: '100%', objectFit: 'cover' }}  ></img></div>
                    
                        <div className="baseInfo">
                            <div className="caixaNomePronome">
                                <h3 className="nomeUser">Iury Silva da Costa</h3>
                                <span className="pronome">Ele/Dele</span>    
                            </div>
                            <div className="caixaProfLocal">    
                                <p className="profissao">Técnico de Iluminação</p>
                                <p className="localidade">Recife - PE</p>
                            </div>    
                        </div>
                        <button className="editPerfil" >Editar Perfil</button>    
                    </div>
                    
                    <section className="sectionBio">
                        <div className="sobreMimUser">
                            <h3 className="sobreMimTitle">Sobre Mim</h3>
                            <p className="sobreMimContent">Técnico de iluminação altamente qualificado, apaixonado por teatro, que domina a arte de criar ambientes cativantes e realçar as performances por meio de uma iluminação teatral precisa e envolvente.</p>
                        </div>

                        <div className="habilidadesUser">
                            <h3 className="habTitle">Habilidades </h3>
                            <div className="habContent">
                                <ul>
                                    <li>Iluminação Teatral</li>
                                    <li>Controle de Efeitos de Luz</li>
                                    <li>Colaboração com equipe</li>
                                    <li>Adaptação a estilos</li>
                                </ul>
                            </div>
                        </div>

                        <div className="cursosUser">
                            <h3> <i className="bi bi-mortarboard-fill"></i> Cursos:</h3>
                            <div> 
                                <h4 className="cursosInstitution">Senac</h4>
                                <p className="cursoName">Técnico em Iluminação</p>
                                <p className="cursoPeriod">(2023.2 - 2024.1)</p>
                            </div>
                            <div>
                                <h4 className="cursosInstitution">Senai</h4>
                                <p className="cursoName">Iluminação Teatral</p>
                                <p className="cursoPeriod">(2023.2 - 2024.1)</p>
                            </div>                           
                        </div>

                    </section>

                <hr className="classHr"></hr>

                <section className="section-pub">
                    <h2 className="sectionTitle"><i className = "bi bi-card-heading"></i> Veja minhas publicações</h2>
                    <div className="centraliza">     
                        <div className="postContainer">
                        
                            <div className="postEdit">
                                
                                <div className="userInfo">
                                    <img className="pubPhoto"src={photoPerfil} alt="imagemdeperfil" ></img> 
                                    <div className="userThreeElements">
                                        <div className="userNameIcon">
                                            <h3>Iury Silva da Costa</h3>
                                            <span><i className="bi bi-globe-americas"></i></span>
                                        </div>   
                                        <p className="pubData">25 de set</p>
                                    </div>
                                </div>
                                
                                <button className="threeDots"><i className="bi bi-three-dots-vertical"></i></button>  
                            </div>
                            <p className="pubContent">🎥🔊🌟
            Você já se perguntou como é possível transformar um simples palco em um espetáculo inesquecível? Bem, a resposta está nos bastidores, com nossa dedicada equipe de produção técnica de shows! 💡💼</p>        

                        </div> 
                    </div>
                        
                        
                </section>  
  

                </div>
            </div>
        </div>
    )
};

export default PerfilUsuario;
