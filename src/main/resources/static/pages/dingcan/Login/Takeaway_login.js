
//失去焦点判断用户是否存在
let isSet = false
$("#username").blur(function () {
    console.log("失去焦点")
    if (getUser()[0] !== getUser()[0].trim() || getUser()[0] === "") alert("输入不能有空格")
    $.ajax({
        url: "http://localhost:8080/login/isSet/" + getUser()[0],
        type: "GET",
        success: function (result) {
            if (!result.flag) noDisplay()
            else {
                isSet = true;
                $("#window_p").css("display", "none")
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
})
$("#number").blur(function () {
    let isTrue = isRule()
    if (isTrue && isSet) {
        show()
        $.ajax({
            url: "http://localhost:8080/login/isSet/" + getUser()[0],
            type: "GET",
            success: function (result) {
                if (!result.flag) noDisplay()
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
})


const noDisplay = () => {
    $("#window_p").css("display", "block")
}
const show = () => {
    $("#window_btn").css("opacity", "1").css("pointer-events", "auto");
}

const isRule = () => {
    if (getUser()[0] !== getUser()[0].trim()
        || getUser()[1] !== getUser()[1].trim()
        || getUser()[2] !== getUser()[2].trim()) {
        alert("输入不能有空格")
        return false
    }
    if (getUser()[1] !== getUser()[2]) {
        alert("密码不一致")
        return false
    }
    return true


}

const getUser = () => {
    return [$('#username').val().toString(), $('#password').val().toString()
        , $("#passwordagain").val().toString(), $("#number").val().toString()]
}
//注册
// const regis = () => {
//     isRule()
$("#window_btn").click(function () {
    if (isSet && isRule()) {
        $.ajax({
            url: "http://localhost:8080/login/" + getUser()[0] + "/" + getUser()[1] + "/" + getUser()[3],
            type: "POST",
            success: function (result) {
                if (result.flag) {
                    alert(result.msg)
                    let timer = setTimeout(function () {
                        window.open("http://localhost:8080/static/pages/dingcan/Details/Takeaway_commodity.html", '_self')
                        clearTimeout(timer)
                    }, 1500)
                }

            },
            error: function (error) {
                console.log(error);
            }
        });
    } else alert("密码不一致")

})
//}
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
        // window.location.href = window.location.href;
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
