import React from "react";
import "../App.css"

export default class PrimeiraTela extends React.Component{


    render(){
        return(
            <div className="App-header ">
                <label for="dataVenda" >Data da Venda:</label>
                <input id="dataVenda" type="date"></input>
                <br/>

                <label>ID Vendedor:</label>
                <input id="idVendedor" type="number" placeholder="ID Vendedor"></input>
                <br/>

                <label for="idCarrro" >ID Carro:</label>
                <input id="idCarrro" type="number" placeholder="ID Carro"></input>
                <br/>

                <button onClick={""}>Salvar</button>



            </div>
        )
    }
}