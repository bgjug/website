import React, {Component} from "react";
import ApiCall from "../services/api-call";
import JwtUtil from "../services/jwt-util";
import Sponsor from "./sponsor";

export default class Sponsors extends Component {
    constructor(props) {
        super(props);
        this.state = {sponsors: []};
        this.hashHistory = this.props.hashHistory;
    }

    loadSingleSponsorById = (id) => {
        ApiCall.get("/api/sponsor/" + id)
            .then((response) => this.setState(
                {
                    sponsors: [response.data]
                }
            ));
    };

    loadSponsors = () => {
        ApiCall.get("/api/sponsor")
            .then((response) => this.setState(
                {
                    sponsors: response.data
                }
            ));
    };

    componentWillMount() {
        this.loadSponsors();
    }

    handlerSponsorAdd(event) {
        window.scrollTo({
            top: 0,
            left: 0,
            behavior: 'smooth'
        });
        this.hashHistory.push("/add-sponsor/new-sponsor");
    }

    render() {
        let cursorPointerStyle = {
            cursor: "pointer"
        };

        let sponsors = this.state.sponsors.map((sponsor, i) => {
            return <Sponsor key={i} sponsor={sponsor} hashHistory={this.hashHistory}
                            loadSponsors={this.loadSponsors}/>
        });

        let idx = 0;
        let sponsor_rows = [];
        let i;
        for (i = 0; i < sponsors.length; i += 5) {
            sponsor_rows[idx++] = <div className="row mb-30">
                {sponsors.slice(i, Math.max(i + 5, sponsors.length))}
            </div>
        }

        return (
            <div>
                {JwtUtil.isCurrentUserAdmin() ?
                    <article>
                        <div className='blog-item-wrap'>
                            <div className='post-add'><span style={cursorPointerStyle}
                                                            onClick={(e) => this.handlerSponsorAdd(e)}><i
                                className='fa fa-plus'/>Add Sponsor</span></div>
                        </div>
                    </article> : ''
                }
                <div className="row">
                    <div className="col-md-12">
                        <h1 className="section-sub text-center">Our Sponsors</h1>
                    </div>
                </div>
                {sponsor_rows}
            </div>
        )
    }
}