const getUser = () => {
    return [$("#username1").val().toString(), $("#password1").val().toString()]
}
$("#window_btn").click(function () {

    const merchants = {
        userName: getUser()[0],
        password: getUser()[1]
    }
    console.log(merchants)
    $.ajax({
        url: "/login/M",
        type: "POST",
        contentType: "application/json;charset=utf-8", // 请求体的类型，指定为 JSON
        data: JSON.stringify(merchants), // 将要发送的数据转换成 JSON 格式
        success: function (result) {
            if (result.flag) {
                console.log(result)
                let mec = result.data
                sessionStorage.setItem("userM", JSON.stringify(mec))
                alert("即将跳转，请稍后...")
                let timer = setTimeout(function () {
                    window.open("http://localhost:8080/static/pages/dingcan/Details/Takeaway_commodity.html", '_self')
                    clearTimeout(timer)
                }, 1500)
            }else {
                alert(result.msg)
            }

        },
        error: function (error) {
            console.log(error);
        }

    });

})
