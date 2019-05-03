import React from 'react'
import styled from 'styled-components'

const Out = styled.div`
	display: flex;
  grid-area: display;
	place-item: center stretch;
`

const Pre = styled.pre`
	display: flex;
	background-color: rgba(25, 25, 25, 1);
  color: white;
	width: 100%;
	height: auto;
  padding: 10px;
  white-space: pre-wrap;       /* Since CSS 2.1 */
  white-space: -moz-pre-wrap;  /* Mozilla, since 1999 */
  white-space: -pre-wrap;      /* Opera 4-6 */
  white-space: -o-pre-wrap;    /* Opera 7 */
  word-wrap: break-word;       
  border-radius: 10px;
`

class Output extends React.Component {
  render() {
    return (
      <Out className="display">
        <Pre>
          {this.props.text || "No Requests has been made"}
        </Pre>
      </Out>
    )
  }
}

export default Output
