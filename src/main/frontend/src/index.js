import React from "react";
import ReactDOM from "react-dom";
import Articles from "./app/components/articles";
import Tags from "./app/components/tags";
import {hashHistory, Route, Router} from 'react-router'


ReactDOM.render(
    <Tags hashHistory={hashHistory}/>
    , document.querySelector('#tags'));



const Routing = () => (
        <Router history={hashHistory}>
            <Route path="/" component={Articles}/>
            <Route path="/:tag" component={Articles}/>
        </Router>
);

// const routing = (
//     <Router>
//         <div>
//             <ul>
//                 <li>
//                     <Link to="/">Home</Link>
//                 </li>
//                 <li>
//                     <Link to="/users">Users</Link>
//                 </li>
//                 <li>
//                     <Link to="/contact">Contact</Link>
//                 </li>
//             </ul>
//             <Switch>
//                 <Route exact path="/" component={App} />
//                 <Route path="/users/:id" component={Users} />
//                 <Route path="/contact" component={Contact} />
//                 <Route component={Notfound} />
//             </Switch>
//         </div>
//     </Router>
// )


ReactDOM.render(
    <Routing />
  , document.querySelector('#articles'));
