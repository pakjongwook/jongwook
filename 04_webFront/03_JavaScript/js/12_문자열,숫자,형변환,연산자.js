// 문자열 관련 함수      css 선택자
document.querySelector("#btn1").addEventListener("click",() => {
    // getElementById("btn1") **아무거나 선택해도됨**

    // 문서에서 요소의 아이디 첫번째가 클릭이 되었을 때 어떤 동작을 하겠다.

    // 문자열.substring(시작인덱스, 종료인덱스(미포함))
    // - 시작 이상 종료 미만 만큼의 문자열을 잘라서 반환
    
    const str1 = "Hello world!";
    console.log(str1.substring(0, 5)); // hello
    console.log(str1.substring(6, 11)); // world);

    // 문자열.split("구분자"[, 최대 분할 개수])
    // - 문자열을 구분자를 기주으로 나누어 배열 형태로 반환
    const str2 = "김치찌개,샌드위치,햄버거,떡볶이,김밥,마라탕,초밥";

    const arr2 = str2.split(",",5);
    console.log(arr2);

    for(let menu of arr2) {
        console.log(menu);
    }

});


// 숫자 관련 함수
document.querySelector("#btn2").addEventListener("click",function(e){


    // infinity 리터럴 확인
    console.log( 5 / 0 );
    // java : ArithmericException (산술적 예외)
    // javascript : Infinity 

    // NaN 리터럴 확인
    console.log("abc" * 100);

    if(5/0 == Infinity){
        console.log("0으로 나눌 수 없습니다.");
    }

    // isNaN(연산/값) : 연산/값의 결과가 NaN이면 true 반환
    if(isNaN("abc" * 100 )){
        console.log("숫자만 * 연산을 할 수 있습니다");
    }

    /** Math 자바스크립트 내장 객체 */
    console.log(Math.ceil(10.5)); // 올림, 11
    console.log(Math.floor(10.5)); // 내림, 10
    console.log(Math.trunc(10.5)); // 버림, 10
    console.log(Math.round(10.5)); // 반올림, 11

    // 1.25를 소숫점 둘째자리에 반올림 --> 1.3
    console.log(Math.round(1.25 * 10) / 10);
                        // 12.5--> 13.0 --> 1.3

    // 부동 소수점(부정확, 용량 적음)
    //  -> 고정 소수점 (정확, 용량 큼) 변경

    // 숫자.toFixed(보여질 소수 자릿수)
    // - 주어진 숫자를 매개변수에 작성된 숫자 만큼의
    //   소수점 자릿수로 표현될 수 있도록
    //   바로 다음 소수 자리에서 반올림해서 문자열로 반환
    console.log( (3.456).toFixed(2) );
    console.log( (3.456).toFixed(1) );
    console.log( (3.456).toFixed(0) );

    // Math.random() -> 0.0 <= x <= 1.0 실수 반환
    // 버튼 클릭 시 마다 버튼 배경색 랜덤하게 변경

    const r = Math.floor(Math.random() *256) // 0 <= x < 256
    const g = Math.floor(Math.random() *256) // 0 <= x < 256
    const b = Math.floor(Math.random() *256) // 0 <= x < 256
    // Math.random 여기서 ramdom 지우기

    e.target.style.backgroundColor = `rgb(${r},${g},${b})`;
    
});

document.querySelector("#btn3").addEventListener("click",()=>{

    const num = "10";

    console.log(parseInt(num));

    console.log(parseFloat(num));

    console.log(Number(num));
});






