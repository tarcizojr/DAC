import React from "react";
import "../App.css";

import CardCar from "../screens/Cards/cardCar";
import 'bootswatch/dist/darkly/bootstrap.css';

import axios from 'axios';

export default class PrimeiraTela extends React.Component{
    state = {
        nome:"",
        cpf:"",
        sexo:""
       
    }
    mostrar = () =>{
        alert(`Carro do id:"${this.state.id} "foi atualizado \n nova marca:${this.state.marca} \n novo modelo: ${this.state.modelo} `)
    }

    upDate = () =>{
        axios.put(`http://localhost:8080/api/saller/${this.state.id}`,
        {
            nome: this.state.nome,
            cpf: this.state.cpf,
            sexoEnum: this.state.sexo
        }).then(response =>{
            alert("Vendedor Atualizado")
            console.log(response);

        }).catch(error =>{

            console.log(error.response);
        })
        
    }
    render(){
        return(
            <div className="App-header">
                <h1>Atualizar Vendedor</h1>

                <CardCar label="ID">
                    <input type="text" className="form-control" id="floatingInput-id" placeholder="Id" 
                    value={this.state.id} onChange={(e) =>{this.setState({id: e.target.value})}}></input>
                </CardCar>

                <CardCar label="Nome">
                    <input type="text" className="form-control" id="floatingInput-Nome" placeholder="Nome"  onChange={(e) =>{this.setState({nome: e.target.value})}}></input>
                </CardCar>

                <CardCar label="CPF">
                    <input type="number" className="form-control" id="floatingInput-cpf" placeholder="CPF"  onChange={(e) =>{this.setState({cpf: e.target.value})}}></input>
                </CardCar>
                
                <CardCar >
                    <select  class="form-select" id="exampleSelect1 sexo" name="sexo" onChange={(e) =>{this.setState({sexo: e.target.value})}}>
                        <option value="1">Homem</option>
                        <option value="2">Mulher</option>
                    </select>
                </CardCar>

                <button type="button" className="btn btn-primary" onClick={this.upDate}>Atualizar</button>


            </div>
        )
    }
}