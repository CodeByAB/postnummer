import React from 'react';
import styled from 'styled-components';
import Console from './Console.js';
import Output from './Output.js';


const Landing = styled.div`
  height: 100%;
  width: 100%;
  display: grid;

  grid-template-columns: 10% 30% 10% 10% 13% 22% 5% ;
  grid-template-rows: 10% 70% 20%;


	grid-column-gap: 10px;
  grid-row-gap: 15px;

  grid-template-areas:
		" . response . request request request request "
    " . display . . console console . "
    " . . . . . send . ";
`


const Send = styled.button`
  grid-area: send;
  color: green;
	height: 20%;
	width: 20%;
`

const Request = styled.div`
	grid-area: request;
	font-size: 25pt;
	text-align: center;
`

const Response = styled.div`
	grid-area: response;
	font-size: 25pt;
	text-align: center;
`



class App extends React.Component {
  constructor(props) {
    super(props)

    this.consoleRef = React.createRef()
		
		this.state = {
			output: ""
		}
  }


  render() {
    return (
      <Landing className="App">
				<Request> API Request </Request>
				<Response> API Response </Response>
        <Console ref={this.consoleRef}/>
        <Output text={this.state.output}/>
        <Send onClick={() => {
					// Todo -- send request 

					// Update output with response
					this.setState({output: this.consoleRef.current.text})
					
				}}> Try API </Send>
      </Landing>
    );
  }
}

export default App;
