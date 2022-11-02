import React from "react";
import "../App.css"

export default class PrimeiraTela extends React.Component{


    render(){
        return(
            <div className="App-header">

                <label for="marca">Marca:</label>
                <input id="marca" type="text" placeholder="marca"></input>
                <br/>

                <label for="modelo">Modelo:</label>
                <input id="modelo" type="text" placeholder="modelo"></input>
                <br/>
                <button onClick={""}>Salvar</button>



            </div>
        )
    }
}