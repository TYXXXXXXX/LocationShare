

$('#btn').on('click',function(){
    let address=$('#inputAddress').val().trim();
    console.log(address);
const str=JSON.stringify(address);
    console.log(str);



//     发送请求
//     $.post('http://localhost:8080/user/',)
$.ajax({
    type:'POST',
    url:'http://localhost:8080/user/address/',
    data:{str},
    success:functon(res){
        alert('提交成功'),
    }
})
})
