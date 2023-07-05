import React, { useState,createContext   } from 'react';
import './App.css';

import SignupContainer from './Signup'; // . 현재폴더(같은위치)

function App() {
  
  // 회원가입, 로그인, 회원의 TOdo List 출력/추가/제거
  
  const [signupView, setsignupView] = useState(false);

  return (
    <>
      <button onClick={ ()=>{setsignupView(!signupView)} }> {/* setsignupView을 바꾸겠다 => true로 바꾸겠다 */}
        
        { signupView ? ('회원 가입 닫기') : ('회원 가입 열기')} {/* 버튼 안에다가 내용출력하기전에 자바스크립트 실행 */}

      </button>

      <div className='signup-wrapper'>
        {/* {signupView가 true인 경우에만 회원 가입 컴포넌트 렌더링 } */}
        {/* 조건식 && true인 경우 */}
        {signupView === true && (<SignupContainer/>)}
      </div>

    </>
        
  );
}

export default App;