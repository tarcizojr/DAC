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
        await axios.delete(`http://localhost:8080/api/car/${this.state.id}`,{
           
        }).then(response =>{

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
               
                <CardCar label="ID">
                    <input type="text" className="form-control" id="floatingInput-id" placeholder="id" 
                    value={this.state.id} onChange={(e) =>{this.setState({id: e.target.value})}}></input>
                </CardCar>
                              

                <button type="button" className="btn btn-primary" onClick={this.delete}>Salvar</button>


                </div>
            </div>
        )
    }
}

