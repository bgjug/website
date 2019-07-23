import React, {Component} from "react";
import ApiCall from "../services/api-call";


export default class Tags extends Component {
    constructor(props) {
        super(props);
        this.state = {tags : []};
        this.hashHistory = this.props.hashHistory;
        // Tags.contextTypes = {
        //     history: React.PropTypes.shape({
        //         push: React.PropTypes.func.isRequired
        //     })};
    }

    componentWillMount(){
        let articles = ApiCall.get("/api/tag")
            .then((response) => this.setState({tags: response.data}));
    }

    handleLinkClick(e, link) {
        e.preventDefault();
        this.hashHistory.push(link);
        // window.location.reload();
    }

    render() {
        return (
            <ul className="nav navbar-nav navbar-right">{
                this.state.tags.map((tag, i) => {
                    // let link = "/#/" + tag.name;
                    let link = "/" + tag.name;
                    return <li key={i}><a href="#" onClick={ (e) => this.handleLinkClick(e, link)}>{tag.name}</a></li>
                })}
            </ul>
        );
    }
}

