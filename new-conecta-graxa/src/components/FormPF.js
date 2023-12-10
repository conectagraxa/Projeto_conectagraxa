import React from "react"; 
import "../assets/style.css";
import Logo from "../assets/img/logo.png"

function FormPF() {
    return(
        <main className="main-cadastro-pf">
            <fieldset className="fieldset-cadastro-pf">
                <section className="title">
                    <img id="logo" src={Logo} alt=""/>
                    <h1>CADASTRO</h1>
                </section>
                <section className="container-inputs">
                    <section className="box1">
                        <label for="">Nome completo</label>
                        <input type="text" placeholder="Digite o seu nome"/>
                        <label for="">Email</label>
                        <input type="email" name="" id="" placeholder="Digite o seu email"/>
                        <label for="">Data de nascimento</label>
                        <input type="date" name="" id=""/>
                        <h3>Endereço</h3>
                        <section className="endereco">
                            <section className="endereco-box1">
                                <div className="endereco-div1">
                                    <label for="">CEP</label>
                                    <input type="number" placeholder="00000-000"/>
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
                                    <input type="text" placeholder="Digite sua rua"/>
                                </div>
                            </section>
                        </section>
                    </section>
                    <section className="box2">
                        <section className="box2-div1">
                            <label for="">Número</label>
                            <input type="number" name="" id="" placeholder="ex:(00)0 00000-0000"/>
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
                            <input type="password" name="" id="" placeholder="********"/>
                            <label for="">Confirmar senha</label>
                            <input type="password" name="" id="" placeholder="********"/>
                            <div className="box-checkbox" onclick="lembrarSenha()">
                                <input type="checkbox" name="" id="lembrar"/>
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
        </main>
    )
}
export default FormPF;