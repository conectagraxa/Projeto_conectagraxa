import React from "react";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import PrincipalPF from "./pages/PrincipalPF";
import PrincipalPJ from "./pages/PrincipalPJ";
import CadastroPF from './components/Cadastro_pessoa_fisica/CadastroPF.js'
import Home from './pages/principal/index.js'
import LoginForm from './pages/Login/index.js'
import LoginFormEmpresa from './pages/loginempresa/index.js';
import FormPje from "./components/CadastroPJe/CadastroPJ.js";
import CadastroPJ from "./components/CadastroPJe/CadastroPJ.js";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path="/principalPF/*" element={<PrincipalPF />} />
        <Route path="/principalPJ/*" element={<PrincipalPJ />} />
        <Route path='/CadastroPF' element={<CadastroPF />} />
        <Route path='/LoginForm' element={<LoginForm />} />
        <Route path='/LoginFormEmpresa' element={<LoginFormEmpresa />} />
        <Route path='/FormPje' element={<FormPje />} />
        <Route path='/CadastroPJ' element={<CadastroPJ />} />


      </Routes>
    </BrowserRouter>
  );
}

export default App;