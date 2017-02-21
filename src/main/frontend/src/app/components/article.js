import React, {Component} from "react";

export default class Article extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <article>
                <div className='blog-item-wrap'>
                    <div className='post-format'>
                        <span><i className='fa fa-camera'/></span>
                    </div>
                    <h2 className='blog-title'><a href='single.html'>{this.props.article.title}</a></h2>
                    <div className='entry-meta'>
                        <span className='meta-part'><i className='ico-user'/> <a href='#'>James Maclern</a></span> <span
                        className='meta-part'><i className='ico-calendar-alt-fill'/> <a
                        href='#'>January 7, 2015</a></span> <span className='meta-part'><i className='ico-comments'/> <a
                        href='#'>20</a></span> <span className='meta-part'><i className='ico-tag'/> <a href='#'>Tech</a></span>
                        <span className='meta-part'><i className='ico-star'/> <a href='#'>7.5</a></span>
                    </div>
                    <div className='post-content'>
                        <p>
                            {this.props.article.shortContent || "N/A"}
                        </p>
                    </div>
                    <div className='entry-more'>
                        <div className='pull-left'>
                            <a href='single.html' className='btn btn-common'>Read More <i className='ico-arrow-right'/></a>
                        </div>
                        <div className='share-icon pull-right'>
                            <span className='socialShare'/>
                        </div>
                    </div>
                </div>
            </article>
        );
    }
}
