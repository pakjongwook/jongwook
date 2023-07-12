import React, { useState } from 'react';

const InputPrint = () => {

    // 입력용 변수
    const [inputText, setInputText] = useState('');

    // 출력용 변수
    const [inputText2, setInputText2] = useState('');

    const handleClick = () => {
        setInputText2(inputText);
    };


    return (
        <>
            {/* 이벤트가 발생한 요소의 값을  inputText에 저장 */}
            <input type='text' onChange={e => setInputText(e.target.value)}></input>
            <button onClick={handleClick} className='style'>보내기</button>
            <div className='wrapper2'><h2>{inputText2}</h2></div>
        </>
    );

    /* 해당 코드는 React 컴포넌트인 InputPrint를 정의하는 코드입니다. 
    InputPrint 컴포넌트는 두 개의 상태 변수 inputText와 inputText2를 사용하며, 
    초기값은 빈 문자열('')입니다.

handleClick 함수는 버튼 클릭 시 호출되는 함수로, 
inputText 상태 값을 inputText2 상태 변수에 설정합니다.

return 구문에서는 JSX 문법을 사용하여 렌더링할 내용을 정의합니다. 
입력 필드(input)는 사용자의 입력이 변경될 때마다 inputText 상태를 업데이트(change)합니다. 
버튼(button)은 클릭 시 handleClick 함수가 호출되도록 설정되어 있습니다. 
wrapper2 클래스를 가진 div 요소는 inputText2 값을 표시하는 h2 요소를 포함합니다.

마지막으로 InputPrint 컴포넌트를 내보내기 위해 export default InputPrint; 구문이 포함되어 있습니다. 
이렇게 내보내진 컴포넌트는 다른 파일에서 import하여 사용할 수 있습니다. */


};

export default InputPrint;