import React from "react";
import "../App.css";

import CardCar from "../screens/Cards/cardCar";
import 'bootswatch/dist/darkly/bootstrap.css';

import axios from 'axios';

export default class PrimeiraTela extends React.Component{

    state ={
        id:"",
        saleValue: "",
        dateOfSale: "",
        idSaller:"",
        idCar:""
    }
    

    mostrar = () =>{
            alert(`Venda Criada \n valor:${this.state.saleValue} \n  data: ${this.state.dateOfSale} n idVendedor:${this.state.idSaller} \n  idcarro: ${this.state.idCar} `)        
    }

    upDate = () =>{
        axios.put(`http://localhost:8080/api/saler/${this.state.id}`,
        {
            saleValue: this.state.saleValue,
            dateOfSale: this.state.dateOfSale,
            saller: this.state.idSaller,
            car: this.state.idCar
        }).then(response =>{
            alert("Venda Atualizada")
            console.log(response);

        }).catch(error =>{

            console.log(error.response);
        })
        
    }
    render(){
        return(
            <div className="App-header">
                <h1>Atualizar Venda</h1>

                <CardCar label="ID">
                    <input type="text" className="form-control" id="floatingInput-id" placeholder="Id" 
                    value={this.state.id} onChange={(e) =>{this.setState({id: e.target.value})}}></input>
                </CardCar>

                <CardCar label="Valor da Venda">
                    <input type="number" className="form-control" id="floatingInput-valor" placeholder="Valor"  onChange={(e) =>{this.setState({saleValue: e.target.value})}}></input>
                </CardCar>

                <CardCar label="Data da Venda">
                    <input type="date" className="form-control" id="floatingInput-data" 
                    onChange={(e) =>{this.setState({dateOfSale: e.target.value})}}></input>
                </CardCar>

                <CardCar label="Id do Vendedor">
                    <input type="number" className="form-control" id="floatingInput-idSaller" placeholder="Id Vendedor"  onChange={(e) =>{this.setState({idSaller: e.target.value})}}></input>
                </CardCar>

                <CardCar label="Id do Carro">
                    <input type="number" className="form-control" id="floatingInput-idCar" placeholder="Id Carro"  onChange={(e) =>{this.setState({idCar: e.target.value})}}></input>
                </CardCar>


                <button type="button" className="btn btn-primary" onClick={this.upDate}>Atualizar</button>


            </div>
        )
    }
}