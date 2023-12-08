import './components/Busca/index.css'
import './components/navbar/style.css'
import './Pastas/Login/index.css'/* css da página de login*/
import './Pastas/principal/index.css' /* css da página principal*/
import './Pastas/principal/responsive/index.css' /*responsividade da página principal */
import './Pastas/Home_comunidade/index.css'// css do Home comunidade//
import './Pastas/Home_comunidade/Publicarcomunidade/index.css'// css do componente para publicar comunidade//
import './components/Cadastro_pessoa_fisica/style.css' //*css da página de cadastro de pessoa físicac*//
import './components/Conexoes/index.css'
import './components/navbarempresa/styleempresa.css'
import './components/CadastroPJe/index.css'
import './components/Perfilempresa/index.css'
import './components/menu-mobile-profissional/index.css'


import Api from './services/Api.js'//////////////////////////////////////////

import './Pastas/Home_comunidade/Exemplo/index.css'//isso é apenas um arquivo para exemplos ou testes //
import Exemplo from './Pastas/Home_comunidade/Exemplo/index'//////////////////////////////////////////
import PerfilEmpresas from './components/Perfilempresa/index.js'
import PerfilUsuario from './components/PerfilUsuario/index.js'
import FormPj from './components/CadastroPJe/index.js'
import Navbarempresa from './components/navbarempresa/index.js'
import Conexoes from './components/Conexoes/index.js'
import Buscar from './components/Busca/index.js'
import CadastroPF from './components/Cadastro_pessoa_fisica/CadastroPF.js'
import Navbar from './components/navbar/index.js'
import Home_comunidade from './Pastas/Home_comunidade/index'
import Home from './Pastas/principal/index';
import Login from './Pastas/Login/index';
import Publicarcomunidade from './Pastas/Home_comunidade/Publicarcomunidade/index'
import MenuProfissional from './components/menu-mobile-profissional/index.js'
import EditarPerfil from './components/EditarPerfilUsuario/EditarPerfil.js'
import VagasPubli from './components/Vagaspubli/VagasPubli.js'
import BuscarProf from './components/BuscarProfissional/BuscarProf.js'
import SobreMimPopup from './components/Perfilempresa/popap/index.js'

import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function App() {
  return (

    <Router>
      <Routes>

        <Route path='/' element={<Home />} />
        <Route path='/Login' element={<Login />} />
        <Route path='/CadastroPF' element={<CadastroPF />} />
        <Route path='/FormPj' element={<FormPj />} />
        <Route path='/Home_comunidade' element={<Home_comunidade />} />
        <Route path='/Publicarcomunidade' element={<Publicarcomunidade />} />
        <Route path='/Exemplo' element={<Exemplo />} />
        <Route path='/Navbar' element={<Navbar />} />
        <Route path='/Buscar' element={<Buscar />} />
        <Route path='/Conexoes' element={<Conexoes />} />
        <Route path='/Navbarempresa' element={<Navbarempresa />} />
        <Route path='/PerfilEmpresas' element={<PerfilEmpresas />} />
        <Route path='/PerfilUsuario' element={<PerfilUsuario />} />
        <Route path='/MenuProfissional' element={<MenuProfissional />} />
        <Route path='/EditarPerfil' element={<EditarPerfil />} />
        <Route path='/VagasPubli' element={<VagasPubli />} />
        <Route path='/BuscarProf' element={<BuscarProf />} />
        <Route patch='/SobreMimPopup' element={<SobreMimPopup />} />

      </Routes>
    </Router>
  );
}

export default App;
