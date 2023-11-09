import React from "react";
import "../assets/style.css";
import Logo from "../assets/img/logo.png"

function FormPF() {
    return (
        <fieldset className="regal-form" >
            <section className="title">
                <img id="logo" src={Logo} alt="" />
                <h1>CADASTRO</h1>
            </section>
            <section className="container-inputs">
                <section className="box1">
                    <label className="put-form" for="">Nome completo</label>
                    <input className="put-form" type="text" placeholder="Digite o seu nome" />
                    <label className="put-form" for="">Email</label>
                    <input className="put-form" type="email" name="" id="" placeholder="Digite o seu email" />
                    <label className="put-form" for="">Data de nascimento</label>
                    <input className="put-form" type="date" name="" id="" />
                    <h3>Endereço</h3>
                    <section className="endereco">
                        <section className="endereco-box1">
                            <div className="endereco-div1">
                                <label for="">CEP</label>
                                <input className="put-form" type="number" placeholder="00000-000" />
                            </div>
                            <div className="endereco-div2">
                                <label for="">Estado</label>
                                <select name="" id="">
                                    <option value="">Vazio</option>
                                </select>
                            </div>
                        </section>
                        <section className="endereco-box2">
                            <div>
                                <label for="">Cidade</label>
                                <select name="" id="">
                                    <option value="">Vazio</option>
                                </select>
                            </div>
                            <div>
                                <label for="">Rua</label>
                                <input className="put-form" type="text" placeholder="Digite sua rua" />
                            </div>
                        </section>
                    </section>
                </section>
                <section className="box2">
                    <section className="box2-div1">
                        <label for="">Número</label>
                        <input className="put-form" type="number" name="" id="" placeholder="ex:(00)0 00000-0000" />
                        <section className="opcao">
                            <div>
                                <label for="">Sexo</label>
                                <select name="" id="">
                                    <option value="">Vazio</option>
                                    <option value="">Feminino</option>
                                    <option value="">Masculino</option>
                                    <option value="">Outro</option>
                                </select>
                            </div>
                            <div>
                                <label for="">Etnia</label>
                                <select name="" id="">
                                    <option value="">Vazio</option>
                                    <option value="">Branco</option>
                                    <option value="">Preto</option>
                                    <option value="">Pardo</option>
                                    <option value="">Indígina</option>
                                    <option value="">Amarelo</option>
                                </select>
                            </div>
                        </section>
                        <label for="">Senha</label>
                        <input className="put-form" type="password" name="" id="" placeholder="********" />
                        <label className="put-form" for="">Confirmar senha</label>
                        <input className="put-form" type="password" name="" id="" placeholder="********" />
                        <div className="box-checkbox" onclick="lembrarSenha()">
                            <input className="put-form" type="checkbox" name="" id="lembrar" />
                            <label for="lembrar">Lembrar senha</label>
                        </div>
                    </section>
                    <div className="box2-div2">
                        <button>Cadastre-se</button>
                        <p>Ao criar o seu cadastro, você concorda com a nossa <a href="">política de privacidade</a>.</p>
                    </div>
                </section>
            </section>
        </fieldset>
    )
}
export default FormPF;