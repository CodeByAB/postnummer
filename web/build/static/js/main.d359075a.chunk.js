(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{23:function(e,n,t){e.exports=t.p+"static/media/internet.3edf1c69.svg"},25:function(e,n,t){e.exports=t(44)},30:function(e,n,t){},44:function(e,n,t){"use strict";t.r(n);var r=t(0),a=t.n(r),o=t(9),i=t.n(o),c=(t(30),t(3)),s=t(4),u=t(6),l=t(5),d=t(7),p=t(1),f=t(2),h=t(20),m=t.n(h);t(39),t(41);function g(){var e=Object(p.a)(["\n  grid-area: console;\n  border-radius: 10px;\n\n"]);return g=function(){return e},e}var w=f.a.div(g()),b='\n{\n  "postnummer": 135551\n}\n',v=function(e){function n(e){var t;return Object(c.a)(this,n),(t=Object(u.a)(this,Object(l.a)(n).call(this,e))).monitor=console.log,t.text=b,t}return Object(d.a)(n,e),Object(s.a)(n,[{key:"render",value:function(){var e=this;return a.a.createElement(w,{className:"console"},a.a.createElement(m.a,{ref:this.editorRef,mode:"json",theme:"clouds_midnight",height:"100%",widht:"100%",value:this.text,defaultValue:b,onChange:function(n){return e.text=n},name:"Console Editor",editorProps:{$blockScrolling:!0}}))}}]),n}(a.a.Component);function j(){var e=Object(p.a)(["\n\tdisplay: flex;\n\tbackground-color: rgba(25, 25, 25, 1);\n  color: white;\n\twidth: 100%;\n\theight: auto;\n  padding: 10px;\n  white-space: pre-wrap;       /* Since CSS 2.1 */\n  white-space: -moz-pre-wrap;  /* Mozilla, since 1999 */\n  white-space: -pre-wrap;      /* Opera 4-6 */\n  white-space: -o-pre-wrap;    /* Opera 7 */\n  word-wrap: break-word;       \n  border-radius: 10px;\n"]);return j=function(){return e},e}function x(){var e=Object(p.a)(["\n\tdisplay: flex;\n  grid-area: display;\n\tplace-item: center stretch;\n"]);return x=function(){return e},e}var y=f.a.div(x()),O=f.a.pre(j()),k=function(e){function n(){return Object(c.a)(this,n),Object(u.a)(this,Object(l.a)(n).apply(this,arguments))}return Object(d.a)(n,e),Object(s.a)(n,[{key:"render",value:function(){return a.a.createElement(y,{className:"display"},a.a.createElement(O,null,this.props.text||"No Requests has been made"))}}]),n}(a.a.Component),E=t(23),R=t.n(E);function C(){var e=Object(p.a)(["\n  grid-area: response;\n  font-size: 25pt;\n  text-align: center;\n  color: white;\n"]);return C=function(){return e},e}function S(){var e=Object(p.a)(["\n  grid-area: request;\n  font-size: 25pt;\n  text-align: center;\n  color: white;\n"]);return S=function(){return e},e}function q(){var e=Object(p.a)(["\n  grid-area: send;\n  height: 40%;\n  width: 40%;\n  place-self: center;\n  margin-bottom: 2%;\n\n\n  :hover {\n    cursor: pointer;\n  }\n\n  display: flex;\n  flex-direction: row;\n  justify-content: center;\n  fontsize: 10;\n"]);return q=function(){return e},e}function z(){var e=Object(p.a)(['\n  height: auto;\n  width: 100%;\n  display: grid;\n\n\n  // Meaning anything above a tablet get this layout\n  @media (min-width: 769px) {\n    grid-template-columns: 1.5fr 3fr 1fr 3fr 1.5fr;\n    grid-template-rows: 1fr 7fr 2fr;\n\n\n    grid-column-gap: 5px;\n    grid-row-gap: 5px;\n\n    grid-template-areas:\n      " . request  . response  . "\n      " . console  .  display  . "\n      " .  send    .    .      . ";\n  }\n\n  // Layout for anything below & including tablet.. we currently don\'t distinguish between tablet & phone\n  // But for our tiny UI i don\'t believe it makes much of a difference.. and we both suck at UX design\n  // So i don\'t think that is what anyone will notice anyway! :) \n  @media (max-width: 768px) {\n    grid-template-columns: 1fr 3fr 1fr;\n    grid-template-rows: 1fr 4fr 1fr 1fr 4fr;\n\n    grid-column-gap: 5px;\n    grid-row-gap: 5px;\n\n    grid-template-areas:\n      " . request  .  "\n      " . console  .  "\n      " . send     .  "\n      " . response .  "\n      " . display  .  ";\n  }\n  \n']);return z=function(){return e},e}var I=f.a.div(z()),N=f.a.div(q()),A=f.a.div(S()),B=f.a.div(C()),P=function(e){function n(e){var t;return Object(c.a)(this,n),(t=Object(u.a)(this,Object(l.a)(n).call(this,e))).consoleRef=a.a.createRef(),t.state={output:""},t}return Object(d.a)(n,e),Object(s.a)(n,[{key:"render",value:function(){var e=this;return a.a.createElement(I,{className:"App"},a.a.createElement(A,null," API Request "),a.a.createElement(B,null," API Response "),a.a.createElement(v,{ref:this.consoleRef}),a.a.createElement(k,{text:this.state.output}),a.a.createElement(N,{onClick:function(){e.setState({output:e.consoleRef.current.text})}},a.a.createElement("img",{alt:"button-icon",src:R.a})))}}]),n}(a.a.Component);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));i.a.render(a.a.createElement(P,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})}},[[25,1,2]]]);
//# sourceMappingURL=main.d359075a.chunk.js.map