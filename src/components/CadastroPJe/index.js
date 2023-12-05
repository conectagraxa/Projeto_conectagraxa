
import React, {useState} from "react";

import "./index.css"
import logo from "./imagens-formpje/logo.jpg"
import logooo from'./imagens-formpje/logooo.png'

function FormPje() {

    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [endereco, setEndereco] = useState('');
    const [estado, setEstado] = useState('');
    const [cidade, setCidade] = useState('');
    const [nomeFantasia, setNomeFantasia] = useState('');
  
    const [cpfCnpj, setCpfCnpj] = useState('');
    const [telefone, setTelefone] = useState('');
    const [cep, setCep] = useState('');
    const [id, setId] = useState('');

    const navigate =  useNavigate();
    

    async function createProfissional(e){
        e.preventDefault();
    
        const data = {
            email,
            senha,
            telefone,
            cep,
            cnpjCpf,
            nomeFantasia,
            endereco,
            estado,
            cidade,
            
        };
        try{
            console.log('Senha atualizada:', senha);

            const  response = await Api.post('profissional/create',data);
            console.log('Senha atualizada:', senha);

            localStorage.getItem('email');
            localStorage.setItem('id',id);
    
            navigate('/Login');
        }catch(err){
            alert('Cadastro não realizado');
        }
    }

    const [modalDisplay, setModalDisplay] = useState('none')

    function AbrirPolitica() {
        setModalDisplay('block');
    }

    function FecharPolitica() {
        setModalDisplay('none');
    }
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
                            <p className="politicalink"  onClick={AbrirPolitica} >Ao criar o seu cadastro, você concorda com a nossa <u  className="uu" ><span className="linkpolitica">política de privacidade</span></u></p>
                        </div>

                    </section>
                </form>
            </fieldset>




            <div className="Modal-janela" style={{ display: modalDisplay }} >

                <div className="esfera1-politica"></div>
                <div className="esfera2-politica"></div>
                <div className="esfera3-politica"></div>
                <div className="esfera4-politica"></div>
                <div className="esfera5-politica"></div>

                <div className="Modal-interno-politica">



                    <h4 className="nome-politica">
                        <img className="imagem-logo-politica" src={logooo} alt="imagem-da-logo"></img>

                        <h4 className="nome-int">  Política de Privacidade do Conecta Graxa</h4>

                        <h4 className="nome-int">  Última atualização: 11/12/2023</h4>

                        <h4 className="nome-int">   Bem-vindo ao Conecta Graxa. A sua privacidade é importante para nós.
                            Esta Política de Privacidade explica como coletamos, usamos, divulgamos e protegemos as suas informações
                            pessoais quando você utiliza a plataforma Conecta Graxa ("nós" ou "nosso").</h4>

                        <h4 className="nome-int"> 1. Informações Coletadas</h4>

                        <h4 className="nome-int">  Ao utilizar o Conecta Graxa, podemos coletar as seguintes informações:</h4>

                        <h4 className="nome-int">  1.1 Informações Pessoais:</h4>
                        <h4 className="nome-int">   - Nome</h4>
                        <h4 className="nome-int">    - Endereço de e-mail</h4>
                        <h4 className="nome-int">    - Número de telefone</h4>

                        <h4 className="nome-int">  1.2 Informações de Uso:</h4>
                        <h4 className="nome-int">   - Dados de acesso e atividade na plataforma</h4>
                        <h4 className="nome-int">   - Informações sobre o dispositivo utilizado</h4>
                        <h4 className="nome-int">   - Dados de localização (se permitido)</h4>

                        <h4 className="nome-int"> 2. Uso das Informações</h4>

                        <h4 className="nome-int"></h4>  Utilizamos as informações coletadas para:</h4>

                    <h4 className="nome-int"> 2.1 Prestação de Serviços:
                        - Personalizar sua experiência na plataforma
                        - Processar transações e fornecer os serviços solicitados</h4>

                    <h4 className="nome-int"> 2.2 Comunicação
                        - Enviar notificações importantes relacionadas à sua conta
                        - Enviar informações sobre atualizações e novos recursos</h4>

                    <h4 className="nome-int"> 2.3 Melhoria da Plataforma:
                        - Analisar o uso da plataforma para melhorar nossos serviços
                        - Realizar pesquisas e análises para aprimorar a experiência do usuário</h4>

                    <h4 className="nome-int"> 3. Compartilhamento de Informações</h4>

                    <h4 className="nome-int"> Não compartilhamos suas informações pessoais com terceiros, exceto nas seguintes circunstâncias:</h4>

                    <h4 className="nome-int"> 3.1 Parceiros de Negócios:</h4>
                    <h4 className="nome-int">  - Compartilhamos informações com parceiros de negócios para fornecer serviços específicos a você</h4>

                    <h4 className="nome-int"> 3.2 Consentimento:</h4>
                    <h4 className="nome-int"> - Compartilhamos informações com sua autorização explícita</h4>

                    <h4 className="nome-int">   3.3 Cumprimento da Lei:</h4>
                    <h4 className="nome-int">  - Cumprimos solicitações legais e protegemos nossos direitos legais</h4>

                    <h4 className="nome-int">  4. Segurança das Informações</h4>

                    <h4 className="nome-int">  Implementamos medidas de segurança para proteger suas informações contra acesso não autorizado, alteração, divulgação ou destruição.</h4>

                    <h4 className="nome-int"> 5. Seus Direitos</h4>

                    <h4 className="nome-int">Você tem o direito de acessar, corrigir ou excluir suas informações pessoais. Entre em contato conosco para exercer esses direitos.</h4>

                    <h4 className="nome-int">  6. Alterações nesta Política</h4>

                    <h4 className="nome-int"> Reservamo-nos o direito de fazer alterações nesta Política de Privacidade. A versão mais recente estará sempre disponível na plataforma.</h4>

                    <h4 className="nome-int">Ao utilizar o Conecta Graxa, você concorda com os termos desta Política de Privacidade.</h4>

                    <h4 className="nome-int"> Para dúvidas ou preocupações sobre esta política, entre em contato conosco em [contato@conectagraxa.com].</h4><br></br>

                    <h4 className="nome-int"> Atenciosamente,</h4><br></br>

                    <h4 className="nome-int"> Equipe Conecta Graxa</h4>

                    <a className="a-voltar" href="" ><button onclick={FecharPolitica} className="button-politica">Voltar</button></a>
                </div>

            </div>
        </main>
    )
}

export default FormPje;