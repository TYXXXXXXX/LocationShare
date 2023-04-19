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

$('#window_btn').on('click', function () {
    var userName = $('#username').val().trim().toString();
    var password = $('#password').val().trim().toString();
    var passwordAgain = $('#passwordagain').val().trim().toString();
    var number = $('#number').val().trim().toString();
    const str = {
        userName: userName,
        password: password,
        passwordAgain: passwordAgain,
        number: number,
    }
    console.log(str.name);
    if (userName.length <= 0 || password.length <= 0 || passwordAgain.length <= 0 || number.length <= 0) {
        alert('请输入完整信息');
        // window.location.href = window.location.href;
    } else {
        again();
        console.log(1111)
    }
    console.log("###############")

    // 
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost/login/L');
    console.log("##############")
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8')
    xhr.send(JSON.stringify(str));
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
            }
        }
    }
});


// 判断第一次密码是不是和第二次相同的密码
function again() {
    var password = $('#password').val().trim();
    var passwordagain = $('#passwordagain').val().trim();
    // console.log(password);
    // console.log(passwordagain);
    if (password === passwordagain) {
        // console.log('相同');
    } else {
        alert('请两次输入相同的密码');
        window.location.href = window.location.href;
    }
}

// 判断手机号是不是数字
// function numb() {
//     var number = $('#number').val().trim();
//     console.log(number);
// }


function url() {
    // 打印url
    var url = window.location.href;
    var index = url.indexOf("?");
    var str = url.substr(index + 1, url.length)
    console.log(str);
    // pandu判断，是从用户界面进入的,haishi还是从商家界面进入的
    if (str === "shangjia=true") {
        // 这是商家
        window.location.href = "manage\manage.html";
    }
}
