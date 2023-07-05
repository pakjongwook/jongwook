// 컴포넌트 파일 대문자
import React, { useState } from 'react';

const SignupContainer = () => {

    const [id,setId] = useState('');
    const [pw,setPw] = useState('');
    const [pwCheck,setPwCheck] = useState('');
    const [name,setName] = useState('');
    const [result,setResult] = useState(''); // (useState) result 가 변하면 이 컴포넌트(result)을 리렌더링 다시 하겠다


    // 회원 가입 함수
    const signup = () => {

        // 1. 비밀번호가 일치하지 않으면 (pw !== pwCheck)
        // '비밀번호가 일치하지 않습니다' alert로 출력 후 return

        if(pw !== pwCheck) { // 위에 선언되어있는 useState
            alert('비밀번호가 일치하지 않습니다.'); // ; 작성
            return;
        }

        // 2. id === 'user01', pw === 'pass01'
        // 맞으면 result에 '회원 가입 성공' 출력
        // + 모든 입력칸 (input) 내용 삭제

        if(id === 'user01' && pw === 'pass01'){
            setResult('회원 가입 성공');
            setId(''); // Id 변수 값에 '' 대입해라 useState 상태 값이 변하면 리덴더링 하겠다. => label 의 value 속성 값이 초기값(id)으로 되어있어서 '' 으로 대입
            setPw('');
            setPwCheck('');
            setName(''); 
        } else{
            
        // 아니면 result에
        // '아이디 또는 비밀번호가 일치하지 않습니다' 출력
            setResult ('아이디 또는 비밀번호가 일치하지 않습니다'); // h3 태그 result
        }




    }

    return(
        <div className="signup-container">

            <label>   
                ID :
                <input type="text"
                    onChange={ e => {setId(e.target.value)}} // 값이 변했을 때,  e 발생할 객체 , 위에 있는 값을 변경
                    value={id} // 세팅된 값을 여기에 세팅 (초기값)
                />
            </label>


            <label>   
                PW :
                <input type="password"
                    onChange={ e => {setPw(e.target.value)}} // 값이 변했을 때,  e 발생할 객체 , 위에 있는 값을 변경
                    value={pw} // 세팅된 값을 여기에 세팅
                />
            </label>


            <label>   
                PW CHECK :
                <input type="password"
                    onChange={ e => {setPwCheck(e.target.value)}} // 값이 변했을 때,  e 발생할 객체 , 위에 있는 값을 변경
                    value={pwCheck} // 세팅된 값을 여기에 세팅
                />
            </label>

            <label>   
                NAME :
                <input type="text"
                    onChange={ e => {setName(e.target.value)}} // 값이 변했을 때,  e 발생할 객체 , 위에 있는 값을 변경
                    value={name} // 세팅된 값을 여기에 세팅
                />
            </label>

            <button onClick={signup}>가입하기</button>

            <hr/>

            <h3>{result}</h3>

        </div>


    );

};



export default SignupContainer;