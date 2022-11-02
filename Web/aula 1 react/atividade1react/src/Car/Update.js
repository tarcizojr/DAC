import React from "react";
import "../App.css"

export default class PrimeiraTela extends React.Component{
    state = {
        marca:"Fiat",
        modelo:"Uno",
        id:""
    }
    mostrar = () =>{
        alert(`Carro do id:"${this.state.id} "foi atualizado \n nova marca:${this.state.marca} \n novo modelo: ${this.state.modelo} `)
    }
    render(){
        return(
            <div className="App-header">
                <h1>Update Car</h1>
                
                <label>ID:</label>
                <input id="marca" type="text" value={this.state.id} onChange={(e) =>{this.setState({id: e.target.value})}}></input>
                <br/>

                <label>Marca:</label>
                <input id="marca" type="text" value={this.state.marca} onChange={(e) =>{this.setState({marca: e.target.value})}}></input>
                <br/>

                <label>Modelo:</label>
                <input id="modelo" type="text" value={this.state.modelo} onChange={(e) =>{this.setState({modelo: e.target.value})}}></input>
                <br/>

                <button onClick={this.mostrar}>Salvar</button>



            </div>
        )
    }
}