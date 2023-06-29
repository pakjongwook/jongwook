import './App.css';

// compontents 폴더의 Exam1.js를 가져와서 사용
// 사용할 때 이름을 Ex1으로 지정
import Exam1 from './components/Exam1';

import Ex2 from './components/Exam2';

function App() {
  // react의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다
  // -> 여러 요소를 반환하고싶을 떄는 부모 요소로 묶어준다!
  return (

    /* fragment(<> </>) : 반환되는 요소를 감쌀 때 사용, 해석 X */
    <>
      {/* jsx(js 에 html 을 쓸수 있는 코드) 주석 */}
      <h1>hello world!!</h1>
      <div>와 리엑트</div>

      <Exam1 />
      
      <Ex2 />
    </>
  );
}

export default App;
