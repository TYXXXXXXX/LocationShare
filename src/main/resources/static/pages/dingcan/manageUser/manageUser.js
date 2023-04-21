

$('#btn').on('click',function(){
    let address=$('#inputAddress').val().trim();
    console.log(address);
    const str=JSON.stringify(address);
    console.log(str);

//     $.post('http://localhost:8080/user/',)
$.ajax({
    type:'POST',
    url:'http://localhost:8080/user/address'+str+str,
    data:{str,str},
})

})
