$(function(){
    let initApplication = function(){

    };

    let registerUser = function(name){
        $.post("/auth", {name: name}, function(response){
        })
    };

    $('.send-button').on('click', function(){
        $.get('/init', {}, function(response){
            if(response == false){
            let name = prompt('Введите Ваше имя:');
            } else {
            }
        })
    });
});