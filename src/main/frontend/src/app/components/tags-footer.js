import React, {Component} from "react";
import ApiCall from "../services/api-call";


export default class TagsFooter extends Component {
    constructor(props) {
        super(props);
        this.state = {tags : []};
        this.hashHistory = this.props.hashHistory;
    }

    componentWillMount(){
        let articles = ApiCall.get("/api/tag")
            .then((response) => this.setState({tags: response.data}));
    }

    handleLinkClick(e, link) {
        e.preventDefault();
        this.hashHistory.push(link);
        window.scrollTo({
            top: 0,
            left: 0,
            behavior: 'smooth'
        });
    }

    render() {
        return (
            <ul className="footer-menu">{
                this.state.tags.map((tag, i) => {
                    let link = "/" + tag.name;
                    return <li key={i}><a href="#" onClick={ (e) => this.handleLinkClick(e, link)}>{tag.name}</a></li>
                })}
            </ul>
        );
    }
}

