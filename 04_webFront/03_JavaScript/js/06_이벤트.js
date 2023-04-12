//  인라인 이벤트 모델 확인하기
function test1(el){ // el == element == 전달 받은 요소
    el.style.backgroundColor = "black";
    el.style.color = "white";

}

// 고전 이벤트 모델 확인하기

//  아이디가 'test2a' 인 요소를 얻어오기
document.getElementById ('test2a').onclick;
// -> null 출력 (아직 click했을 때 동작할 함수(이벤트 핸들러) 가 없음)


// document.getElementById ('test2a').onclick = 함수
document.getElementById ('test2a').onclick = function /**이름*/(){

    // function(){} : 익명 함수(이름이 없는 함수)
    //               재사용 목적이 아닌
    //               특정 이벤트에 대한 기능을 만들때 주로 사용  

    alert("고전 이벤트 모델로 출력된 내용입니다");
}

// test2b의 클릭 이벤트 동작 제거(이벤트 제거)
document.getElementById("test2b").onclick = function(){

    document.getElementById("test2a").onclick = null;
    alert("이벤트를 제거하였습니다");
}

// 고전 이벤트 모델 단점 확인하기
// -> 한 요소에 여러 이벤트 핸들러(함수 [덧씌어짐])를 연결할 수 없음
// 왜?? 마지막으로 작성한 핸들러가 앞서 작성된 핸들러를 덮어 씌움

const c = document.getElementById("test2c"); // 버튼 요소를 얻어옴

// c 변수로 document.getElementById("test2c") 치환
c.onclick = function(){
    c.style.backgroundColor = 'pink'; // 배경색 핑크

}
c.onclick = function(){
    c.style.fontSize = '40px'; // 폰트 크기 40px
}


// 표준 이벤트 모델 확인하기
/**
    [표준 이벤트 모델 작성 방법]

    요소.addEventListener(감지할 이벤트, 이벤트 핸들러(이벤트가 발생했을 때의 동작));

    ex)
    test3.addEventListener("click", function()(익명함수){코드작성
    } );
 */


const test3 = document.getElementById("test3"); 

// test3의 클릭 시 width를 20px 만큼 증가
test3.addEventListener("click", function(){

    // 요소.clientWidth : 요소의 너비 (CSS로 지정된 값도 읽어옴, readonly)
    // 요소.clientHeight : 요소의 높이 (CSS로 지정된 값도 읽어옴,readonly)
    
    test3.style.width = test3.clientWidth + 20 +"px"; 
                            /** 현재 너비 width 카멜표기법 확인 */
});

test3.addEventListener("click", function(){
    // this : 이벤트가 발생한 요소 (여기서는 #test3)
    this.style.height = this.clientHeight + 20 +"px";
});

test3.addEventListener("click", function(e){
    

    // 이벤트 핸들러의 매개변수 e 또는 event 
    // -> 현재 발생한 이벤트 대한 모든 정보를 담고있는 객체
    // == 이벤트 객체

    // e.target : 이벤트가 발생한 현재 요소(대상) (==this)

    // console.log(e);

    const currentWidth = e.target.clientWidth;

    // 현재 너비가 500px을 초과하면 너비/높이를 200px로 초기화
    if(currentWidth > 500 -20){
        // 처음 화면을 console을 하면 220로 늘어나는 것이 아닌 200로 나오기 때문에
        // 500 이전의 480px == 500px로 조정
        e.target.style.width = "200px";
        e.target.style.height = "500px";
    }
});

// 간이 계산기 (표준 이벤트 모델)
// 요소자체를 가져옴
const num1 = document.getElementById("num1");
const num2 = document.getElementById("num2");
const result = document.getElementById("result");
// const 상수라서 js 내에서 똑같은 변수명을 사용할 수 없음

