import React from "react";
import Capa from "./CapaPerfilUsuario/capa.png"
import Perfil from "./CapaPerfilUsuario/perfil.png"
import "./style-edit-perfil.css";
import Close from "./CapaPerfilUsuario/close.png"

function EditarPerfil({ onClose }) {

    return(
        <section className="fundoEditar">
            <section className="modalEditar">
                <section className="header-modalEditar">
                    <h1 className="classH1">Editar Perfil</h1>
                    <img width="18px" src={Close} alt="" onClick={onClose}/>
                </section>
                <section className="main-modalEditar">
                    <figure>
                        <img id="capa" src={Capa} alt="capa" />
                    </figure>
                    <section className="container-modalEditar">
                        <img id="perfil" src={Perfil} alt="perfil" />    
                        <fieldset className="classFieldset">
                            <h2 className="classH2">Informações da conta</h2>
                            <section className="container-info">
                                <section className="box1-modalEditar">
                                    <label for="">Nome completo <span className="classSpan">*</span></label>
                                    <input type="text" name="" id="" className="classInput" placeholder="Company Name"/>
                                    <label for="">Email <span className="classSpan">*</span></label>
                                    <input type="email" name="" id="" className="classInput" placeholder="company@gmail.com"/>
                                    <label for="">Número <span className="classSpan">*</span></label>
                                    <input type="number" name="" id="" className="classInput" placeholder="ex:(00)0 00000-0000"/>
                                    <h3 className="classH3">Endereço <span className="classSpan">*</span></h3>
                                    <section className="endereco">
                                        <section className="endereco-box1">
                                            <div className="endereco-div1">
                                                <label for="">CEP</label>
                                                <input type="number" className="classInput" placeholder="50100-170"/>
                                            </div>
                                            <div className="endereco-div2">
                                                <label for="">Estado</label>
                                                <select name="" id="" className="classSelect">
                                                    <option value="">Pernambuco</option>
                                                </select>
                                            </div>
                                        </section>
                                        <section className="endereco-box2">
                                            <div>
                                                <label for="">Cidade</label>
                                                <select name="" id="" className="classSelect">
                                                    <option value="">Recife</option>
                                                </select>
                                            </div>
                                            <div>
                                                <label for="">Rua</label>
                                                <input type="text" className="classInput" placeholder="R. do Pombal"/>
                                            </div>
                                        </section>
                                    </section>
                                </section>
                                <section className="box2-modalEditar">
                                    <label for="">Nome social</label>
                                    <input type="text" className="classInput" placeholder="Company Name"/>
                                    <label for="">Data de nascimento <span className="classSpan">*</span></label>
                                    <input type="date" name="" id="" className="classInput" disabled/>
                                    <section className="opcao">
                                        <div>
                                            <label for="">Sexo</label>
                                            <select name="" id="" className="classSelect">
                                                <option value="">Vazio</option>
                                                <option value="">Feminino</option>
                                                <option value="">Masculino</option>
                                                <option value="">Outro</option>
                                            </select>
                                        </div>
                                        <div>
                                            <label for="">Etnia</label>
                                            <select name="" id="" className="classSelect">
                                                <option value="">Vazio</option>
                                                <option value="">Branco</option>
                                                <option value="">Preto</option>
                                                <option value="">Pardo</option>
                                                <option value="">Indígina</option>
                                                <option value="">Amarelo</option>
                                            </select>
                                        </div>
                                    </section>
                                </section>
                            </section>
                            <h2 className="classH2">Configurações de senha</h2>
                            <section className="container-senha">
                                <section className="box1-senha">
                                    <label for="">Confirmar senha atual <span className="classSpan">*</span></label>
                                    <input type="password" name="" id="" className="classInput" placeholder="********"/>

                                    <p><a href="">Esqueceu a senha? Receba no email</a></p>
                                </section>
                                <section className="box2-senha">
                                    <label for="">Nova senha</label>
                                    <input type="password" name="" id="" className="classInput" placeholder=""/>
                                    <label for="">Confirmar nova senha</label>
                                    <input type="password" name="" id="" className="classInput" placeholder=""/>
                                    <button>Salvar</button>
                                </section>
                            </section>
                            <section className="modalEditar-cursos">
                                <h2 className="classH2">Cursos e aperfeiçoamentos</h2>
                                <label for="">Instituição de ensino</label>
                                <input type="text" name="" id="" className="classInput" placeholder="Ex: Faculdade Senac Pernambuco"/>
                                <label for="">Curso</label>
                                <input type="text" name="" id="" className="classInput" placeholder="Ex: Ciência da Computação"/>
                                <label htmlFor="">Diploma</label>
                                <input type="text" name="" id="" className="classInput" placeholder="Ex: Bacharelado" />
                                <label htmlFor="">Data de início</label>
                                <input type="date" name="" id="" className="classInput" />
                                <label htmlFor="">Data de término</label>
                                <input type="date" name="" id="" className="classInput"/>
                                <button>Adicionar</button>
                            </section>
                        </fieldset>
                    </section>
                </section> 
            </section>
        </section>
    )
}
export default EditarPerfil;