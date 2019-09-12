import React, {Component} from "react";
import ApiCall from "../services/api-call";

export default class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: "",
            password: "",
            message: null
        };

        this.onSubmit = this.onSubmit.bind(this);
        this.goToRegister = this.goToRegister.bind(this);
    }

    onChange = e => this.setState({ [e.target.name]: e.target.value });

    goToRegister(event)  {
        this.props.router.push("/registration");
    }

    onSubmit(event) {
        let self = this;
        event.preventDefault();

        const data = {
            email: event.target.email.value,
            password: event.target.password.value
        };


        if (!(data.email && data.password)) {
            this.setState({message: "Please fill all fields."});
        } else {
            ApiCall.post("/api/user/login", JSON.stringify(data))
                .then((response) => {
                    console.log(response.headers);
                    sessionStorage.setItem("jwtToken", response.headers.authorization);
                    self.setState({message: "Login successful!"});
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                    if (error.response && error.response.status === 401) {
                        self.setState({message: "Your username and/or password are incorrect."});
                    }
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
                                    <input type="submit" value="Login" className="btn btn-primary"/> &nbsp;
                                    <input type="button" value="Register" className="btn btn-primary" onClick={this.goToRegister}/>
                                </form>
                            </div>
                        </article>
                    </div>
                </div>
            </div>
        );
    }
}

