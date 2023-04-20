// 这里是绑定商家名称那里退出登录和完善资料的模块
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
window.hu = [2,1]
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
//拖拽
Iformation.addEventListener('mousedown', function (e) {
    var x = e.pageX - Iformation.offsetLeft;
    var y = e.pageY - Iformation.offsetTop;
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


// ///////////////这里是"我的菜品"里下架的点击事件
var Delete = document.querySelectorAll('.delete');
for (var i = 0; i < Delete.length; i++) {
    Delete[i].addEventListener('click', function () {
        // console.log(1);
        // 向数据库发送删除请求
        var xhr = new XMLHttpRequest();
        xhr.open('post', 'http://127.0.0.1:8000/delete');
        xhr.setRequestHeader('Content-Type', 'application/x-www-from')
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
        // 这里是从前端页面上删除表格
        //获取tr的id序号
        console.log(Delete[i].parentNode);
        // this
    })
}
// 这里是从前端页面上删除表格:先获取list信息，再删除，在获取

// 获取菜单页面的数据
// function getCuisine() {
//     $.get('http://127.0.0.1:8000/server/getCuisine', function (res) {
//         // console.log(res);
//         if (res.status != 200) {
//             return alert('获取数据失败')
//         }
//         //下面是 获取成功后的操作
//         var rows = [];
//         $.each(res.data, function (i, item) {
//             rows.push('<tr><td>' + item.id + '</td><td>' + item.bookname + '</td><td>' + item.author + '</td><td>' + item.publisher + '</td><td><a herf="javascript:;" id="del" data-id="' + item.id + '">删除</a></td></tr>')
//         })
//         $('#tbcuisine').empty().append(rows.join(''))
//     });
// }
// getCuisine();


// ######################这里是添加菜单的模块（点击添加按钮，提交一份到数据库，一份到前端）

var add_submit = document.querySelector('#add_submit');
var tbcuisine = document.getElementById('tbcuisine');

// add_sumbit.onclick = function () {
// add_submit.addEventListener('click', function () {
$('#add_submit').on('click', function () {
    // 到前端
    // console.log(11);
    var caipinname = $('#caipinname').val().trim();
    var caipinfile = $('#caipinfile').src();
    var caipinprice = $('#caipinprice').val().trim();
    var caipintext = $('#caipintext').val().trim();
    const str = {
        "caipinName": caipinname,
        "caipinfile": caipinfile,
        "caipinprice": caipinprice,
        "caipintext": caipintext,
    }
    console.log(str.caipinfile);
    var rows = [];
    $.each(str.data, function () {
        // str.push("<tr id="+1+">< td id = "+ID+" > 1</ ><td>红烧李丹宇 </td><td><img src="+"../images/touxiang1.jpg" +"class="+"img-rounded"></td><td> 1元</td><td>香甜可口，肥而不腻</td><td class="delete"> <button type="submit" class="btn btn-default " id="">下架</button></td></tr > ")
    })
    $('#tbcuisine').empty().append(rows.join(''))


    // 到数据库的

})








