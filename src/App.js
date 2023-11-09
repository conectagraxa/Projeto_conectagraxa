import './Pastas/Login/index.css'/* css da página de login*/
import './Pastas/principal/index.css' /* css da página principal*/
import './Pastas/principal/responsive/index.css' /*responsividade da página principal */
import './Pastas/perfil/index.css'
import './Pastas/perfil/Publicarcomunidade/index.css'
import './Pastas/perfil/Exemplo/index.css'

import './assets/style-principal.css'
import './../src/assets/style.css'
import Principal from './Pastas/cadastro/princ/Principal.js'
import Cadastro from './Pastas/cadastro/princ/Cadastro.js'
import EditarPerfil from './components/EditarPerfil.js'
import FormPF from './components/FormPF.js'

import Peerfil from './Pastas/perfil/index'
import Home from './Pastas/principal/index';
import Login from './Pastas/Login/index';
import Publicarcomunidade from './Pastas/perfil/Publicarcomunidade/index'
import Exemplo from './Pastas/perfil/Exemplo/index'

import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function App() {
  return (

    <Router>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/Login' element={<Login />} />

        <Route path='/Cadastro' element={<Cadastro />} />
        <Route path='/Principal' element={<Principal />} />
        <Route path='/EditarPerfil' element={<EditarPerfil />} />
        <Route path='/FormPF' element={<FormPF />} />


        <Route path='/Peerfil' element={<Peerfil />} />
        <Route path='/Publicarcomunidade' element={<Publicarcomunidade />} />
        <Route path='/Exemplo' element={<Exemplo />} />




      </Routes>
    </Router>
  );
}

export default App;
