import React from "react";
import "../App.css";

import CardCar from "../screens/Cards/cardCar";
import 'bootswatch/dist/darkly/bootstrap.css';

import axios from 'axios';

export default class PrimeiraTela extends React.Component{
    state = {
        id:"",
        marca:"",
        modelo:""
       
    }
    mostrar = () =>{
        alert(`Carro do id:"${this.state.id} "foi atualizado \n nova marca:${this.state.marca} \n novo modelo: ${this.state.modelo} `)
    }

    upDate = () =>{
        axios.put(`http://localhost:8080/api/car/${this.state.id}`,
        {
            brand: this.state.marca,
            model: this.state.modelo
        }).then(response =>{
            alert("Carro Atualizado")
            console.log(response);

        }).catch(error =>{

            console.log(error.response);
        })
        
    }
    render(){
        return(
            <div className="App-header">
                <h1>Atualizar Caros</h1>

                <CardCar label="ID">
                    <input type="text" className="form-control" id="floatingInput-id" placeholder="Id" 
                    value={this.state.id} onChange={(e) =>{this.setState({id: e.target.value})}}></input>
                </CardCar>

                <CardCar label="Marca">
                    <input type="text" className="form-control" id="floatingInput-marca" placeholder="Marca" 
                    value={this.state.marca} onChange={(e) =>{this.setState({marca: e.target.value})}}></input>
                </CardCar>

                <CardCar label="Modelo">
                    <input type="text" className="form-control" id="floatingInput-modelo" placeholder="Modelo" 
                    value={this.state.modelo} onChange={(e) =>{this.setState({modelo: e.target.value})}}></input>
                </CardCar>

{/* 
                <div className="form-floating mb-3">
                    <input type="number" className="form-control" id="floatingInput-id" placeholder="id" value={this.state.id} onChange={(e) =>{this.setState({id: e.target.value})}}></input>
                    <label for="floatingInput-id">ID</label>
                </div>
                 */}


                {/* <div className="form-floating mb-3">
                    <input type="text" className="form-control" id="floatingInput-marca" placeholder="marca" value={this.state.marca} onChange={(e) =>{this.setState({marca: e.target.value})}}></input>
                    <label htmlFor="floatingInput-marca">Marca</label>
                </div>

                <div className="form-floating mb-3">
                    <input type="text" className="form-control" id="floatingInput-modelo" placeholder="modelo" value={this.state.modelo} onChange={(e) =>{this.setState({modelo: e.target.value})}}></input>
                    <label htmlFor="floatingInput-modelo">Modelo</label>
                </div> */}


                <button type="button" className="btn btn-primary" onClick={this.upDate}>Atualizar</button>


            </div>
        )
    }
}