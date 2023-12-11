// SobreMimPopup.js
import React, { useState } from "react";
import './index.css'

const SobreMimPopup = ({ onSave, onClose }) => {
  const [text, setText] = useState("");

  const handleSave = () => {
    onSave(text);
    onClose();
  };

  return (
    <section className="sobre-mim-popup">
      <textarea
        rows="5"
        cols="90"
        value={text}
        onChange={(e) => setText(e.target.value)}
      />
      <div>
        <button onClick={handleSave}>Salvar</button>
        <button onClick={onClose}>Cancelar</button>
      </div>
    </section>
  );
};

export default SobreMimPopup;
