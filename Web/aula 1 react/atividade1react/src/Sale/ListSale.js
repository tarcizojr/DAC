import React from "react";
import "../App.css"

import CardCar from "../screens/Cards/cardCar";

import 'bootswatch/dist/darkly/bootstrap.css';

import axios from 'axios';

import UserTable from "../Sale/Table";

export default class PrimeiraTela extends React.Component{
    state = {
        id: '',
        saleValue: "",
        dateOfSale: "",
        idSaller:"",
        idCar:"",
        dados: []

    }
    delete = (saleID) =>{
        axios.delete(`http://localhost:8080/api/saler/${saleID}`
        ).then(response =>{
            this.find();
        }).catch(error => {
            console.log(error.response);
        });        
    } 

    edit = (saleID) => {
        this.props.history.push(`/atualizarvenda/${saleID}`);
    }

    find = () => {
        var params = '?';

        if(this.state.id !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.id}`;
        }

        if(this.state.saleValue !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.saleValue}`;
        }

        if(this.state.dateOfSale !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.dateOfSale}`;
        }

        if(this.state.idSaller !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.idSaller}`;
        }

        if(this.state.idCar !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.idCar}`;
        }



        axios.get(`http://localhost:8080/api/saler/${params}`)
        .then(response =>{

            const dados = response.data;
            this.setState({dados});
            console.log(dados);

        }).catch(error =>{

            console.log(error.response);
        })
    }

    render(){
        return(
            <div className="App-header">
                <div className="filtro">

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
                    
                    <button type="button" className="btn btn-primary" onClick={this.find}>Buscar</button>
                
                </div>

                <h1 className="titulo">Listar Vendas</h1>

                <div className="listar">
                    <UserTable dados={this.state.dados} 
                    delete = {this.delete}
                    edit = {this.edit}/>

                    
                </div>



            </div>
        )
    }
}