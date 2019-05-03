import React from 'react'
import styled from 'styled-components'
import AceEditor from "react-ace";

import "brace/mode/json";
import "brace/theme/solarized_dark";

const Con = styled.div`
  grid-area: console;

`

const request = `
{
  "postnummer": 135551
}
`;

class Console extends React.Component {
  constructor(props) {
    super(props)

    this.monitor = (console.log);
		this.text = request
  }

  render() {
    return (
        <Con className='console'>
				 <AceEditor
						ref={this.editorRef}
						mode="json"
						theme="solarized_dark"
						height="100%"
						widht="100%"
						value={this.text}
						defaultValue={request}
						onChange={request => this.text = request}
						name="Console Editor"
						editorProps={{ $blockScrolling: true }}
					/>
        </Con>
      )
  }
}

export default Console
