import React from "react";

export default class Card extends React.Component{

    render(){
        return(
            <div className="form-floating mb-3">
                <label htmlFor="input1">{this.props.label}</label>
                {this.props.children}
            </div>
            
        )
    }
}