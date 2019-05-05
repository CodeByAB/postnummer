import React from 'react'
import styled from 'styled-components'
import AceEditor from 'react-ace'

import 'brace/mode/json'
import 'brace/theme/clouds_midnight'

const Con = styled.div`
  grid-area: console;
  border-radius: 10px;

`

const request = `
{
  "postnummer": 135551
}
`

class Console extends React.Component {
  constructor (props) {
    super(props)

    this.monitor = (console.log)
    this.text = request
  }

  render () {
    return (
      <Con className='console'>
        <AceEditor
          ref={this.editorRef}
          mode='json'
          theme='clouds_midnight'
          height='100%'
          widht='100%'
          value={this.text}
          defaultValue={request}
          onChange={request => this.text = request}
          name='Console Editor'
          editorProps={{ $blockScrolling: true }}
        />
      </Con>
    )
  }
}

export default Console
