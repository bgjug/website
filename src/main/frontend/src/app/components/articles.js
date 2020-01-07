import React, {Component} from "react";
import Article from "./article";
import ApiCall from "../services/api-call";
import JwtUtil from "../services/jwt-util";

export default class Articles extends Component {
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

    loadSingleArticleById = (id) => {
        ApiCall.get("/api/article/" + id)
            .then((response) => this.setState(
                {
                    articles: [response.data],
                    tag: response.data.tags[0].name
                }
            ));
    };

    componentWillMount() {
        const articleId = this.props.routeParams.articleId;
        if (articleId) {//single article view
            this.loadSingleArticleById(articleId);
        } else { //list articles for tag
            let tagParam = this.props.routeParams.tag;

            tagParam = tagParam || 'home';

            this.refreshArticlesForTag(tagParam);
        }
    }

    componentWillReceiveProps() {
        const articleId = this.props.routeParams.articleId;
        if (articleId) {//single article view
            this.loadSingleArticleById(articleId);
        } else { //list articles for tag
            let tagParam = this.props.routeParams.tag;

            tagParam = tagParam || 'home';

            if (this.state.tag !== tagParam) { //requires refresh of articles
                this.refreshArticlesForTag(tagParam)
            }
        }
    }

    handleArticleAdd(event, tag) {
        if(tag !== "events") {
            this.props.router.push("/edit-article/new-article");
        } else {
            this.props.router.push("/edit-article/new-event");
        }
    }

    render() {
        let cursorPointerStyle = {
            cursor:"pointer"
        };

        return (
            <div>
                { JwtUtil.isCurrentUserAdmin() ?
                    <article>
                        <div className='blog-item-wrap'>
                            <div className='post-add'> <span style={cursorPointerStyle} onClick={ (e) => this.handleArticleAdd(e, this.state.tag)}><i className='fa fa-edit'/>Add Article</span> </div>
                        </div>
                    </article> : ''
                }
                {
                    this.state.articles.map(
                        (article, i) => {
                            return <Article key={i}
                                            article={article}
                                            isUnique={this.state.articles.length === 1}
                                            tag={this.props.routeParams.tag}
                                            refreshArticlesForTag={this.refreshArticlesForTag}
                                            loadSingleArticleById={this.loadSingleArticleById}
                                            router={this.props.router}/>
                        }
                    )
                }
            </div>
        );
    }
}

