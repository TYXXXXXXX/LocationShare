

// 加载菜品

getlist();
function getlist() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/user/searchFood/1');
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    // xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status >= 200 && xhr.status <= 300) {
                var ss = JSON.parse(xhr.responseText);
                // console.log(ss);
                // console.log(ss[0]);
                //下面是 获取成功后的操作
                // console.log(ss[1]);
                let rows = [];
                $.each(ss.data,function(i,value){
                    // console.log(value.foodName);
                    rows.push("<tr><td>" + (i+1) + "</td><td>" + value.foodName + "</td> <td><img src=../images/food"+(i+1)+".jpg></td><td>" + value.price + "元</td> <td> " + value.description + "</td><td ><button type=" + "submit " + "class="+"cuisine_add "+" id="+"food"+(i+1)+ ">加入购物车"+"</button></td></tr>");
                })
                $('#tbcuisine').empty().append(rows.join(""));

                // // 把点击的菜加到购物车上
                var cuisine_add = document.querySelectorAll('.cuisine_add');
                for(let i=0; i<cuisine_add.length; i++){
                    cuisine_add[i].addEventListener('click', function () {
                        // console.log(111);
                        // 获取菜品的名字

                        let tr_id = cuisine_add[i].parentNode.parentNode.children[1];
                        // console.log(tr_id);
                        let cuisine_name = tr_id.innerText;
                        // console.log(cuisine_name);
                        // var cuisine_name_1 = cuisine_name.innerHTML;
                        // console.log(cuisine_name_1);
                        // console.log(shop_ul.innerHTML);
                        let a = [];
                        a = shop_ul.innerHTML;
                        a += " <li>" + cuisine_name + "</li>";
                        shop_ul.innerHTML = a;
                    })
                }
            }
        }
    }
}


// 点击购物车显示已选菜
let shop = document.getElementById('shop');
let ico = document.getElementById('ico');
let flag_shop = true;
ico.addEventListener('click', function () {
    // console.log(cuisine_name.innerHTML);
    if (flag_shop) {
        shop.style.display = "block";
        flag_shop = false;
    } else {
        shop.style.display = "none";
        flag_shop = true;
    }

})

// 提交订单按钮
var jiesuan = document.getElementById('jiesuan');
var flag1=true;
jiesuan.addEventListener('click', function () {
    let shop = document.getElementById('shop');
    shop.style.display = "none";
    sum();
    if(flag1){
        alert('请在五分钟之内付款！');
        jiesuan.value="付款"
        flag1=false;
    }else{
        alert('付款成功！');
    }


    // window.open('menu.html', '_self');
})



//把用户的下单的菜提交给服务端：
function sum(){
    // console.log(shop_ul.innerText);
    const carItem = {
        carId: 1,
        foodId:null,
        qulty: null
    }

    let all = []
    let counts = {}
    let str = shop_ul.innerText;
    let strr=str.toString().trim().split(" ");
    let  set = new Set(strr)
    let temp = []
    set.forEach(s => temp.push([0]))
    let k = 0
    set.forEach(s => {
        strr.filter(v => {
           if( v === s) temp[k]++
        } )
        k++
    })
    console.log(temp);
    console.log(set);

    // 这里是拼接菜单
    let xx="";
    for(let x of set){
    xx+=x+",";
}
    console.log(xx);
    // xx是传给服务器的菜品名。



    strr=Object.assign({},strr);
    // console.log(strr);
   let res = []
    let count = 0
    set.forEach(s => {
        res[count] = {
            foodName: s,
            quantity: temp[count++]
        }
    })
    console.log(res);


    $.ajax({
        type:'POST',
        url:'http://localhost:8080/user/',
        data:'res',
        success:function (){

        }
    })
}


