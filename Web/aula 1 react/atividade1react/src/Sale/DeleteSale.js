import React from "react";
import "../App.css";

import CardCar from "../screens/Cards/cardCar";

import 'bootswatch/dist/darkly/bootstrap.css';

import axios from 'axios';

export default class Delete extends React.Component{
    state ={
        id:""      
    }

    delete = async () =>{
        await axios.delete(`http://localhost:8080/api/saler/${this.state.id}`,{
           
        }).then(response =>{
            alert("Venda Deletada");
            console.log(response);

        }).catch(error =>{

            console.log(error.response);
        })
    }

    render(){
        return(
            <div>
               
                <div className="App-header">                
                
                <h1 className="titulo">Deletar Carro</h1>
               
                <CardCar label="ID">
                    <input type="text" className="form-control" id="floatingInput-id" placeholder="Id" 
                    value={this.state.id} onChange={(e) =>{this.setState({id: e.target.value})}}></input>
                </CardCar>
                              

                <button type="button" className="btn btn-primary" onClick={this.delete}>Deletar</button>


                </div>
            </div>
        )
    }
}

