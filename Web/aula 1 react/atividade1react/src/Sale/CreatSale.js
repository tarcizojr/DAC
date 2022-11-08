import React from "react";
import "../App.css";

import CardCar from "../screens/Cards/cardCar";

import 'bootswatch/dist/darkly/bootstrap.css';

import axios from 'axios';

export default class PrimeiraTela extends React.Component{

    
        state ={
            saleValue: "",
            dateOfSale: "",
            idSaller:"",
            idCar:""
        }

        mostrar = () =>{
            alert(`Venda Criada \n valor:${this.state.saleValue} \n  data: ${this.state.dateOfSale} \n idVendedor:${this.state.idSaller} \n  idcarro: ${this.state.idCar} `)        
        }

        creat = async () =>{
            await axios.post('http://localhost:8080/api/saler',{
                saleValue: this.state.saleValue,
                dateOfSale: this.state.dateOfSale,
                saller: this.state.idSaller,
                car: this.state.idCar
            }).then(response =>{
                alert("Venda Criada");  
                
                console.log(response);
    
    
            }).catch(error =>{
    
                console.log(error.response);
            })
        }

    render(){
        return(
            <div>
               
                <div className="App-header">                
                
                <h1 className="titulo">Salvar Venda</h1>
               
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


                <button type="button" className="btn btn-primary" onClick={this.creat}>Salvar</button>


                </div>
            </div>
        )
    }
}