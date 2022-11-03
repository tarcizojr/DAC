import React from "react";

export default class Card extends React.Component{

    render(){
        return(
            <div>
                <div className="form-floating mb-3">
                    <input type="text" className="form-control" id="floatingInput-marca" placeholder="marca"></input>
                    <label for="floatingInput-marca">{this.props.label1}</label>
                </div>

                <div className="form-floating mb-3">
                    <input type="text" className="form-control" id="floatingInput-modelo" placeholder="modelo"></input>
                    <label for="floatingInput-modelo">{this.props.label2}</label>
                </div>
            </div>
            
        )
    }
}