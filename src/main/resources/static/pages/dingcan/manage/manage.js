// 这里是绑定商家名称那里退出登录和完善资料的模块
// let M = null;

let nn = sessionStorage.getItem("userM")
let Merc = JSON.parse(nn)
var logout = document.getElementById('logout');
var user = document.getElementById('user');
let flag = true;
logout.addEventListener('click', function () {
    if (flag) {
        user.style.display = "inline-block";
        flag = false;
    } else {
        user.style.display = "none";
        flag = true;
    }

})


// 完善资料的模块（点击弹出一个资料框）
var setting = document.getElementById('setting');
var Iformation = document.getElementById('Information');
let flag_infor = true;
setting.addEventListener('click', function () {
    if (flag_infor) {
        Iformation.style.display = "block";
        flag_infor = false;
    } else {
        Iformation.style.display = "none";
        flag_infor = true;
    }
})


// Ajax 传递请求
// ################这里是提交商家详细信息的表单
var Information_btn = document.getElementById('Information_btn');
Information_btn.addEventListener('click', function () {
    // console.log(1);
    let userName = $('#userName').val().trim();
    let userImg = $('#userImg').val().trim();
    let userNumber = $('#userNumber').val().trim();
    let userEmail = $('#userEmail').val().trim();
    let userPassword = $('#userPassword').val().trim();
    let userAddress = $('#userAddress').val().trim();
    const str = {
        userName: userName,
        userImg: userImg,
        userNumber: userNumber,
        userEmail: userEmail,
        userPassword: userPassword,
        userAddress: userAddress,
    }
    console.log(str);
    // 发送请求
    let xhr = new XMLHttpRequest();
    xhr.open('get', 'http://locallhost/searchFood/1');
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.send(JSON.stringify(str));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status >= 200 && xhr.status <= 300) {
                console.log(xhr.responseText);
            }
        }
    }
})



//################让框可拖拽
Iformation.addEventListener('mousedown', function (e) {
    let x = e.pageX - Iformation.offsetLeft;
    let y = e.pageY - Iformation.offsetTop;
    //绑定移动事件
    document.addEventListener('mousemove', move)
    function move(e) {
        Iformation.style.left = e.pageX - x + 'px';
        Iformation.style.top = e.pageY - y + 'px';
    }
    document.addEventListener('mouseup', function () {
        document.removeEventListener('mousemove', move);
    })
})



// 这里是点击左侧改变左侧颜色，和右边是否显示的事件函数
var right_box = document.querySelector('.right_box');
// console.log(right_box.children.length);
var ul = document.getElementById('ul')
var li = ul.querySelectorAll("li");
// console.log(li);
// console.log(li[0]);
var sum = document.querySelector('#sum');
var cuisine = document.querySelector('#cuisine');
var orders = document.querySelector('#orders');
var add = document.querySelector('#add');

// 循环绑定事件
for (let j = 0; j < li.length; j++) {
    li[j].addEventListener('click', function () {
        // 点击变色函数
        for (let n = 0; n < li.length; n++) {
            li[n].style.color = "#000000";
        }
        this.style.color = "#6083ff";

        // 以下是显示和隐藏右侧box
        var str = right_box.children[j].id;
        var array = right_box.children;
        fun(array);

        // console.log(str);
        // console.log(ss);
        document.getElementById(str).style.display = "block";
    })

}
function fun(ss) {
    for (let i = 0; i < ss.length; i++) {
        ss[i].style.display = "none";
    }
}




// 打印今日收入金额,订单数量，日期
var orders = document.querySelector('#orders');
var amount = orders.querySelectorAll('#amount');
var today = document.getElementById('todayTotal');
var num = document.getElementById('shuliang');
var todayData = document.getElementById('todayData');
var date = new Date();
// console.log(today);
// console.log("今日订单数量：" + amount.length);
var sumamout = 0;
for (var i = 0; i < amount.length; i++) {
    sumamout += parseFloat(amount[i].innerHTML);
}
// console.log("今日到账：" + sumamout + "元");
today.innerHTML = "今日到账：" + sumamout + " 元";
num.innerHTML = "今日订单数量：" + amount.length;
var str = date.getFullYear() + " 年 " + (date.getMonth() + 1) + " 月 " + date.getDate();
// console.log(str);
todayData.innerHTML = "日期：" + str;



// 这里是我的菜品的模块
function getlist() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/user/searchFood/1');
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    // xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status >= 200 && xhr.status <= 300) {
                let ss = JSON.parse(xhr.responseText);
                // console.log(ss);
                //下面是 获取成功后的操作
                // console.log(ss[1]);
                var rows = [];
                $.each(ss.data,function(i,value){
                    console.log(value.foodName);
                    rows.push("<tr><td>" + (i+1) + "</td><td>" + value.foodName + "</td> <td><img src=../images/food"+(i+1)+".jpg></td><td>" + value.price + "元</td> <td> " + value.description + "</td><td ><button type=" + "submit" + "className=" + "btn btn-default" + ">下架</button> " + "</td></tr>");
                })
                $('#tbcuisine').empty().append(rows.join(""));
               }
        }
    }
}
getlist();



// ///////////////这里是"我的菜品"里下架的点击事件
var Delete = document.querySelectorAll('.delete');
for (var i = 0; i < Delete.length; i++) {
    Delete[i].addEventListener('click', function () {
        // console.log(1);
        // 向数据库发送删除请求
        var xhr = new XMLHttpRequest();
        xhr.open('GET', 'http://localhost:8080/user/DELETE');
        xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                if (xhr.status >= 200 && xhr.status <= 300) {
                    alert('删除成功');
                } else {
                    alert('删除失败');
                }
            }
        }
        getlist();
        // 重新加载一遍
    })
}



// ######################这里是添加菜单的模块（点击添加按钮，提交一份到数据库，一份到前端）
var add_submit = document.getElementById('add_submit');
var tbcuisine = document.getElementById('tbcuisine');

add_submit.addEventListener('click', function () {
    getlist();
    var caipinName = $('#caipinName').val().trim();
    var caipinFile = $('#caipinFile').val();
    var caipinPrice = $('#caipinPrice').val();
    var caipinText = $('#caipinText').val();
    const str = {
        caipinName: caipinName,
        caipinFile: caipinFile,
        caipinPrice: caipinPrice,
        caipinText: caipinText,
    }
    console.log(str);
    // 发送请求到服务端
    $.POST('http://localhost:8080/user/ADD',str,function(){
        getlist();
    })
})



// 用户提交订单，商家的显示

function getOrders() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/user/searchFood/1');
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    // xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status >= 200 && xhr.status <= 300) {
                // console.log(xhr.responseText);
                let ss = JSON.parse(xhr.responseText);
                // console.log(ss);
                // console.log(ss[0]);
                //下面是 获取成功后的操作
                // console.log(ss[1]);
                var rows = [];
                $.each(ss,function(i,value){
                    // console.log(value.foodName);
                    rows.push("<tr><td>" + (i+1) + "</td><td>" + value.foodName + "</td> <td><img src=" + "value.price" + "></td><td>" + value.price + "元</td> <td> " + value.description + "</td><td ><button type=" + "submit" + "className=" + "btn btn-default" + ">下架</button> " + "</td></tr>");
                })
                $('#tbcuisine').empty().append(rows.join(""));
            }
        }
    }
}
getOrders();






