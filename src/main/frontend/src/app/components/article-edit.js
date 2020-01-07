import React, {Component} from "react";
import ApiCall from "../services/api-call";
import ReactMarkdown from "react-markdown/with-html";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import Typography from "@material-ui/core/Typography";
import PropTypes from 'prop-types';
import {makeStyles} from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';


function TabPanel(props) {
    const { children, value, index, ...other } = props;

    return (
        <Typography
            component="div"
            role="tabpanel"
            hidden={value !== index}
            id={`simple-tabpanel-${index}`}
            aria-labelledby={`simple-tab-${index}`}
            {...other}
        >
            {value === index && <Box p={3}>{children}</Box>}
        </Typography>
    );
}

TabPanel.propTypes = {
    children: PropTypes.node,
    index: PropTypes.any.isRequired,
    value: PropTypes.any.isRequired,
};

function a11yProps(index) {
    return {
        id: `simple-tab-${index}`,
        'aria-controls': `simple-tabpanel-${index}`,
    };
}

const useStyles = makeStyles(theme => ({
    root: {
        flexGrow: 1,
        backgroundColor: theme.palette.background.paper,
    },
}));

export default class ArticleEdit extends Component {
    constructor(props) {
        super(props);

        this.state = {
            title: "",
            content: "",
            tag: "",
            message: null,
            selectedIndex:0
        };

        this.onSubmit = this.onSubmit.bind(this);
        // this.goToRegister = this.goToRegister.bind(this);

    }

    onChange = e => this.setState({ [e.target.name]: e.target.value });
    onTabChange = (e, newValue) => this.setState({selectedIndex:newValue});

    // goToRegister(event)  {
    //     this.props.router.push("/registration");
    // }

    componentWillReceiveProps() {
        const articleId = this.props.routeParams.articleId;
        if(articleId === "new-event") {
            this.setState({
                id: null,
                title: "",
                content: "",
                tag: "events",
                location:"Sofia, Bulgaria",
                eventDate:"2019-09-12T13:04:09"
            })
        } else if (articleId === "new-article") {
            this.setState({
                    id: null,
                    title: "",
                    content: "",
                    tag: ""
                });
        } else if (articleId) {
            ApiCall.get("/api/article/" + articleId)
                .then((response) => this.setState(
                    {
                        id:response.data.id,
                        title: response.data.title,
                        content: response.data.content,
                        tag: response.data.tags[0].name,
                        location:response.data.location,
                        eventDate:response.data.eventDate
                    }
                ));
        }
    }


    onSubmit(event) {
        event.preventDefault();

        const data = {
            title: event.target.title.value,
            content: event.target.content.value,
            tags: [{name: event.target.tag.value}],
            //event optional part that will be ignored if we call /api/article
            location: event.target.location ? event.target.location.value : "",
            eventDate: event.target.eventDate ? event.target.eventDate.value : ""
        };


        if (!(data.title && data.content && data.tags)) {
            this.setState({message: "Please fill all fields."});
        } else {
            if(data.location) {
                this.persistEvent(data);
            } else {
                this.persistArticle(data);
            }
        }
    }

    persistEvent(data){
        let self = this;
        //update event
        if(this.state.id) {
            data["id"] = this.state.id;
            ApiCall.put("/api/event", JSON.stringify(data))
                .then((response) => {
                    console.log(response.headers);
                    self.setState({message: "Event with ID: "+ this.state.id + " updated!"});
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                    self.setState({message: "Ops... nothing happened (check the browser console)." + error.response.status});
                });
        } else {
            //create article
            ApiCall.post("/api/event", JSON.stringify(data))
                .then((response) => {
                    console.log(response.headers);
                    self.setState({message: "New Event Created!"});
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                    self.setState({message: "Ops... nothing happened (check the browser console)." + error.response.status});
                });
        }
    }

    persistArticle(data) {
        let self = this;
        //update article
        if(this.state.id) {
            data["id"] = this.state.id;
            ApiCall.put("/api/article", JSON.stringify(data))
                .then((response) => {
                    console.log(response.headers);
                    self.setState({message: "Article with ID: "+ this.state.id + " updated!"});
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                    self.setState({message: "Ops... nothing happened (check the browser console)." + error.response.status});
                });
        } else {
            //create article
            ApiCall.post("/api/article", JSON.stringify(data))
                .then((response) => {
                    console.log(response.headers);
                    self.setState({message: "New Article Created!"});
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                    self.setState({message: "Ops... nothing happened (check the browser console)." + error.response.status});
                });
        }
    }

    render() {

        let error = null;

        if(this.state.message) {
            error = (
                <div className="alert alert-danger">
                    <strong>{this.state.message}</strong>
                </div>);
        }
        //if it is an event
        let eventInputs = "";
        if(this.state.location) {
               eventInputs = (
                   <span>
                       <div className="form-group">
                           <label htmlFor="topic">Location :</label>
                           <input id="location" type="text" name="location" className="form-control" value={this.state.location || ""}
                                  onChange={this.onChange}/>
                       </div>
                       <div className="form-group">
                           <label htmlFor="topic">Event Date :</label>
                           <input id="eventDate" type="text" name="eventDate" className="form-control" value={this.state.eventDate || ""}
                                  onChange={this.onChange}/>
                       </div>

                   </span>
               );
        }


            return (
            <div className="row">
                <div className="col-md-12">
                    <div id="articles">
                        <article>
                            <h1> Create Article/Event </h1>
                            {error}
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                    <label htmlFor="title">Title:</label>
                                    <input id="title" type="text" name="title" className="form-control" value={this.state.title || ""}
                                           onChange={this.onChange}/>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="title">Content:</label>
                                    <Tabs value={this.state.selectedIndex} onChange={this.onTabChange} aria-label="simple tabs example">
                                        <Tab label="Source" {...a11yProps(0)}/>
                                        <Tab label="Preview" {...a11yProps(0)}/>

                                    </Tabs>
                                    <TabPanel value={this.state.selectedIndex} index={0}>
                                       <textarea id="contenta" name="content" className="form-control grey-textarea"  rows="10" value={this.state.content || ""}
                                                 onChange={this.onChange}/>
                                    </TabPanel>
                                    <TabPanel value={this.state.selectedIndex} index={1}>
                                        <ReactMarkdown
                                            source={this.state.content || ""}
                                            escapeHtml={false}
                                            className="form-control grey-textarea min200"
                                        />
                                    </TabPanel>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="topic">Tag :</label>
                                    <input id="tag" type="text" name="tag" className="form-control" value={this.state.tag || ""}
                                           onChange={this.onChange}/>
                                </div>
                                {eventInputs}
                                <input type="submit" value="Save" className="btn btn-primary"/> &nbsp;
                                {/*<input type="button" value="Register" className="btn btn-primary" onClick={this.goToRegister}/>*/}
                            </form>
                        </article>
                    </div>
                </div>
            </div>
        );
    }
}

