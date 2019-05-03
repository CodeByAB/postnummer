import React from 'react'
import styled from 'styled-components'

const Out = styled.div`
	display: flex;
  grid-area: display;
	place-item: center stretch;
`

const Pre = styled.pre`
	display: flex;
	background-color: rgba(238, 238, 238, 0.7);
	width: 100%;
	height: auto;
	

`

class Output extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <Out className="display">
        <Pre>
          {this.props.text}
        </Pre>
      </Out>
    )
  }
}

export default Output
