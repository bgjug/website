import React, {Component} from "react";
import ApiCall from "../services/api-call";

export default class CfpSubmit extends Component {
    constructor(props) {
        super(props);

        this.state = {
            name: "",
            email: "",
            topic: "",
            details: "",
            error: false
        };

        this.onSubmit = this.onSubmit.bind(this)
    }

    onChange = e => this.setState({ [e.target.name]: e.target.value });

    onSubmit(event) {
        event.preventDefault();

        const data = {
            name: event.target.name.value,
            email: event.target.email.value,
            topic: event.target.topic.value,
            details: event.target.details.value
        };


        if (!(data.name && data.email && data.topic && data.details)) {
            this.setState({error: true});
        } else {
            ApiCall.post("/api/submission", JSON.stringify(data));
            this.setState({error: false});
            console.log(data);
        }
    }


    render() {

        let error = null;
        if(this.state.error) {
            error = (
            <div className="alert alert-danger">
                <strong>Please fill all fields.</strong>
            </div>);
        }

        return (
            <div className="row">
                <div className="col-md-12">
                    <div id="articles">
                        <article>
                            <div>
                                {error}
                                <form onSubmit={this.onSubmit}>
                                    <div className="form-group">
                                        <label htmlFor="name">Your Name:</label>
                                        <input id="name" type="text" name="name" className="form-control" value={this.state.name || ""}
                                               onChange={this.onChange}/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="email">Your Email:</label>
                                        <input id="email" type="text" name="email" className="form-control" value={this.state.email || ""}
                                               onChange={this.onChange}/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="topic">Topic proposal :</label>
                                        <input id="topic" type="text" name="topic" className="form-control" value={this.state.topic || ""}
                                               onChange={this.onChange}/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="details">Details :</label>
                                        <textarea id="details" name="details" className="text-area text-box multi-line form-control"
                                                  rows="5" data-val-length-max="2048" value={this.state.details || ""}
                                        onChange={this.onChange}/>
                                    </div>
                                    <input type="submit" value="submit" className="btn btn-primary"/>
                                </form>
                            </div>
                        </article>
                    </div>
                </div>
            </div>
        );
    }
}

