import React from "react";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Cadastro from "./pages/Cadastro";
import PrincipalPF from "./pages/PrincipalPF";
import PrincipalPJ from "./pages/PrincipalPJ";

function App() {
  return (
    // <PrincipalPJ/>
    // <PrincipalPF/>
    <BrowserRouter>
      <Routes>
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/principalPF/*" element={<PrincipalPF />} />
        <Route path="/principalPJ/*" element={<PrincipalPJ />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;