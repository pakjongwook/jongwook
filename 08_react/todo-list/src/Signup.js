// 컴포넌트 파일 대문자
import React, { useState } from 'react';

const SignupContainer = () => {

    const [id,setId] = useState('');
    const [pw,setPw] = useState('');
    const [pwCheck,setPwCheck] = useState('');
    const [name,setName] = useState('');
    const [result,setResult] = useState(''); // (useState) result 가 변하면 이 컴포넌트(result)을 리렌더링 다시 하겠다




    // 아이디 중복검사
    const[idValidation, setIdValidation] = useState(false);
    // false : 사용 불가능 
    // true : 사용 가능
    
    const idCheck = (inputId) => {
        // inputId : 입력한 아이디
        setId(inputId); // id 변수에 입력받은 아이디 대입

        // 4글자 미만 검사 X
        if(inputId.trim().length < 4){ 
            setIdValidation(false);
            return;
        }

        fetch("/idCheck?id=" + inputId)
        .then(resp => resp.text())
        .then(result => {
            console.log(`result : ${result}`); // 백틱으로 변수를 문자열

            console.log(typeof result); // result 가 String 아무리 int 로 넘겨도 string 으로 바뀜
            //응답이 String 형태

            // number 타입으로 parsing
            if(Number(result) === 0){ // 중복 X -> 사용 가능 / === type이랑 값이 모두 같다/  == 값 만 비교 / 1) == 쓰거나 2) Number(result) === 0
                setIdValidation(true);

            }else{ // 중복 O -> 사용 불가능
                setIdValidation(false);
            }
        })
        .catch(e => console.log(e));

    }


    // 회원 가입 함수
    const signup = () => {

        // 아이디가 사용 불가인 경우(짧거나 중복)
        if(!idValidation){ // ! 사용불가능
            alert('아이디를 다시 입력해주세요')
            return;
        }

        // 1. 비밀번호가 일치하지 않으면 (pw !== pwCheck)
        // '비밀번호가 일치하지 않습니다' alert로 출력 후 return

        if(pw !== pwCheck) { // 위에 선언되어있는 useState
            alert('비밀번호가 일치하지 않습니다.'); // ; 작성
            return;
        }

        
        // ******** 회원 가입 요청(비동기 ,POST) *** 
        fetch("/signup",{
            method: 'POST',
            headers : {"Content-Type": "application/json"},
            body : JSON.stringify({
                id : id,
                pw : pw,
                name : name // k : 변수명
            }) // stringify : 자바스크립트 객체을 JSON 모양으로 바꾸는 것
        })
        .then(resp => resp.text()) // 0 or 1
        .then(result => {
            
            // 2. id === 'user01', pw === 'pass01'
            // 맞으면 result에 '회원 가입 성공' 출력
            // + 모든 입력칸 (input) 내용 삭제
    
            if(result > 0 ){
                setResult('회원 가입 성공');
                setId(''); // Id 변수 값에 '' 대입해라 useState 상태 값이 변하면 리덴더링 하겠다. => label 의 value 속성 값이 초기값(id)으로 되어있어서 '' 으로 대입
                setPw('');
                setPwCheck('');
                setName(''); 
            } else{
                
            // 아니면 result에
            // '회원 가입 실패' 출력
                setResult ('회원 가입 실패'); // h3 태그 result
            }

        }) // 파싱된 데이터를 result 부르고 성공했을 때         
        .catch(e => console.log(e));
        
        
        
        
        
        
        
        
        
        
        
        



    }

    return( // 화면에 보이게 하는것
        <div className="signup-container">

            <label>   
                ID :
                <input type="text"
                    onChange={ e => idCheck(e.target.value)}
                        // {setId(e.target.value)}} // 값이 변했을 때,  e 발생할 객체 , 위에 있는 값을 변경
                    value={id} // 세팅된 값을 여기에 세팅 (초기값)
                    className={idValidation ? '': 'id-error'}
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