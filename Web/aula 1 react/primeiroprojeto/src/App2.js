import React from "react";
import logo from './logo.svg';
import './App.css';

export default class App extends React.Component{
    state = {
        text: "Turma de DAC",
        period: "5°"
    }
    render(){
        return (
            <div className="App">
              <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <p>
                  DACC <code>src/App.js</code> and save to reload.
                </p>
                <p>
                    {this.state.text}
                </p>
                <label>
                    {this.state.period}
                </label>
                <a
                  className="App-link"
                  href="https://reactjs.org"
                  target="_blank"
                  rel="noopener noreferrer"
                >
                  Learn React
                </a>
              </header>
            </div>
        );
    }
}
