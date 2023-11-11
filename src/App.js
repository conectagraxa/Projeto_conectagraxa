import'./Pastas/Busca/index.css'
import './Pastas/navbar/style.css'
import './Pastas/Login/index.css'/* css da página de login*/
import './Pastas/principal/index.css' /* css da página principal*/
import './Pastas/principal/responsive/index.css' /*responsividade da página principal */
import './Pastas/Home_comunidade/index.css'

import './Pastas/Home_comunidade/Publicarcomunidade/index.css'
import './Pastas/Home_comunidade/Exemplo/index.css'

import './assets/style-principal.css'
import './../src/assets/style.css'

import Buscar from './Pastas/Busca/index.js'
import Principal from './Pastas/cadastro/princ/Principal.js'
import Cadastro from './Pastas/cadastro/princ/Cadastro.js'
import EditarPerfil from './components/EditarPerfil.js'
import FormPF from './components/FormPF.js'
import Navbar from './Pastas/navbar/index.js'

import Home_comunidade from './Pastas/Home_comunidade/index'
import Home from './Pastas/principal/index';
import Login from './Pastas/Login/index';
import Publicarcomunidade from './Pastas/Home_comunidade/Publicarcomunidade/index'
import Exemplo from './Pastas/Home_comunidade/Exemplo/index'

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

        <Route path='/Home_comunidade' element={<Home_comunidade />} />
        <Route path='/Publicarcomunidade' element={<Publicarcomunidade />} />
        <Route path='/Exemplo' element={<Exemplo />} />
        <Route path='/Navbar' element={<Navbar />} />
        <Route path='/Buscar' element={<Buscar/>} />

      </Routes>
    </Router>
  );
}

export default App;
