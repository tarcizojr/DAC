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
              {/*=== Carro ===*/}

              <NavbarItem href="/salvarcarro" label="Criar Carro"></NavbarItem> 
              <NavbarItem href="/atualizarcarro" label="Atualizar Carro"></NavbarItem>   
              <NavbarItem href="/listarcarros" label="Listar Carro"></NavbarItem>
              <NavbarItem href="/deletarcarro" label="Deletar Carro"></NavbarItem>

              {/*=== Vendedor ===*/}
              <NavbarItem href="/salvarvendedor" label="Criar Vendedor"></NavbarItem>
              <NavbarItem href="/deletarvendedor" label="Deletar Vendedor"></NavbarItem>
              <NavbarItem href="/atualizarvendedor" label="Atualizar Vendedor"></NavbarItem>
              <NavbarItem href="/listarvendedor" label="Listar Vendedor"></NavbarItem>

              {/*=== Venda ===*/}
              
              <NavbarItem href="/salvarvenda" label="Criar Venda"></NavbarItem>
              <NavbarItem href="/atualizarvenda" label="Atualizar Venda"></NavbarItem>
              <NavbarItem href="/deletarvenda" label="Deletar Venda"></NavbarItem>
              <NavbarItem href="/listarvenda" label="Listar Venda"></NavbarItem>
            </ul>   
                 
          </div>
        </div>
      </nav>
    )
}

export default NavBar;

