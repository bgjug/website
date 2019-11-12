import React, {Component} from "react";
import ApiCall from "../services/api-call";

export default class ArticleEdit extends Component {
    constructor(props) {
        super(props);

        this.state = {
            title: "",
            content: "",
            tag: "",
            message: null
        };

        this.onSubmit = this.onSubmit.bind(this);
        // this.goToRegister = this.goToRegister.bind(this);
    }

    onChange = e => this.setState({ [e.target.name]: e.target.value });

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
                                    <textarea id="contenta" name="content" className="form-control grey-textarea"  rows="10" value={this.state.content || ""}
                                           onChange={this.onChange}/>
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

