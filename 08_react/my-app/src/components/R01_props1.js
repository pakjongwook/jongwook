import React from "react"; // react 은 node_modules 패키지

// props : 부모 컴포넌트가 자식 컴포넌트에게 
// 데이터 전달 시 사용하는 객체
// *** props는 자식 -> 부모 데이터 전달은 불가능 **

// 해석 : function 위치 부터(자바스크립트)

// 변수 해석 : 위 -> 아래 

const ChildComponent = (props) => { // app.js 로 보내지지않음 => export default PropsEx 내보내기 때문에 => 같은 js 끼리 내보낼 수 있음

    return (
        <>
            <ul>
                <li>이름 : {props.name}</li>
                <li>나이 : {props.age}</li>
            </ul>
        </>

    );

}

const MenuPrint = (props) => {
    return (
        <h4>김밥 : {props.김밥} , 떡볶이 : {props.떡볶이}</h4>

    );
}


// 함수를 변수처럼 원래는 function 함수 {}
const PropsEx = (props) => {
    // props 매개변수 : 부모로 부터 전달 받은 값이 담겨 있는 객체

    console.log(props);
    console.log(props.name);

    const menu = {'김밥':3000, '떡볶이':4000};

    return (
        <>
            <h1>{props.name}</h1>

            <ChildComponent name={props.name} age={props.name === '홍범도 장군' ? 155 : 158 } />

            <MenuPrint {...menu} />
        </>
    );


}


export default PropsEx; // PropsEx의 return 구문이 내보내짐. ex)  return <h1> props </h1> => app.js 로 내보내짐