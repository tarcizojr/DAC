import React from "react";
import NavBar from "./Components/NavBar";
import 'bootswatch/dist/darkly/bootstrap.css';
import './App.css'


export default class App extends React.Component{
    render(){
        return(
            <div>
                <NavBar/>                
            </div>
        )
    }
}