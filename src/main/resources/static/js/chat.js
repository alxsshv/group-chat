$(function(){
    $('.send-button').on('click', function(){
        $.get('/init', {}, function(response){
            alert(response);
        })
    });
});