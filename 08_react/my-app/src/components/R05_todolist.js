import React, { useState } from 'react';


// useState 복습
const InputName = () => { // 앞에는 대문자

    // state : 컴포넌트의 상태
    // useState : 컴포넌트의 상태를 관리 -> state 변화가 감지되면 컴포넌트를 리렌더링


    const [name, setName] = useState(''); 
    // name : 변수명
    // setName : name 변수의 setter // setName 선언해야지 return 구문의 18줄의 setName을 쓸 수 있음
    // useState('') : name 변수에 대입되는 초기값을 ''(빈칸)으로 지정

    return (
        <div>
            <p>이름을 입력하세요</p>
            <input type='text' onChange={e => setName(e.target.value) }/>  {/* 매개변수 하나면 e 의 () 생략 / return 구문의 하나만 보내면 {} 중괄호 생략 */}
            <h3>{name}</h3>

        </div>

    );
};





const ToList1 = () => {
    
    // 할 일을 저장할 변수
    // -> 상태가 변하면 컴포넌트(TodoList1)을 리렌더링
    const [todos , setTodos] = useState([
        {text : '프로젝트', completed : false}, // 객체 배열
        {text : '점심 먹' , completed : false}, // 배열들을 todos 에 저장
    ]);

    console.log(todos);

    
    // 할 일 입력 컴포넌트  
    const Inputtodo = () =>{ // 지역변수 여기안에서만 쓸 수 있음
        const [inputText, setInputText] = useState('');  // 처음 값을 대입할게 없으니까 '' 빈칸 씀 //  [] 배열 {key : a} 객체

        // 버튼 클릭 시 할일 추가
        const addtodo = () => {
            const newTodo = {text : inputText , completed : false}
                                    /* setInputText 추가 */

            // todos 에 newTodo를 추가한 객체배열 newTodos
            const newTodos = [...todos, newTodo]; // 전개연산자

            // 새로운 객체배열 newTodos를 todos에 대입 
            // -> 상태 변화 인식 -> 리렌더링 진행
            setTodos(newTodos); 
            setInputText(''); // 입력된 할 일 삭제
        };

        return(
            <div>
                <h4>할 일 추가</h4>
                <input type='text' onChange={ e => setInputText(e.target.value)}/> {/* setInputText의 추가  */}
                <button onClick={addtodo}>추가하기</button> {/* 추가하기 버튼을 클릭할 때마다 addtodo 할일 추가하겠다. */}
            </div>

        );

};

// 체크박스 값 변경 시
const todoChange = index => { // 매개변수 하나면 () 생략
    const newTodos = [...todos]; // todos (전개연산자)를 풀어서 새로운 배열 생성 
                                // 전개 연산자를 이용한 배열 깊은 복사

    // boolean값 반대로 변경해서 대입
    newTodos[index].completed = !newTodos[index].completed

    setTodos(newTodos);
}



    return (
        <>
            <InputName/>
            <hr/>

            <h1>TodoList1</h1>

            {/* 입력 */}
            <Inputtodo/>

            {/* 할 일 목록 */}
            {/* 배열.map)( (배열요소.인덱스) => { return 값; } ) 
                -> 기존 배열을 이용해서 새로운 배열을 만드는 함수
                -> 새로운 배열의 요소는 map에서 return되는 값으로 이루어짐
            */}

            <ul>
                {todos.map( (todo, index ) => { /* todo(item todos에 하나씩 꺼내기) */
                    return (
                        /* key 속성 : 배열(list) 출력 시 요소를 구분하는 key 값 */
                        <li key={index}>
                            <input type='checkbox'
                                    checked={todo.completed} /* true : check되고 false : check 안됨  완료 된것은 check 되고 안되면 check안되고*/
                                    onChange={ ()=>{ todoChange(index) } }
                            />

                            <span className={todo.completed ? 'completed' : ''}>
                                {todo.text}
                            </span> 

                        </li>


                    );

                } )} {/* JS을 쓰겠다. */}
            </ul>
        </>

    );
};


// 외부에서 해당 파일 import 시 ToList1 함수를 내보내는 기본값으로 지정
export default ToList1; 

