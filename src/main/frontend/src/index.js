import React from "react";
import ReactDOM from "react-dom";
import Articles from "./app/components/articles";
import Tags from "./app/components/tags";
import {hashHistory, Route, Router} from 'react-router'
import TagsFooter from "./app/components/tags-footer";
import CfpSubmit from "./app/components/cfp";


ReactDOM.render(
    <Tags hashHistory={hashHistory}/>
    , document.querySelector('#tags'));



const Routing = () => (
        <Router history={hashHistory}>
            <Route path="/" component={Articles}/>
            <Route path="submit%20a%20talk" component={CfpSubmit}/>
            <Route path="/:tag" component={Articles}/>
        </Router>
);

ReactDOM.render(
    <Routing />
  , document.querySelector('#articles'));

ReactDOM.render(
    <TagsFooter hashHistory={hashHistory}/>
    , document.querySelector('#footer-menu'));
