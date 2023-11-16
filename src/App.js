import './components/Busca/index.css'
import './components/navbar/style.css'
import './Pastas/Login/index.css'/* css da página de login*/
import './Pastas/principal/index.css' /* css da página principal*/
import './Pastas/principal/responsive/index.css' /*responsividade da página principal */
import './Pastas/Home_comunidade/index.css'// css do Home comunidade//
import './Pastas/Home_comunidade/Publicarcomunidade/index.css'// css do componente para publicar comunidade//
import './components/Cadastro_pessoa_fisica/style.css' //*css da página de cadastro de pessoa físicac*//
import './components/Conexoes/index.css'

import './Pastas/Home_comunidade/Exemplo/index.css'//isso é apenas um arquivo para exemplos ou testes //
import Exemplo from './Pastas/Home_comunidade/Exemplo/index'//////////////////////////////////////////

import Conexoes from './components/Conexoes/index.js'
import Buscar from './components/Busca/index.js'
import CadastroPF from './components/Cadastro_pessoa_fisica/CadastroPF.js'
import Navbar from './components/navbar/index.js'
import Home_comunidade from './Pastas/Home_comunidade/index'
import Home from './Pastas/principal/index';
import Login from './Pastas/Login/index';
import Publicarcomunidade from './Pastas/Home_comunidade/Publicarcomunidade/index'

import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function App() {
  return (

    <Router>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/Login' element={<Login />} />
        <Route path='/CadastroPF' element={<CadastroPF />} />
        <Route path='/Home_comunidade' element={<Home_comunidade />} />
        <Route path='/Publicarcomunidade' element={<Publicarcomunidade />} />
        <Route path='/Exemplo' element={<Exemplo />} />
        <Route path='/Navbar' element={<Navbar />} />
        <Route path='/Buscar' element={<Buscar />} />
        <Route path='/Conexoes' element={<Conexoes />} />

      </Routes>
    </Router>
  );
}

export default App;
