import React, { Component } from 'react';

import injectTapEventPlugin from 'react-tap-event-plugin';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';

//Needed for onTouchTap
//http://stackoverflow.com/a/34015469/988941
injectTapEventPlugin();

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {someState: null};
  }

  render() {
	  return ( 
	  <MuiThemeProvider>
	  	<RaisedButton label="Hello Material" style={style} />
	  </MuiThemeProvider>s
	  );
//    return (
//      <div> 
//      	Hello React component ES6 !
//      </div>
//    );
  }
}