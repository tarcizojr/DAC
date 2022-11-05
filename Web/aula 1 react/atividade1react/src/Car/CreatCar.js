import React from "react";
import "../App.css"

import CardCar from "../Car/screens/Cards/cardCar";

import 'bootswatch/dist/darkly/bootstrap.css';

export default class CreatCar extends React.Component{
    state ={
        id: "",
        marca: "",
        modelo:""
    }

    mostrar = () =>{
        alert(`Carro Criado \n marca:${this.state.marca} \n  modelo: ${this.state.modelo} `)
    }

    render(){
        return(
            <div>
               
                <div className="App-header">                
                
                <h1 className="titulo">Salvar Carro</h1>
               
                <CardCar label="Marca">
                    <input type="text" className="form-control" id="floatingInput-marca" placeholder="marca"  onChange={(e) =>{this.setState({marca: e.target.value})}}></input>
                </CardCar>

                <CardCar label="Modelo">
                    <input type="text" className="form-control" id="floatingInput-modelo" placeholder="modelo" 

                    onChange={(e) =>{this.setState({modelo: e.target.value})}}></input>
                </CardCar>

                {/* <div className="form-floating mb-3">
                    <input type="text" className="form-control" id="floatingInput-marca" placeholder="marca"></input>
                    <label for="floatingInput-marca">Marca</label>
                </div>

                <div className="form-floating mb-3">
                    <input type="text" className="form-control" id="floatingInput-modelo" placeholder="modelo"></input>
                    <label for="floatingInput-modelo">Modelo</label>
                </div> */}
                

                <button type="button" className="btn btn-primary" onClick={this.mostrar}>Salvar</button>


                </div>
            </div>
        )
    }
}