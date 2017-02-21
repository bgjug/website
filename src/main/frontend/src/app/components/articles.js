import React, {Component} from "react";
import Article from "./article";
import ApiCall from "../services/api-call";

export default class Articles extends Component {
    constructor(props) {
        super(props);
        this.state = {articles : []};
    }

    componentWillMount(){

        let articles = ApiCall.get("/api/article")
            .then((response) => this.setState({articles: response.data.articleInfo}));
    }

    render() {
        let container = [];


        for(let i=0;i<this.state.articles.length;i++){
            container.push(
                (<Article key={i} article={this.state.articles[i]}></Article>)
            );
        }

        return <div>{container}</div>;

        //alternative way
        // return <div>{
        //     this.state.articles.map((article, i) => {
        //         return <Article key={i} article={article}></Article>
        //     })}
        // </div>
    }
}
