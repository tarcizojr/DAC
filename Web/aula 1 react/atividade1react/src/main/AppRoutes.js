import React from "react";

import {Route, BrowserRouter} from "react-router-dom";

import CreatCar from "../Car/Creat";
import UpCar from "../Car/Update";

function AppRouter(){
    return(
        <BrowserRouter>
            <Route component = {CreatCar} path="/salvarcarro"></Route>
            <Route component={UpCar} path="/atualizarcarro"></Route>
        </BrowserRouter>
    )
}

export default AppRouter;