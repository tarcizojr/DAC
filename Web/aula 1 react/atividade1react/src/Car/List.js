import React from "react";
import "../App.css"

import 'bootswatch/dist/darkly/bootstrap.css';

export default class PrimeiraTela extends React.Component{
    state = {
        veiculo1:{
            id:"1",
            marca:"Fiat",
            modelo:"Uno"            
        },      
        veiculo2:{
            id:"2",
            marca:"Ford",
            modelo:"Del Rey"            
        } 


    }

    render(){
        return(
            <div className="App-header">
                <h1 className="titulo">Listar Caros</h1>

                <table class="table table-veiculos table-hover">
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
                </table>
                
            </div>
        )
    }
}