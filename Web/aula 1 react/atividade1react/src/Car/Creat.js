import React from "react";
import "../App.css"

import CardCar from "../Car/screens/Cards/cardCar";

import NavBar from "../Components/NavBar";

import 'bootswatch/dist/darkly/bootstrap.css';

export default class CrearCar extends React.Component{
    state ={
        id: "",
        marca: "",
        modelo:""
    }

    mostrar = () =>{
        alert(`Carro do id:"${this.state.id} "foi atualizado \n nova marca:${this.state.marca} \n novo modelo: ${this.state.modelo} `)
    }

    render(){
        return(
            <div>
                <NavBar></NavBar>
                <div className="App-header">                
                
                <h1 className="titulo">Salvar Carro</h1>
               
                <CardCar label1="Marca" label2="Modelo"></CardCar>

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