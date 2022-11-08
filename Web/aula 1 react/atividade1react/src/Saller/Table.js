import React from "react";
import 'bootswatch/dist/darkly/bootstrap.css';
import "../App.css"
export default props => {
    const rows = props.dados.map(dados =>{
        return(
            <tr key={dados.id}>
                <td>{dados.id}</td>
                <td>{dados.nome}</td>
                <td>{dados.cpf}</td>
                <td>{dados.sexoEnum}</td>
                <td id="buton-acoes">
                    <button type="button" title="Editar"
                    className="btn btn-primary"
                    onClick={e => props.edit(dados.id)}></button>

                    <button type="button" title="Excluir"
                    className="btn btn-danger"
                    onClick={e => props.delete(dados.id)}></button>
                </td>
            </tr>
        )
    })
    return(
        <table className="table table-veiculos table-hover">
                    <thead>
                        <tr>                        
                        <th scope="col">Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Sexo</th>
                        <th scope="col">Açao</th>
                        </tr>
                    </thead>

                    <tbody>
                        {rows}
                    </tbody>
                </table>
    )
   
}