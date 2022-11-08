import React from "react";

export default class Card extends React.Component{

    render(){
        return(
            <div>
                <label htmlFor="input1">{this.props.label}</label>
                {this.props.children}
            </div>
            
        )
    }
}