// 클래스가 op인 요소를 모두 찾아 배열로 반환
const opList = document.getElementsByClassName("op");
//                    getElements <-s을 꼭 붙이기(? : class 전체의 요소를 가져오기 때문에)
//  왜? getElementsByClassName("op") 사용한 이유 
//  class 반 겹칠수 있는 것  id(각자 고유의 번호) : 겹칠 수가 없음 --> 개개인이기 때문

// for of 구문(향상된 for문)
// -> 배열(Array), 유사 배열(HTMLCollection, NodeList,..)
// 위와 같이 배열 형태의 요소를 순차 접근하는 용도의 반복문
// for(let i = 0; i < opList.length; i++)

    for(let op of opList){
    // console.log(opList[i]);

    // 배열의 각 요소 == 각각의 버튼에 click 되었을 때의 동작을 추가
    op.addEventListener('click', function(e){
        result.innerText 
        = new Function("return " + Number(num1.value) 
                                + e.target.innerText  // e.target.innerText : 버튼에 쓰여져 있는 내용(이벤트 html) e: event
                                + Number(num2.value))();
    });

}

// // + 버튼 클릭 시
// plus.getElementById("plus").addEventListener("click", function(){
//     result.innerText = Number(test1.value) + Number(test2.value);
// }); 

// minus.getElementById("minus").addEventListener("click", function(){
//     // result.innerText = Number(test1.value) - Number(test2.value);
//     result.innerText
//     = new Function("return " + Number(test1.value) + e.target.innerText + Number(test2.value))();
// });

// multiply.getElementById("multiply").addEventListener("click", function(){
//     result.innerText = Number(test1.value) * Number(test2.value);
// });

// divide.getElementById("divide").addEventListener("click", function(){
//     result.innerText = Number(test1.value) / Number(test2.value);
// });

const box = document.getElementsByClassName("box");
const color = document.getElementsByClassName("color");

for(let i = 0; i < color.length; i++){ // i == 0~4
    color[i].addEventListener("keyup", function(){ // keyup(손을 땔때) 이벤트가 발생 
        box[i].style.backgroundColor = color[i].value; // box[i]번째와 color[i]가 같을 때 배경색을 변경하겠다.
    });
}

// for(let color of color){
//     color.addEventListener("keyup", function(e){ 
//         // previousElementSibling : 이전 형제 요소
//         e.target.previousElementSibling.style.backgroundColor = e.target.value;
//     })
// }

// a태그 기본 이벤트 제거
document.getElementById("moveGoogle").addEventListener("click", function(e){

    // e: 이벤트 객체
    e.preventDefault();

    // Default : 기본 / 기본값
    // prevent 
});

// form태그 기본 이벤트 제거 1
// submit 버튼을 없애고
// 일반 button이 클릭 되었을 때 조건이 맞으면 submit 하게 만들기
/*
document.getElementById("btn").addEventListener("click", function(){

    // 작성된 아이디, 비밀번호 얻어오기
    const id = document.querySelector("[name='id']").value;
    const pw = document.querySelector("[name='pw']").value;

    if(id == 'user01' && pw == 'pass01'){
        // 아디, 비번이 일치할 때 form 태그 제출

        // submit() : form태그 제출
        document.testForm.submit();
    }

});
*/

// form태그 기본 이벤트 제거 방법2 (인라인 이벤트 모델)
function fncheck(){
    
    // 작성된 아이디, 비밀번호 얻어오기
    const id = document.querySelector("[name='id']").value;
    const pw = document.querySelector("[name='pw']").value;

    if(id == 'user01' && pw == 'pass01'){
        // 아디, 비번이 일치할 때 form 태그 제출

       return true; // true를 반환해서 제출 수행
    }

    return false; // false를 반환해서 제출 막음

}

// form태그 기본 이벤트 제거 방법 3 (표준 이벤트 모델)
// -> name이 testForm인 form태그에서 submit 이벤트가 발생 했을 때
document.testForm.addEventListener("submit", function(e){
    
    
    // e => event 객체
    e.preventDefault(); // 기본 이벤트 막기
});