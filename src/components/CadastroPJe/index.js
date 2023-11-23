import "./index.css"
import logo from "./imagens-formpje/logo.jpg"

function FormPje() {
    return (
        <main className="mainof_pj">
            <div class="bolax1_pj"></div>
            <div class="bolax2_pj"></div>

            <fieldset className="fieldset_pj">
                <span className="superior_pj">
                    <img id="logo_pj" src={logo} alt="" />
                    <h1 className="title_pj">CADASTRO</h1>
                </span>
                <form className="formulario_pj">
                    <section className="boxform1_pj">
                        <div className="inputbox_formpj">
                            <label for="pfnf">Pessoa física ou nome fantasia</label>
                            <input className="inputbb_formpj" type="text" name="pfnf" placeholder="Digite seu nome ou nome da empresa" required />
                        </div>

                        <div className="inputbox_formpj">
                            <label for="fone">Telefone/Celular corporativo</label>
                            <input className="inputbb_formpj" type="text" name="celular" placeholder="Ex.: (00) 0 0000-0000" required />
                        </div>

                        <div className="inputbox_formpj">
                            <label for="Email">Email</label>
                            <input className="inputbb_formpj" type="email" name="Email" placeholder="Digite o seu email" />
                        </div>

                        <div className="inputbox_formpj">
                            <label for="Senha">Senha</label>
                            <input className="inputbb_formpj" type="password" name="Senha" placeholder="************" required />
                        </div>

                        <div className="lembrar_formpj" onclick="lembrarSenha()">
                            <input type="checkbox" name="remember-me" id="lembrar" className="relembra" />
                            <label for="lembrar" className="lembrar_formpj">Lembrar de mim</label>
                        </div>
                    </section>

                    <section className="boxform2_pj">
                        <section className="only_formpj">
                            <div className="inputbox_formpj">
                                <label for="cnpj">CNPJ ou CPF</label>
                                <input className="inputbb_formpj" type="number" name="cpf" placeholder="Digite o CPF ou CNPJ" required />
                            </div>
                            <br />
                            <div className="inputbox_formpj">
                                <label for="endereço">Endereço</label>
                            </div>

                            <div className="box3_formpj">
                                <div className="littlebox_formpj">
                                    <label for="CEP">CEP:</label>
                                    <input className="inputbb2_formpj" type="text" name="CEP" placeholder="00.000-000" />
                                </div>


                                <div className="littlebox_formpj">
                                    <label for="Estado">Estado:</label>
                                    <input className="inputbb2_formpj" type="text" name="Estado" placeholder="UF" />
                                </div>
                            </div>
                            <br />
                            <div class="box4_formpj">
                                <div class="littlebox_formpj">
                                    <label for="Cidade">Cidade</label>
                                    <input className="inputbb2_formpj" type="text" name="Cidade" placeholder="Cidade" />
                                </div>

                                <div className="littlebox_formpj">
                                    <label for="Rua">Rua</label>
                                    <input className="inputbb2_formpj" type="text" name="Rua" placeholder="Rua" />
                                </div>
                            </div>
                        </section>
                        <br />
                        <div className="cadastrarbutton_formpj">
                            <button className="insidebutton_formpj">Cadastre-se</button>
                            <p>Ao criar o seu cadastro, você concorda com a nossa <a class="pp" href="#">política de privacidade</a>.</p>
                        </div>

                    </section>
                </form>
            </fieldset>
        </main>
    )
}

export default FormPje;