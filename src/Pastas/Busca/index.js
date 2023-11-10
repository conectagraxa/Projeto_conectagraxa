import React from "react";
import './index.css'
import Navbar from "../navbar/index.js";

function Buscar() {
    return (
        <div>

            <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css'></link>

            <div className="busca" >
                <input type="text" id="buscar" className="buscarr" placeholder="Buscar"  ></input> <span className="lupab" ><i class="bi bi-search"></i></span>
            </div>
            <span className="nav" >

                <Navbar ></Navbar>
            </span>



        </div>

    )
};
export default Buscar