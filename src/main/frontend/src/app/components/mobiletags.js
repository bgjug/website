import React, {Component} from "react";
import ApiCall from "../services/api-call";
import Tags from "./tags";

export default class MobileTags extends Tags {
    render() {
        return (
            this.state.tags.map((tag, i) => {
                let link = "/" + tag.name;
                return <li key={i}><a href="#"
                                      onClick={(e) => this.handleLinkClick(e, link)}>{tag.name}</a>
                </li>
            })
        );
    }
}

