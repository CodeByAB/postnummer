import React from 'react'
import styled from 'styled-components'
import Console from './Console.js'
import Output from './Output.js'
import ButtonIcon from './internet.svg'

const Landing = styled.div`
  height: auto;
  width: 100%;
  display: grid;


  // Meaning anything above a tablet get this layout
  @media (min-width: 769px) {
    grid-template-columns: 1.5fr 3fr 1fr 3fr 1.5fr;
    grid-template-rows: 1fr 7fr 2fr;


    grid-column-gap: 5px;
    grid-row-gap: 5px;

    grid-template-areas:
      " . request  . response  . "
      " . console  .  display  . "
      " .  send    .    .      . ";
  }

  // Layout for anything below & including tablet.. we currently don't distinguish between tablet & phone
  // But for our tiny UI i don't believe it makes much of a difference.. and we both suck at UX design
  // So i don't think that is what anyone will notice anyway! :) 
  @media (max-width: 768px) {
    grid-template-columns: 1fr 3fr 1fr;
    grid-template-rows: 1fr 4fr 1fr 1fr 4fr;

    grid-column-gap: 5px;
    grid-row-gap: 5px;

    grid-template-areas:
      " . request  .  "
      " . console  .  "
      " . send     .  "
      " . response .  "
      " . display  .  ";
  }
  
`

const Send = styled.div`
  grid-area: send;
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
  constructor (props) {
    super(props)

    this.consoleRef = React.createRef()

    this.state = {
      output: ''
    }
  }

  render () {
    return (
      <Landing className='App'>
        <Request> API Request </Request>
        <Response> API Response </Response>
        <Console ref={this.consoleRef} />
        <Output text={this.state.output} />
        <Send onClick={() => {
          // Todo -- send request

          // Update output with response
          this.setState({ output: this.consoleRef.current.text })
        }}>
          <img alt='button-icon' src={ButtonIcon} />
        </Send>
      </Landing>
    )
  }
}

export default App
