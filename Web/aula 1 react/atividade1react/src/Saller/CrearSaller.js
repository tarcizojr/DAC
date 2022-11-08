import React from "react";
import "../App.css"

import CardCar from "../screens/Cards/cardCar";

import 'bootswatch/dist/darkly/bootstrap.css';

import axios from 'axios';

export default class PrimeiraTela extends React.Component{

    state={
        nome:"",
        cpf:"",
        sexo:""
    }


    creat = async () =>{
        await axios.post('http://localhost:8080/api/saller',{
            nome: this.state.nome,
            cpf: this.state.cpf,
            sexoEnum: this.state.sexo
            
        }).then(response =>{
            alert("Vendedor Criado")            
            console.log(response);


        }).catch(error =>{

            console.log(error.response);
        })
    }
    render(){
        return(
            <div className="App-header">
                <h1 className="titulo">Salvar Vendedor</h1>               
                <CardCar label="Nome" className="form-floating mb-3">
                    <input type="text" className="form-control" id="floatingInput-Nome" placeholder="Nome"  onChange={(e) =>{this.setState({nome: e.target.value})}}></input>
                </CardCar>

                <CardCar label="CPF">
                    <input type="number" className="form-control" id="floatingInput-cpf" placeholder="CPF"  onChange={(e) =>{this.setState({cpf: e.target.value})}}></input>
                </CardCar>
                
                <CardCar >
                    <select  class="form-select" id="exampleSelect1 sexo" name="sexo" onChange={(e) =>{this.setState({sexo: e.target.value})}}>
                        <option selected="true" value="Homem">Homem</option>
                        <option value="Mulher">Mulher</option>
                    </select>
                </CardCar>              

                <button className="btn btn-primary" onClick={this.creat}>Salvar</button>



            </div>
        )
    }
}