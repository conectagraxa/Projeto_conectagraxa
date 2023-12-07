import React from "react";
import './index.css'
import './responsivobusca/index.css'

function BuscarUser() {
    return (
        <div>

            <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css'></link>

            <div className="buscaUser" >
                <input type="text" id="buscar" className="buscarUser" placeholder="Buscar"></input> <span className="lupabUser" ><i className="bi bi-search"></i></span>
            </div>

            <span className="navUser" >

            </span>



        </div>

    )
};
export default BuscarUser;