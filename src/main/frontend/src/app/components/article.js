import React, {Component} from "react";
import JwtUtil from "../services/jwt-util";
import ApiCall from "../services/api-call";

export default class Article extends Component {
    constructor(props) {
        super(props);
    }

    handleRemove(e, id, tag){
        const deleteCheck = confirm("are u sure that you want to delete this article?");
        if(deleteCheck) {
            ApiCall.delete("/api/article/" + id)
                .then((response) => this.props.refreshArticlesForTag(tag));
        }
    }

    handleArticleEdit(e, id) {
        this.props.router.push("/edit-article/" + id);
    }

    render() {
        let cursorPointerStyle = {
            cursor:"pointer"
        };

        let readmore = "";
        if(!this.props.isUnique) {
            const readmoreLink = "index.html#/article/" + this.props.article.id;
            readmore = (
                <div className='entry-more'>
                    <div className='pull-left'>
                        <a href={readmoreLink} onClick={() => this.props.loadSingleArticleById(this.props.article.id)} className='btn btn-common'>Read More <i className='ico-arrow-right'/></a>
                    </div>
                    <div className='share-icon pull-right'>
                        <span className='socialShare'/>
                    </div>
                </div>);
        }

        let adminMenu = (
            <span style={cursorPointerStyle}>
                <span onClick={ (e) => this.handleArticleEdit(e, this.props.article.id)}><i className='fa fa-edit'/>Edit&nbsp;</span>
                <span onClick={ (e) => this.handleRemove(e ,this.props.article.id, this.props.tag)}><i className='fa fa-remove'/>Delete&nbsp;</span>
            </span>
        );

        return (
            <article>
                <div className='blog-item-wrap'>
                    <div className='post-format'>
                        {JwtUtil.isCurrentUserAdmin() ? adminMenu : ""}
                        <span><i className='fa fa-code'/></span>
                    </div>
                    <h2 className='blog-title'>{this.props.article.title}</h2>
                    <div className='entry-meta'>
                        <span className='meta-part'><i className='ico-user'/> <a href='#'>Bulgarian Java User Group</a></span> <span
                        className='meta-part'><i className='ico-calendar-alt-fill'/> <a
                        href='#'>{this.props.article.createdDate}</a></span>
                    </div>
                    <div className='post-content'>
                        <p dangerouslySetInnerHTML={{__html: this.props.article.content || "N/A" }}>
                        </p>
                    </div>
                    {readmore}
                </div>
            </article>
        );
    }
}
