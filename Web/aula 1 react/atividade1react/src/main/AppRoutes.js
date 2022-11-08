import React from "react";

import {Route, BrowserRouter} from "react-router-dom";

import CreatCar from "../Car/CreatCar";
import UpdateCar from "../Car/UpdateCar";
import ListCar from "../Car/ListCar";
import Delete from "../Car/DeleteCar";

//==========
import CreatSaller from "../Saller/CrearSaller";
import DeletSaller from "../Saller/DeleteSaller"
import UpdateSaller from "../Saller/UpdateSaller"
import ListSaller from '../Saller/ListSaller'

//=========
import CreatSale from "../Sale/CreatSale"
import UpdateSale from "../Sale/UpdateSale"
import DeletSale from "../Sale/DeleteSale"
import ListSale from "../Sale/ListSale"

function AppRouter(){
    return(
        <BrowserRouter>
            {/* Carro */}
            <Route component = {CreatCar} path="/salvarcarro" />
            <Route component = {UpdateCar} path="/atualizarcarro/" />
            <Route component = {UpdateCar} path="/atualizarcarro/:id" />
            <Route component = {ListCar} path="/listarcarros" />
            <Route component = {Delete} path="/deletarcarro" />

            {/* Vendedor */}
            <Route component = {CreatSaller} path="/salvarvendedor" />
            <Route component = {DeletSaller} path="/deletarvendedor" />
            <Route component = {UpdateSaller} path="/atualizarvendedor" />
            <Route component = {ListSaller} path="/listarvendedor" />

            {/* Venda */}
            <Route component = {CreatSale} path="/salvarvenda" />
            <Route component = {UpdateSale} path="/atualizarvenda" />
            <Route component = {UpdateSale} path="/atualizarvenda:id" />
            <Route component = {DeletSale} path="/deletarvenda" />
            <Route component = {ListSale} path="/listarvenda" />
            
        </BrowserRouter>
    )
}

export default AppRouter;