import React from "react";
import ReactDOM from "react-dom";
import Articles, {articles} from "./app/components/articles";
import Tags from "./app/components/tags";
import MobileTags from "./app/components/mobiletags";
import {hashHistory, Route, Router} from 'react-router'
import TagsFooter from "./app/components/tags-footer";
import CfpSubmit from "./app/components/cfp";
import Login from "./app/components/login";
import Registration from "./app/components/registration";
import SidebarPosts from "./app/components/sidebar-posts";
import ArticleEdit from "./app/components/article-edit";
import SponsorEdit from "./app/components/sponsor-edit";
import Sponsors from "./app/components/sponsors";


ReactDOM.render(
    <Tags hashHistory={hashHistory}/>
    , document.querySelector('#tags'));

ReactDOM.render(
    <MobileTags hashHistory={hashHistory}/>
    , document.querySelector('.slicknav_nav'));


const Routing = () => (
        <Router history={hashHistory}>
            <Route path="/" component={Articles}/>
            <Route path="submit%20a%20talk" component={CfpSubmit}/>
            <Route path="login" component={Login}/>
            <Route path="registration" component={Registration}/>
            <Route path="/article/:articleId" component={Articles}/>
            <Route path="/edit-article/:articleId" component={ArticleEdit}/>
            <Route path="/:tag" component={Articles}/>
            <Route path="/edit-sponsor/:sponsorId" component={SponsorEdit}/>
            <Route path="/add-sponsor/:sponsorId" component={SponsorEdit}/>
        </Router>
);

ReactDOM.render(<Routing/>, document.querySelector('#articles'));

ReactDOM.render(<SidebarPosts tag="events" hashHistory={hashHistory}/>, document.querySelector('#tab1'));

ReactDOM.render(<SidebarPosts tag="news" hashHistory={hashHistory}/>, document.querySelector('#tab2'));

ReactDOM.render(<Sponsors hashHistory={hashHistory}/>, document.querySelector('#sponsors_list'));

ReactDOM.render(<TagsFooter hashHistory={hashHistory}/>, document.querySelector('#footer-menu'));

