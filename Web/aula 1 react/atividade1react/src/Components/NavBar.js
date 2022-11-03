import React from "react";

import "../App.css";

import NavbarItem from "./NavBarItens";

function NavBar(props){ 
    return(
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container-fluid">
          <a className="navbar-brand" href="/">Navbar</a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarColor01">
            <ul className="navbar-nav me-auto">
              <NavbarItem href="/" label="Home"></NavbarItem>
              <NavbarItem href="/salvarcarro" label="Criar Carro"></NavbarItem>
              
            </ul>            
          </div>
        </div>
      </nav>
    )
}

export default NavBar;