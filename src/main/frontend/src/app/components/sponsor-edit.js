import React, {Component} from "react";
import ApiCall from "../services/api-call";

export default class SponsorEdit extends Component {

    constructor(props) {
        super(props);

        this.state = {
            sponsor: "",
            web_url: "",
            logo: null,
            image_type: "",
            message: null,
            preview: null,
        };

        this.onSubmit = this.onSubmit.bind(this);
        // this.goToRegister = this.goToRegister.bind(this);
    }

    onChange = e => this.setState({[e.target.name]: e.target.value});

    onFileChangeHandler = (e) => {
        this.setState({
            logo: e.target.files[0],
            image_type: e.target.files[0].type,
            preview: URL.createObjectURL(e.target.files[0])
        });
    };

    componentWillReceiveProps() {
        const sponsorId = this.props.routeParams.sponsorId;
        if (sponsorId === 'new-sponsor') {
            this.setState({
                id: null,
                sponsor: "",
                web_url: "",
                logo: null,
                image_type: "",
                preview: null,
            })
        } else {
            ApiCall.get("/api/sponsor/" + sponsorId)
                .then((response) => this.setState(
                    {
                        id: response.data.id,
                        sponsor: response.data.name,
                        web_url: response.data.url,
                        preview: "/api/sponsor/logo/" + response.data.id
                    }
                ));
        }
    }

    onSubmit(event) {
        event.preventDefault();

        const formData = new FormData();
        if (this.state.id) {
            formData.append("id", this.state.id)
        }
        formData.append("sponsor", this.state.sponsor);
        formData.append("web_url", this.state.web_url);
        if (this.state.logo) {
            formData.append("image_type", this.state.image_type);
            formData.append("logo", this.state.logo);
        }

        if (!(this.state.sponsor && this.state.web_url)) {
            this.setState({message: "Please fill all fields."});
        } else {
            let self = this;
            //update sponsor
            if (this.state.id) {
                ApiCall.put("/api/sponsor", formData)
                    .then((response) => {
                        console.log(response.headers);
                        self.setState({message: "Sponsor with ID: " + this.state.id + " updated!"});
                        self.props.router.push("/");
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                        self.setState({message: "Ops... nothing happened (check the browser console)." + error.response.status});
                    });
            } else {
                //create sponsor
                ApiCall.post("/api/sponsor", formData)
                    .then((response) => {
                        console.log(response.headers);
                        self.setState({message: "New Sponsor Created!"});
                        self.props.router.push("/");
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                        self.setState({message: "Ops... nothing happened (check the browser console)." + error.response.status});
                    });
            }
        }
    }

    render() {

        let error = null;

        if (this.state.message) {
            error = (
                <div className="alert alert-danger">
                    <strong>{this.state.message}</strong>
                </div>);
        }

        return (
            <div className="row">
                <div className="col-md-12">
                    <div id="sponsors">
                        <article>
                            <h1> Create Sponsor </h1>
                            {error}
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                    <label htmlFor="title">Name:</label>
                                    <input id="sponsor" type="text" name="sponsor" className="form-control"
                                           value={this.state.sponsor || ""}
                                           onChange={this.onChange}/>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="title">URL:</label>
                                    <textarea id="web_url" name="web_url"
                                              className="form-control grey-textarea" rows="10"
                                              value={this.state.web_url || ""}
                                              onChange={this.onChange}/>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="topic">Logo image:</label>
                                    <input id="logo" type="file" name="logo" className="form-control"
                                           onChange={this.onFileChangeHandler}/>
                                    <img src={this.state.preview} hidden={this.state.preview === null}
                                         alt={this.state.sponsor}/>
                                </div>
                                <input type="submit" value="Save" className="btn btn-primary"/> &nbsp;
                            </form>
                        </article>
                    </div>
                </div>
            </div>
        );
    }
}