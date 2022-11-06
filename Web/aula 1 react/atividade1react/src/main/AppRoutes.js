import React from "react";

import {Route, BrowserRouter} from "react-router-dom";

import CreatCar from "../Car/CreatCar";
import UpdateCar from "../Car/Update";
import ListCar from "../Car/List";
import Delete from "../Car/Delete";

function AppRouter(){
    return(
        <BrowserRouter>
            <Route component = {CreatCar} path="/salvarcarro" />
            <Route component = {UpdateCar} path="/atualizarcarro" />
            <Route component = {ListCar} path="/listarcarros" />
            <Route component = {Delete} path="/deletarcarro" />
        </BrowserRouter>
    )
}

export default AppRouter;