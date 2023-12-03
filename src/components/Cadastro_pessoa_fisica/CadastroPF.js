import React, {useState} from "react";
import Axios from 'axios';

import './style.css'
import logo from "./img/logo.png";
import logooo from "./img/logooo.png"

import {Navigate, useNavigate} from 'react-router-dom'
import Api from "../../services/Api"

export default function CadastroPF() {

    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [endereco, setEndereco] = useState('');
    const [estado, setEstado] = useState('');
    const [cidade, setCidade] = useState('');
    const [nome, setNome] = useState('');
    const [dataNascimento, setDataNascimento] = useState('');
    const [sexo, setSexo] = useState('');
    const [etnia, setEtnia] = useState('');
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
            sexo,
            dataNascimento,
            etnia,
            nome,
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


    const checkCEP = async () => {
        cep.replace(/\D/g, ''); 
        if (cep.length === 8 ) {
          try {
            const response = await Axios.get(`https://viacep.com.br/ws/${cep}/json/`);
            if (response.data.erro) {
              alert('CEP inválido, tente novamente');
            } else {
              setEndereco(response.data.logradouro);
              setCidade(response.data.localidade);
              setEstado(response.data.uf);
            }
          } catch (error) {
            console.error(error);
          }
        } else {
          alert('CEP inválido, tente novamente, insira apenas números sem traços');
        }
     };

    return (




        <div>
            <form onSubmit={createProfissional} className="regal-cadastropf" >
                <section className="title-cadastro">
                    <img id="logo" src={logo} alt="logo"></img>
                    <h1 className="h1-cadastro" >CADASTRO</h1>
                </section>
                <section className="container-inputs">
                    <section className="box1">
                        <label className="put-for" for="">Nome completo</label>
                        <input
                        value={nome}
                        onChange={e => setNome(e.target.value)}
                        className="put-form" type="text" placeholder="Digite o seu nome" />


                        <label className="put-for" for="">Email</label>
                        <input
                         value={email}
                         onChange={e => setEmail(e.target.value)}
                        className="put-form" type="email" name="" id="" placeholder="Digite o seu email" />


                        <label className="put-for" for="">Data de nascimento</label>
                        <input 
                         value={dataNascimento}
                         onChange={e => setDataNascimento(e.target.value)}
                        className="put-form" type="date" name="" id="" />

                        <h3 className="h3-cadastro" >Endereço</h3>
                        <section className="endereco">
                             <section className="endereco-box1">
                                <div className="endereco-div1">

                                    <label for="">CEP</label>
                                    <input 
                                    value={cep}
                                    onChange={e => setCep(e.target.value)}
                                    className="put-form" type="number" placeholder="Apenas números , EX: 00000000" onBlur={checkCEP}/>
                                </div>

                                <div className="endereco-div2">
                                    <label for="">Estado</label>
                                    <input 
                                    value={estado}
                                    onChange={e => setEstado(e.target.value)}
                                    className="put-form" type="text" placeholder="PE" />
                                </div>

                            </section>
                            <section className="endereco-box2">
                                <div>

                                    <label for="">Cidade</label>
                                    <input 
                                     value={cidade}
                                     onChange={e => setCidade(e.target.value)}
                                    className="put-form" type="text" placeholder="Digite sua Cidade" />

                                 </div>
                                <div>
                                    <label for="">Endereco</label>
                                    <input 
                                     value={endereco}
                                     onChange={e => setEndereco(e.target.value)}
                                    className="put-form" type="text" placeholder="Digite seu endereco" />
                                </div>
                            </section>
                        </section>
                    </section>

                    <section className="box2">
                        <section className="box2-div1">
                            <label for="">Whatsapp</label>
                            <input 
                             value={telefone}
                             onChange={e => setTelefone(e.target.value)}
                            className="put-form" type="number" name="" id="" placeholder="ex:(00)0 00000-0000" />
                            <section className="opcao">
                                <div>
                                    <label for="">Sexo</label>
                                    <select
                                    onChange={e => setSexo(e.target.value)}
                                    name="" id="">
                                        <option value="">Vazio</option>
                                        <option value="Feminino">Feminino</option>
                                        <option value="Masculino">Masculino</option>
                                        <option value="outro">Outro</option>
                                    </select>
                                </div>
                                <div>
                                    <label for="">Etnia</label>
                                    <select
                                    onChange={e => setEtnia(e.target.value)}
                                    name="" id="">
                                        <option value="">Vazio</option>
                                        <option value="Branco">Branco</option>
                                        <option value="Preto">Preto</option>
                                        <option value="Pardo">Pardo</option>
                                        <option value="Indígena">Indígina</option>
                                        <option value="Amarelo">Amarelo</option>
                                        <option value="Outro">Outro</option>
                                    </select>
                                </div>
                            </section>

                            <label for="senha">Senha</label>
                            <input
                             value={senha}
                             onChange={e => setSenha(e.target.value)}
                             
                            className="put-form" type="password" name="senha" id="senha" placeholder="********" />

                        </section>
                        <div className="box2-div2">
                            <button className="button-cadastro">Cadastre-se</button>
                            <p className="politicalink"  onClick={AbrirPolitica} >Ao criar o seu cadastro, você concorda com a nossa <u  className="uu" ><span className="linkpolitica">política de privacidade</span></u></p>
                        </div>
                    </section>
                </section>
            </form>

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

        </div >
    )
}