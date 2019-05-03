import React from 'react';
import styled from 'styled-components';
import Console from './Console.js';
import Output from './Output.js';
import ButtonIcon from "./internet.svg"


const Landing = styled.div`
  height: 100%;
  width: 100%;
  display: grid;

  grid-template-columns: 15% 30% 10% 30% 15%;
  grid-template-rows: 10% 70% 20%;


	grid-column-gap: 5px;
  grid-row-gap: 5px;

  grid-template-areas:
		" . request .  response  . "
    " . console  .  display  . "
    " .  send    .    .      . ";
`


const Send = styled.div`
  grid-area: send;
  color: green;
	height: 40%;
	width: 40%;
  place-self: center;
  margin-bottom: 2%;


  :hover {
    cursor: pointer;
  }

  display: flex;
  flex-direction: row;
  justify-content: center;
  fontsize: 10;
`

const Request = styled.div`
	grid-area: request;
	font-size: 25pt;
	text-align: center;
  color: white;
`

const Response = styled.div`
	grid-area: response;
	font-size: 25pt;
	text-align: center;
  color: white;
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
					
				}}>
          <img src={ButtonIcon}/>
        </Send>
      </Landing>
    );
  }
}

export default App;
