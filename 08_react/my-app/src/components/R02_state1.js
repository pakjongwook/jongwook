import React, {useState} from "react";

const InputTest = () => { // componets 나타내는 함수 대문자

    // 리엑트는 컴포넌트의 상태가 변할 때 마다 리렌더링을 수행 함

    const [inputValue, setInputValue] =  useState("초기값"); // inputValue ='초기값'
    // 1. 변수(값이 변할수 있는것)  2. 함수
    // inputValue = 값을 저장하는 변수
    // setInputValue : inputValue 의 값을 대입하는 setter 역할의 함수
    
    const changeInputValue = (e) => {

        console.log(e.target.value); // 이벤트가 발생한 요소(value)가 발생
        setInputValue(e.target.value); // setInputValue (매개변수)에 값을 전달 
    }


    return (

        // 첫 렌더링 : value = "초기값"
        // input의 값을 변경(컴포넌트의 상태 변화 -> 리렌더링 진행)
        // 1) onChange(값이 변했을 때 )
        // -> changeInputValue 함수가 실행되면서
        //    inputValue에 e.target.value(변환된 값) 대입

        // 2) 컴포넌트의 상태 변화 -> 리렌더링 진행

        // 리렌더링 -> value = 변경된 inputValue의 값
        

        <input type="text"  value={inputValue} 
        /*  onChange={ (e) => {setInputValue(e.target.value ) } } />*/ // 여기서 입력하면 값이 변화가 없다 ? => React : components 화면 뿌려주는 것 : 컴포넌트 리렌더링(코드읽어서 해석) 때문에 => commponets 다시 만들어야함 / 
        onChange={ changeInputValue } />  
                    // 값이 변할때마다 setInputValue  값이 호출
    );

}; // 함수를 변수에 대입하는 모양

export default InputTest; // 외부에 누군가 수입할려고 하면 기본값으로 내보내겠다.