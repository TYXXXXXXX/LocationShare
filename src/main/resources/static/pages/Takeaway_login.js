// 获取元素
// let username = document.getElementById('username');
// let password = document.getElementById('password');
// let passwordagain = document.getElementById('passwordagain');
// let number = document.getElementById('passwordagain');
// let btn = document.querySelector('#window_btn');
// import { createRequire } from 'module';
// const require = createRequire(import.meta.url);

// const { json } = require("express");
// const express = require("express");

// btn.addEventListener('click', function () {
//     console.log(username.value);
//     console.log(password.value);
//     console.log(passwordagain.value);
//     console.log(number.value);
//     // console.log(1);
// })


$('#window_btn').on('click', function () {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost/login/SS");
    // xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onload = function() {
        let userLis = JSON.parse(xhr.responseText); // 解析JSON字符串为JavaScript对象
        console.log(userLis)
        // 处理获取到的用户列表
    }
    xhr.send()
    // xhr.send(JSON.stringify(str))
    // console.log(JSON.stringify(str))
    // var userName = $('#username').val().trim().toString();
    // var password = $('#password').val().trim().toString()
    // var passwordAgain = $('#passwordagain').val().trim().toString();
    // var number = $('#number').val().trim().toString();
    // let str = {
    //     "userName": userName,
    //     "password": password,
    //     "passwordAgain": passwordAgain,
    //     "number": number,
    // }
    //
    // console.log("***")
    // console.log(1111)
    // console.log(str.name);
    // if (userName.length <= 0 || password.length <= 0 || passwordAgain.length <= 0 || number.length <= 0) {
    //     alert('请输入完整信息');
    //     window.location.href = window.location.href;
    // } else {
    //     again();
    //     // shuju();
    //     // numb();
    // }
    //
    // //
    // var xhr = new XMLHttpRequest();
    // xhr.open("POST", "http://localhost/login/L");
    // xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    // xhr.send(JSON.stringify(str))
    // console.log(JSON.stringify(str))
    // xhr.onreadystatechange = function () {
    //     if (xhr.readyState === 4) {
    //         console.log(xhr.status)
    //         if (xhr.status >= 200 && xhr.status <= 300) {
    //             let x = xhr.responseText
    //             console.log(x)
    //             console.log(JSON.parse(x))
    //             console.log(JSON.parse(x).userName);
    //             console.log("*****************"+xhr.responseText.userName)
    //         }
    //     }
    // }
});


// 判断第一次密码是不是和第二次相同的密码
function again() {
    var password = $('#password').val().trim();
    var passwordagain = $('#passwordagain').val().trim();
    // console.log(password);
    // console.log(passwordagain);
    if (password === passwordagain) {
        console.log('相同');
    } else {
        alert('请两次输入相同的内容');
        window.location.href = window.location.href;
    }
}

// 判断手机号是不是数字
// function numb() {
//     var number = $('#number').val().trim();
//     console.log(number);
// }
