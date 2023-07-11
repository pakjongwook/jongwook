import React, { useState,createContext   } from 'react';
import './App.css';

import SignupContainer from './Signup'; // . 현재폴더(같은위치)
import Login from './Login'; 
import TodoList from './TodoList';


export const TodoListContext = createContext(); // 전역변수 생성 전역변수 값이 없어서


function App() {
  
  // 회원가입, 로그인, 회원의 TOdo List 출력/추가/제거
  
  const [signupView, setsignupView] = useState(false);

  // 로그인한 회원 정보 저장
  const [loginMember, setLoginMember] = useState(null); // 로그인 안하면 초기값 null

  // 로그인한 회원의 todo-list 를 저장
  const [todoList, setTodoList] = useState([]); 
  

  return (
    <TodoListContext.Provider value={ {setTodoList, setLoginMember,loginMember, todoList} }> {/*** value 소문자 *** setTodoList 상태를 바꾸는 것 / 전역변수의 setTodoList, setLoginMember,loginMember, todoList(위 선언한것) 제공에서 TodoList.js의 변수 export  */} 
      <button onClick={ ()=>{setsignupView(!signupView)} }> {/* setsignupView을 바꾸겠다 => true로 바꾸겠다 */}
        
        { signupView ? ('회원 가입 닫기') : ('회원 가입 열기')} {/* 버튼 안에다가 내용출력하기전에 자바스크립트 실행 */}

      </button>

      <div className='signup-wrapper'>
        {/* {signupView가 true인 경우에만 회원 가입 컴포넌트 렌더링 } */}
        {/* 조건식 && true인 경우 */}
        {signupView === true && (<SignupContainer/>)}
      </div>


      <h1>Todo List</h1>
      <Login />

      <hr/>

      {/* 로그인 되어 있을 때만 Todo-List 출력 */}
      {loginMember && (<TodoList/>)}  {/* 대문자 */}

    </TodoListContext.Provider>
        
  );
}

export default App;
