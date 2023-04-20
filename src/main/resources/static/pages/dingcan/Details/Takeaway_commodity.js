// var shangjia = document.querySelectorAll('.shangjiabox');
// for (var i = 0; i < shangjia.length; i++) {
//     shangjia[i].addEventListener('click', function () {
//         // window.open('../');
//         console.log(1);
//     })
// }

//
function getlist() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/user/Merchants');
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    // xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status >= 200 && xhr.status <= 300) {
                // console.log(xhr.responseText);
                let ss = JSON.parse(xhr.responseText);
                console.log(ss.data);
                // console.log(ss.data[0]);
                //下面是 获取成功后的操作
                // console.log(ss[1]);
                var rows = [];
                $.each(ss.data,function(i,value){
                    // console.log(value.foodName);
                    rows.push("<div onclick=fuu() "+"class="+"shangjiabox"+"><img src="+"../images/shangjia"+(i+1)+".jpg "+"class="+"img-rounded"+"><div><strong>"+value.name+"</strong><span>"+value.describe+"</span></div></div>");
                })
                $('#shangjia').empty().append(rows.join(""));

            //

            }
        }
    }
}
getlist();
function fuu(){
    window.open('http://localhost:8080/static/pages/dingcan/menu/menu.html','_self');
}

// function btn(){}
// let shangjia = document.querySelectorAll('.shangjiabox');
// console.log(shangjia.length);
// let userName = document.getElementById('tab_username');
// let str = userName.innerHTML;
// // console.log(str);
//     for (let i = 0; i < shangjia.length; i++) {
//     shangjia[i].addEventListener('click', function () {
//         // window.open('../');
//         console.log(1);
//         window.open('../menu/menu.html?userName='+str,'_target');
//     })
// }
//
