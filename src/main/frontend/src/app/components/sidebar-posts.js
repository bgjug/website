import React, {Component} from "react";
import ApiCall from "../services/api-call";

export default class SidebarPosts extends Component {
    constructor(props) {
        super(props);
        this.state = {articles: [], tag: null};
    }

    refreshArticlesForTag = (tagParam) => {
        ApiCall.get("/api/article/tag/" + tagParam)
            .then((response) => this.setState(
                {
                    articles: response.data,
                    tag: tagParam
                }
            ));
    };

    openArticle = (id) => {
        this.props.hashHistory.push(/article/ + id);
    };

    componentWillMount(){
        const tagParam = this.props.tag;

        this.refreshArticlesForTag(tagParam);
    }

    render() {
        const iconStyle = {
            fontSize: "52px"
        };

        let thumbClass = "fa fa-calendar";
        if (this.props.tag === "news") {
            thumbClass = "fa fa-newspaper-o"
        }

        return (
            <ul className="posts-list">
                {
                    this.state.articles.length == 0 ?
                        "There are no upcoming events planned." :
                        this.state.articles.map(
                            (article, i) => {
                                const singleArticleLink = "index.html#/article/" + article.id;

                                return <li key={i}>
                                    <div className="widget-thumb">
                                        <i className={thumbClass} style={iconStyle}/>
                                    </div>
                                    <div className="widget-content">
                                        <a href={singleArticleLink} onClick={() => this.openArticle(article.id)}>
                                            {article.title}</a>
                                        <div className="meta">
                                            <span><i className="ico-calendar-alt-fill"/>Published: {article.createdDate}</span>
                                        </div>
                                    </div>
                                    <div className="clearfix"/>
                                </li>
                            }
                        )
                }
            </ul>
        );
    }
}

