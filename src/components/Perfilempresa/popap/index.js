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
    <div className="sobre-mim-popup">
      <textarea
        rows="5"
        cols="90"
        value={text}
        onChange={(e) => setText(e.target.value)}
      />
      <button onClick={handleSave}>Salvar</button>
      <button onClick={onClose}>Cancelar</button>
    </div>
  );
};

export default SobreMimPopup;
