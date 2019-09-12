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

    componentWillMount() {
        let self = this;
        let articles = ApiCall.get("/api/tag")
            .then((response) => this.setState({tags: response.data}))
            .catch(function (error) {
                if (error.response && error.response.status === 401) {
                    //the bearer has expired, redirect to login
                    sessionStorage.removeItem("jwtToken");
                    self.hashHistory.push("/login");
                }
            });
    }

    handleLinkClick(e, link) {
        e.preventDefault();
        this.hashHistory.push(link);
    }

    render() {
        return (
            <ul className="nav navbar-nav navbar-right">{
                this.state.tags.map((tag, i) => {
                    let link = "/" + tag.name;
                    return <li key={i}><a href="#" onClick={ (e) => this.handleLinkClick(e, link)}>{tag.name}</a></li>
                })}
            </ul>
        );
    }
}

