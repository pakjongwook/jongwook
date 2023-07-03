import React,{useState} from "react";

const Id = ({handler}) => {

    // prpps로 전달한 값 중 key가 handler인 요소의 value 반환
   // console.log(handler); // 함수 역할 : 부모쪽의 있는 id값 ,pw 값 변경하는 역할

    return(
        <>
            <div className="wrapper">
                <label htmlFor="id">ID : </label> {/* html의있는 For 속성 */}
                <input type="text" id="id" onChange={handler}  /> {/* onChange={전달받은 함수
                } */}
            </div>
        
        </>

    );
};


const Pw = ({handler}) => {

    return(
        <>
            <div className="wrapper">
                <label htmlFor="pw">PW : </label> {/* label 있는 For 속성 */}
                <input type="password" id="pw" onChange={handler} />
            </div>
        
        </>

    );
};

// 상태 끌어올리기
const StateLiftingUp = () => {

    const [id, setId] = useState('');
    const [pw, setPw] = useState('');


    const idHandler = (e) => { // id값 변경 함수
        setId(e.target.value);
    }

    const pwHandler = (e) => {  // pw값 변경 함수
        setPw(e.target.value);
    }

    console.log("id : " + id );
    console.log("pw : " + pw);
    
    return(
        <>
            <Id handler={idHandler} /> {/* components / StateLiftingUp의 자식 Props의 값을 넣을 수 있어도 변하는 값은 넣을 수 없다*/}
            <Pw handler={pwHandler} /> {/* 부모가 자식한테 값을 전달 */}

            <div className="wrapper">
                <button disabled={id.length === 0 || pw.length === 0}>Login</button>
            </div>
        </>

    );

}

export default StateLiftingUp;


