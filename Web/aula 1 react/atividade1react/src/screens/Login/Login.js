import React from "react";
import "../../App.css";
import "./Login.css";

import 'bootswatch/dist/darkly/bootstrap.css';




export default class Login extends React.Component{

    state= {
        email:"",
        senha:""
    }

    login =() => {
        console.log("Email:", this.state.email);
        console.log("Senha:", this.state.senha);
    }

    entrar = () =>{
        this.props.history.push('../Home.js');
    }

    render(){
        return(
            <div className="App-header">
                <div className="card text-white bg-primary mb-3">
                    <div className="card-header">Loguin</div>
                    <div className="card-body">
                        <fieldset>
                            <div className="form-group">
                                <label className="form-label mt-4"></label>
                                <div className="form-floating mb-3">
                                    <input type="email" className="form-control" id="email" placeholder="name@example.com" onChange={(e) =>{this.setState({email: e.target.value})}}></input>
                                    <label htmlFor="email">Email address</label>
                                </div>
 
                                <div className="form-floating">
                                    <input type="password" className="form-control" id="floatingPassword" placeholder="Password" onChange={(e) =>{this.setState({senha: e.target.value})}}></input>
                                    <label htmlFor="floatingPassword">Password</label>
                                </div>
                            </div>
                        </fieldset>
                        
                    </div>

                    <div>
                        <button type="button" className="btn btn-success" onClick={this.entrar}>Entrar</button>

                        <button type="button" className="btn btn-info" >Cadastrar</button>

                    </div>

                </div>            


            </div>
        )
    }
}