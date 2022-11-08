import React from "react";
import "../App.css";

import CardCar from "../screens/Cards/cardCar";

import 'bootswatch/dist/darkly/bootstrap.css';

import axios from 'axios';


export default class CreatCar extends React.Component{
    state ={
        id: "",
        marca: "",
        modelo:""
    }

    mostrar = () =>{
        alert(`Carro Criado \n marca:${this.state.marca} \n  modelo: ${this.state.modelo} `)
    }

    creat = async () =>{
        await axios.post('http://localhost:8080/api/car',{
            brand: this.state.marca,
            model: this.state.modelo
        }).then(response =>{
            alert("Carro Criado");           
            console.log(response);


        }).catch(error =>{

            console.log(error.response);
        })
    }

    render(){
        return(
            <div>
               
                <div className="App-header">                
                
                <h1 className="titulo">Salvar Carro</h1>
               
                <CardCar label="Marca">
                    <input type="text" className="form-control" id="floatingInput-marca" placeholder="Marca"  onChange={(e) =>{this.setState({marca: e.target.value})}}></input>
                </CardCar>

                <CardCar label="Modelo">
                    <input type="text" className="form-control" id="floatingInput-modelo" placeholder="Modelo"
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
                

                <button type="button" className="btn btn-primary" onClick={this.creat}>Salvar</button>


                </div>
            </div>
        )
    }
}