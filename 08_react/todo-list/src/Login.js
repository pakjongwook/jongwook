import React, { useState, useContext } from 'react';  // useContext 전역변수
import { TodoListContext } from './App'; // App.js 에서 ToListContext을 가져 쓰겠다.


const LoginComponent = () => {
    // 전역변수 Context를 사용
    const { setTodoList, setLoginMember, loginMember } = useContext(TodoListContext)

    const [id, setId] = useState('');
    const [pw, setPw] = useState('');

    const login = () => {

        fetch('/login', {
            method: 'POST',
            headers: {
                // 전달되는 데이터 타입
                'Content-Type': 'application/json',

                // 응답 데이터 타입
                'Accpt': 'application/json'
            },
            body: JSON.stringify({
                id: id,
                pw: pw
            })
        })

            .then(resp => resp.json())
            .then(map => {
                console.log(map);

                if(map.loginMember === null){
                    alert('아이디 또는 비밀번호가 일치하지 않습니다')
                    return;
                }

                // 로그인 성공 시
                setLoginMember(map.loginMember);
                setTodoList(map.todoList);

                setId('');
                setPw('');


            })
    };

    // 로그아웃
    const logout = () => { 
        setLoginMember(null);
    };

    return (
        <div className="login-container">
            <table>
                <tbody>
                    <tr>
                        <th>ID</th>
                        <td>
                            <input type="text" onChange={e => setId(e.target.value)} value={id} />
                        </td>
                    </tr>

                    <tr>
                        <th>PW</th>
                        <td>
                            <input type="password" onChange={e => setPw(e.target.value)} value={pw} />
                        </td>
                        <td>
                            <button onClick={login} >Login</button>
                        </td>
                    </tr>
                </tbody>
            </table>

            {loginMember && ( //&& 왼쪽이 참이라면 로그아웃하겠다.
                <button onClick={logout}>로그아웃</button>
            )}
        </div>


    );

}

export default LoginComponent;
