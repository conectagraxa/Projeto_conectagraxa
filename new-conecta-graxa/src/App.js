import React from "react";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Cadastro from "./pages/Cadastro";
import PrincipalPF from "./pages/PrincipalPF";
import PrincipalPJ from "./pages/PrincipalPJ";
import CadastroPF from './components/Cadastro_pessoa_fisica/CadastroPF.js'
import Home from './pages/principal/index.js'
import LoginForm from './pages/Login/index.js'

function App() {
  return (
    // <PrincipalPJ/>
    // <PrincipalPF/>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/principalPF/*" element={<PrincipalPF />} />
        <Route path="/principalPJ/*" element={<PrincipalPJ />} />
        <Route path='/CadastroPF' element={<CadastroPF />} />
        <Route path='/LoginForm' element={<LoginForm />} />

      </Routes>
    </BrowserRouter>
  );
}

export default App;