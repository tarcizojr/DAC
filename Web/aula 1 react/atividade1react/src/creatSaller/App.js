import React from "react";
import "../App.css"

export default class PrimeiraTela extends React.Component{


    render(){
        return(
            <div className="App-header">
                <label>Nome:
                    <input id="nome" type="text" placeholder="Nome"></input>
                </label>
                
                <br/>

                <label for="cpf" >CPF:</label>
                <input autoComplete="off" id="cpf" type="text" placeholder="CPF"></input>
                <br/>

                <label for="sexo">Sexo:</label>
                <select id="sexo" name="sexo">
                    <option value="bota">Homem</option>
                    <option value="fla">Mulher</option>
                </select>
                <br/>

                <button onClick={""}>Salvar</button>



            </div>
        )
    }
}