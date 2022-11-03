import React from "react";

import 'bootswatch/dist/darkly/bootstrap.css';
import './App.css'

import NavBar from "./Components/NavBar";
import AppRouter from "./main/AppRoutes";

export default class App extends React.Component{
    render(){
        return(
            <div>
                <NavBar></NavBar>
                <AppRouter></AppRouter>
            </div>
        )
    }
}