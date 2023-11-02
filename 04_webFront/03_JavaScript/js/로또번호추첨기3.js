// var lotto = [];

// for (var i = 0; i < 6; i++) {
//     lotto.push(parseInt(Math.random() * 45 +1));
// }


// document.write(lotto); 



// var lotto = [];
// for (var i = 0; i < 6; i++) {
//     var num = parseInt(Math.random() * 45 +1);
//     if(lotto.indexOf(num) == -1) { // 값이 있으면 위치(배열의 값이 있으면), 없으면 -1
//         lotto.push(num); // 중복된값이 (배열)없으면 값 추가
//     }
// }
// document.write(lotto); 


// var lotto = [];
// while (lotto.length < 6) {
//     var num = parseInt(Math.random() * 45 +1);
//     if(lotto.indexOf(num) == -1) { // 값이 있으면 위치(배열의 값이 있으면), 없으면 -1
//         lotto.push(num); // 중복된값이 (배열)없으면 값 추가
//     }
// }
// document.write(lotto); 



// var lotto = [1,2,3,33,22,11];
// //lotto.sort(); // 정렬 : 1,11,2,22,3,33
// lotto.sort((a,b)=>a-b); // 숫자 오름차순  b-1 내림차순
// document.write(lotto);


var lotto = [];
while (lotto.length < 6) {
    var num = parseInt(Math.random() * 45 +1);
    if(lotto.indexOf(num) == -1) { // 값이 있으면 위치(배열의 값이 있으면), 없으면 -1
        lotto.push(num); // 중복된값이 (배열)없으면 값 추가
    }
}
lotto.sort((a,b)=>a-b);
document.write(lotto); 