// 열기 버튼
const signup = document.getElementById('openBtn');

// 닫기 버튼
const closeBtn = document.getElementById('closeBtn');

// nav 요소
const nav = document.querySelector('nav');

// 열기 버튼을 누르면 nav의 display가 flex로 변경
openBtn.addEventListener("click", () => {
    nav.style.display = "flex";
});

// 닫기 버튼을 누르면 nav의 display가 none으로 변경
closeBtn.addEventListener("click", function () {
    nav.style.display = "none";
});

// 화면 너비가 1024px을 초과했을 때 nav의 style 속성 제거
window.addEventListener("resize", () => {
    if (window.innerWidth > 1024) {
        nav.removeAttribute("style");
    }
});