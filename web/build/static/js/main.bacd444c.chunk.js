(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{24:function(e,t,n){e.exports=n(43)},29:function(e,t,n){},43:function(e,t,n){"use strict";n.r(t);var r=n(0),a=n.n(r),o=n(9),c=n.n(o),i=(n(29),n(3)),u=n(4),s=n(6),l=n(5),d=n(7),f=n(1),h=n(2),p=n(20),m=n.n(p);n(38),n(40);function g(){var e=Object(f.a)(["\n  grid-area: console;\n\n"]);return g=function(){return e},e}var b=h.a.div(g()),v='\n{\n  "postnummer": 135551\n}\n',j=function(e){function t(e){var n;return Object(i.a)(this,t),(n=Object(s.a)(this,Object(l.a)(t).call(this,e))).monitor=console.log,n.text=v,n}return Object(d.a)(t,e),Object(u.a)(t,[{key:"render",value:function(){var e=this;return a.a.createElement(b,{className:"console"},a.a.createElement(m.a,{ref:this.editorRef,mode:"json",theme:"solarized_dark",height:"100%",widht:"100%",value:this.text,defaultValue:v,onChange:function(t){return e.text=t},name:"Console Editor",editorProps:{$blockScrolling:!0}}))}}]),t}(a.a.Component);function O(){var e=Object(f.a)(["\n\tdisplay: flex;\n\tbackground-color: rgba(238, 238, 238, 0.7);\n\twidth: 100%;\n\theight: auto;\n\t\n\n"]);return O=function(){return e},e}function w(){var e=Object(f.a)(["\n\tdisplay: flex;\n  grid-area: display;\n\tplace-item: center stretch;\n"]);return w=function(){return e},e}var x=h.a.div(w()),E=h.a.pre(O()),y=function(e){function t(e){return Object(i.a)(this,t),Object(s.a)(this,Object(l.a)(t).call(this,e))}return Object(d.a)(t,e),Object(u.a)(t,[{key:"render",value:function(){return a.a.createElement(x,{className:"display"},a.a.createElement(E,null,this.props.text))}}]),t}(a.a.Component);function k(){var e=Object(f.a)(["\n\tgrid-area: response;\n\tfont-size: 25pt;\n\ttext-align: center;\n"]);return k=function(){return e},e}function R(){var e=Object(f.a)(["\n\tgrid-area: request;\n\tfont-size: 25pt;\n\ttext-align: center;\n"]);return R=function(){return e},e}function q(){var e=Object(f.a)(["\n  grid-area: send;\n  color: green;\n\theight: 20%;\n\twidth: 20%;\n"]);return q=function(){return e},e}function C(){var e=Object(f.a)(['\n  height: 100%;\n  width: 100%;\n  display: grid;\n\n  grid-template-columns: 10% 30% 10% 10% 13% 22% 5% ;\n  grid-template-rows: 10% 70% 20%;\n\n\n\tgrid-column-gap: 10px;\n  grid-row-gap: 15px;\n\n  grid-template-areas:\n\t\t" . response . request request request request "\n    " . display . . console console . "\n    " . . . . . send . ";\n']);return C=function(){return e},e}var A=h.a.div(C()),I=h.a.button(q()),P=h.a.div(R()),z=h.a.div(k()),N=function(e){function t(e){var n;return Object(i.a)(this,t),(n=Object(s.a)(this,Object(l.a)(t).call(this,e))).consoleRef=a.a.createRef(),n.state={output:""},n}return Object(d.a)(t,e),Object(u.a)(t,[{key:"render",value:function(){var e=this;return a.a.createElement(A,{className:"App"},a.a.createElement(P,null," API Request "),a.a.createElement(z,null," API Response "),a.a.createElement(j,{ref:this.consoleRef}),a.a.createElement(y,{text:this.state.output}),a.a.createElement(I,{onClick:function(){e.setState({output:e.consoleRef.current.text})}}," Try API "))}}]),t}(a.a.Component);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));c.a.render(a.a.createElement(N,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})}},[[24,1,2]]]);
//# sourceMappingURL=main.bacd444c.chunk.js.map