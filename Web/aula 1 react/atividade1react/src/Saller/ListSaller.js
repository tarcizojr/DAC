import React from "react";
import "../App.css"

import CardCar from "../screens/Cards/cardCar";

import 'bootswatch/dist/darkly/bootstrap.css';

import axios from 'axios';

import UserTable from "./Table";

export default class PrimeiraTela extends React.Component{
    state = {
        id: '',
		nome: '',
		cpf: '',
		sexo: '',
        dados: []

    }
    delete = (vendedorId) =>{
        axios.delete(`http://localhost:8080/api/saller/${vendedorId}`
        ).then(response =>{
            this.find();
        }).catch(error => {
            console.log(error.response);
        });        
    } 

    edit = (vendedorId) => {
        this.props.history.push(`/atualizarvendedor/${vendedorId}`);
    }

    find = () => {
        var params = '?';

        if(this.state.id !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.id}`;
        }

        if(this.state.nome !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.nome}`;
        }

        if(this.state.cpf !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.cpf}`;
        }

        if(this.state.sexo !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.sexo}`;
        }



        axios.get(`http://localhost:8080/api/saller/${params}`)
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

                    <CardCar label="Nome">
                        <input type="text" className="form-control" id="floatingInput-nome" placeholder="Nome" 
                        value={this.state.nome} onChange={(e) =>{this.setState({nome: e.target.value})}}></input>
                    </CardCar>

                    <CardCar label="CPF">
                        <input type="text" className="form-control" id="floatingInput-cpf" placeholder="CPF" 
                        value={this.state.cpf} onChange={(e) =>{this.setState({cpf: e.target.value})}}></input>
                    </CardCar>
                    
                    <button type="button" className="btn btn-primary" onClick={this.find}>Buscar</button>
                
                </div>

                <h1 className="titulo">Listar Vendedore</h1>

                <div  className="listar">
                    <UserTable dados={this.state.dados} 
                    delete = {this.delete}
                    edit = {this.edit}/>

                    
                </div>                

            </div>
        )
    }
}