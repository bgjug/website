import React, {Component} from "react";
import Article from "./article";
import ApiCall from "../services/api-call";

export default class Articles extends Component {
    constructor(props) {
        super(props);
        this.state = {articles: [], tag: null};
    }

    refreshArticlesForTag(tagParam) {
        const tag = tagParam || 'home';

        ApiCall.get("/api/article/tag/" + tag)
            .then((response) => this.setState(
                {
                    articles: response.data,
                    tag: tag
                }
            ));
    }

    componentWillMount(){
        const tagParam = this.props.routeParams.tag;

        this.refreshArticlesForTag(tagParam);
    }

    componentWillReceiveProps (){
        const tagParam = this.props.routeParams.tag;

        if (this.state.tag !== tagParam) { //requires refresh of articles
            this.refreshArticlesForTag(tagParam)
        }
    }

    render() {
        // let container = [];
        //
        // for(let i=0;i<this.state.articles.length;i++){
        //     container.push(
        //         (<Article key={i} article={this.state.articles[i]} isUnique={this.state.articles.length === 1}></Article>)
        //     );
        // }
        //
        // return <div>{container}</div>;

        //alternative way
        return (
            <div>
                {
                    this.state.articles.map(
                        (article, i) => {
                            return <Article key={i} article={article}
                                            isUnique={this.state.articles.length === 1}></Article>
                        }
                    )
                }
            </div>
        );
    }
}

