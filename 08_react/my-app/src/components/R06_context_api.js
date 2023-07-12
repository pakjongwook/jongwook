import React, { useState, useContext } from 'react'; // 상태 변화하는 것을 관리하겠다./ useContext = context을 이용하겠다.
import UserContext from './contexts/UserContext';

const ChildChild = () => {
    const {user, temp} = useContext(UserContext);

    console.log(user);
    return (
        <p>자식의 자식</p>
    );
}



// Components 이름은 대문자 proflie 의 자식
const User = () => {

    // useContext(context 명) : 지정된 Context를 사용
    //      -> 부모 컴포넌트에서 제공한 값을 꺼내 쓸 수 있다 

    const { user, temp } = useContext(UserContext); // user, temp  
    // UserContext에서 user를 꺼내서 변수 user에 저장
    // UserContext에서 temp를 꺼내서 변수 temp에 저장

    console.log(user);
    console.log(temp);

    return (
        <ul>
            <ChildChild/> {/* 태그 */}
            <li>{user.name}</li>
            <li>{user.email}</li>
        </ul>

    );
}

// ** 부모 ** 감싸고 있는 것
const Profile = () => {


    // useState 이용할 때 변수에 함수 대입
    const [user, setUser] = useState(null);

    const print = () => {
        setUser({ name: '김미영', email: 'my-kim@kh.or.kr' }); // 위에있는 state
    }

    const temp = '임시 변수';


    return (

        /* UserContext가 감싸고 있는 자식 컴포넌트(User)에게 
            context API를 이용해서 user를 제공
        */
        <UserContext.Provider value={{ user, temp }}> {/* import 한 UserContext 전역변수 */}
            <div>
                {/* 삼항 연산자를 이용한 컴포넌트 렌더링 제어(조건부 렌더링) */}
                {user != null ? (
                    <>
                        <User /> {/* User 컴포넌트 이 위치에 출력 => profile 먼저출력  */} 
                        <button onClick={()=>{setUser(null)}}>개인 정보 숨기기</button>
                    </>

                ) : (
                    
                    <button onClick={print}>개인 정보 출력</button>

                ) } {/* {}중괄호써야지 JS을 쓸 수 있음 */}
                {/* user => useState */}  



            

            </div>
        </UserContext.Provider>
    );

}

export default Profile; // 외부에서 수입하면 기본값으로 Profile 내보내짐


