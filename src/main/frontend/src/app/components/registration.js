import React, {Component} from "react";
import ApiCall from "../services/api-call";

export default class Registration extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: "",
            password: "",
            rpassword: "",
            message: null
        };

        this.onSubmit = this.onSubmit.bind(this)
        this.goToLogin = this.goToLogin.bind(this);
    }

    onChange = e => this.setState({ [e.target.name]: e.target.value });

    goToLogin(event)  {
        this.props.router.push("/login");
    }

    onSubmit(event) {
        let self = this;
        event.preventDefault();

        const data = {
            email: event.target.email.value,
            password: event.target.password.value,
            rpassword: event.target.rpassword.value,
        };


        if (!(data.email && data.password && data.rpassword) || data.password !== data.rpassword) {
            this.setState({message: "Please fill all fields."});
        } else {
            ApiCall.post("/api/user", JSON.stringify(data))
                .then((response) => {
                    console.log(response.headers);
                    if(response.status === 200) {
                        self.setState({message: "User created successfully, go to login"});
                    }
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                    self.setState({message: error.response.status});
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

        return (
            <div className="row">
                <div className="col-md-12">
                    <div id="articles">
                        <article>
                            <div>
                                {error}
                                <form onSubmit={this.onSubmit}>
                                    <div className="form-group">
                                        <label htmlFor="email">Your Email:</label>
                                        <input id="email" type="text" name="email" className="form-control" value={this.state.email || ""}
                                               onChange={this.onChange}/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="topic">Your password :</label>
                                        <input id="password" type="password" name="password" className="form-control" value={this.state.password || ""}
                                               onChange={this.onChange}/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="topic">Repeat password :</label>
                                        <input id="rpassword" type="password" name="rpassword" className="form-control" value={this.state.rpassword || ""}
                                               onChange={this.onChange}/>
                                    </div>
                                    <input type="submit" value="Register" className="btn btn-primary"/> &nbsp;
                                    <input type="button" value="Go to login" className="btn btn-primary" onClick={this.goToLogin}/>
                                </form>
                            </div>
                        </article>
                    </div>
                </div>
            </div>
        );
    }
}

