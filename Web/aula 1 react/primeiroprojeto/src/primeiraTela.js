import React from "react";
import './Somar.css'

export default class PrimeiraTela extends React.Component{
    state = {
        num1: 0,
        num2: 0,
        res: 0
    }

    sum = () => {
        var res = parseInt(this.state.num1) + parseInt(this.state.num2);

        this.setState({res});
    }

    render(){
        return(
            <div className="App">
                <label>Numero 1:</label>
                <input type="text" placeholder="Numero 1" onChange={(e) => {this.setState({num1: e.target.value})}}></input>

                <br/>

                <label>Numero 2:</label>
                <input type="text" placeholder="Numero 2" onChange={(e) => {this.setState({num2: e.target.value})}}></input>

                <br/>

                <button onClick={this.sum}>Somar</button>

                <br/>

                <label>O resultado é: {this.state.res}</label>

            </div>
        )
    }
}