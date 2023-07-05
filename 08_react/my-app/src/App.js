import './App.css';

// compontents 폴더의 Exam1.js를 가져와서 사용
// 사용할 때 이름을 Ex1으로 지정
import Exam1 from './components/Exam1'; /* 확장자.js 생략 */

import Ex2 from './components/Exam2';

import PropsEx from './components/R01_props1';

import State1 from './components/R02_state1'; // export 한것을 가져와서 여기서 import 하겠다. , 요소이름은 대문자
import State2 from './components/R03_state2';
import State3 from './components/R04_state3';
import TodoList1 from './components/R05_todolist';
import ContextApi from './components/R06_context_api'; // ContextApi 이름

function App() { // 부모
  // react의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다
  // -> 여러 요소를 반환하고싶을 떄는 부모 요소로 묶어준다!
  return (

    /* fragment(<> </>) : 반환되는 요소를 감쌀 때 사용, 해석 X */
    <>
      {/* jsx(js 에 html 을 쓸수 있는 코드) 주석 */}
      <h1>hello world!!</h1>
      <div>와 리엑트</div>

      {/*<Exam1 />*/} {/* App은 부모 / exam1은 components (자식) /  위의 import 구문 ==> 여기로 render코드가 반환됨 */}
      
       {/*<Ex2 />*/}

 {/*       <PropsEx name={'홍범도 장군'}/>
       <PropsEx name={'안중근 장군'}/>
       <PropsEx name={'김좌진 장군'}/> */}

       {/* R02_state1 */}
       {/* <State1/>  요소이름은 무조건 대문자 */}

       {/* R03_state2 */} {/* 자식 */}
       {/* <State2 init={100}/> 전체가 리렌더링 하는것이 아닌 상태가 변한 부분만 리렌더링함(<h3>count</h3>) */}

       {/* R04_state3 */}
       {/* <hr/> */}
       {/* <State3/> */}

       {/* R05_todolist1 */}
       {/* <TodoList1/> */}

       {/* R06_context_api */}
       <ContextApi/>
    </>
  );
}

export default App;
