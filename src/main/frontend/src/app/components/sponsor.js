import React, {Component} from "react";
import JwtUtil from "../services/jwt-util";

export default class Sponsor extends Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
    }

    handleSponsorEdit(event, id) {
        window.scrollTo({
            top: 0,
            left: 0,
            behavior: 'smooth'
        });
        this.props.router.push("/edit-sponsor/" + id);
    }

    handleSponsorRemove(event, id) {
        // this.props.router.push("/remove-sponsor/" + id);
    }

    render() {
        let cursorPointerStyle = {
            cursor: "pointer"
        };

        let editSponsor = JwtUtil.isCurrentUserAdmin() ?
            (<span style={cursorPointerStyle}>
            <span onClick={(e) => this.handleSponsorEdit(e, this.props.sponsor.id)}><i
                className='fa fa-edit'/>Edit</span>
            <span onClick={(e) => this.handleSponsorRemove(e, this.props.sponsor.id)}><i
                className='fa fa-remove'/>Delete</span>
        </span>) : '';

        return (
            <div className='col-md-2 col-sm-2 col-xs-12'>
                <div className='spnsors-logo'>
                    <a href={this.props.sponsor.url}><img className='img-fluid&quot;'
                                                          src={'/api/sponsor/logo/' + this.props.sponsor.id}
                                                          alt={this.props.sponsor.name}/></a>
                    {editSponsor}                                    </div>
            </div>
        )
    }
}