import React from "react";
import "../App.css"

import CardCar from "../screens/Cards/cardCar";

import 'bootswatch/dist/darkly/bootstrap.css';

import axios from 'axios';

import UserTable from "../Components/UserTable";

export default class PrimeiraTela extends React.Component{
    state = {
        "id": '',
		"brand": '',
		"model": '',
		"sales": '',
        "dados": []

    }
    delete = (carId) =>{
        axios.delete(`http://localhost:8080/api/car/${carId}`
        ).then(response =>{
            this.find();
        }).catch(error => {
            console.log(error.response);
        });        
    } 

    edit = (carId) => {
        this.props.history.push('/atualizarcarro');
    }

    find = () => {
        var params = '?';

        if(this.state.id !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.id}`;
        }

        if(this.state.brand !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.brand}`;
        }

        if(this.state.model !== ''){
            if(params !== '?'){
                params = `${params}&`;
            }
            params = `${params}id=${this.state.model}`;
        }



        axios.get(`http://localhost:8080/api/car/${params}`)
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
                        <input type="text" className="form-control" id="floatingInput-id" placeholder="id" 
                        value={this.state.id} onChange={(e) =>{this.setState({id: e.target.value})}}></input>
                    </CardCar>

                    <CardCar label="Marca">
                        <input type="text" className="form-control" id="floatingInput-marca" placeholder="marca" 
                        value={this.state.marca} onChange={(e) =>{this.setState({marca: e.target.value})}}></input>
                    </CardCar>

                    <CardCar label="Modelo">
                        <input type="text" className="form-control" id="floatingInput-modelo" placeholder="modelo" 
                        value={this.state.modelo} onChange={(e) =>{this.setState({modelo: e.target.value})}}></input>
                    </CardCar>
                    
                    <button type="button" className="btn btn-primary" onClick={this.find}>Buscar</button>
                
                </div>

                <h1 className="titulo">Listar Caros</h1>

                <div>
                    <UserTable dados={this.state.dados} 
                    delete = {this.delete}
                    edit = {this.edit}/>

                    
                </div>


                {/* <table class="table table-veiculos table-hover">
                    <thead>
                        <tr>
                        <th scope="col">Veiculo</th>
                        <th scope="col">Id</th>
                        <th scope="col">Marca</th>
                        <th scope="col">Modelo</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr class="table-dark">
                            <th scope="row">Veiculo1</th>
                            <td>{this.state.veiculo1.id}</td>
                            <td>{this.state.veiculo1.marca}</td>
                            <td>{this.state.veiculo1.modelo}</td>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">Veiculo2</th>
                            <td>{this.state.veiculo2.id}</td>
                            <td>{this.state.veiculo2.marca}</td>
                            <td>{this.state.veiculo2.modelo}</td>
                        </tr>
                    </tbody>
                </table> */}

            </div>
        )
    }
}