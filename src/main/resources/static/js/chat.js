$(function(){
    let getMessageElement = function(message){
        let item = $('<div class = "message-item"></div>');
        let header = $('<div class="message-header"></div>');
        header.append($('<div class="datetime">' + message.datetime + '</div>'));
        header.append($('<div class="username">'+ message.username + '</div>'));
        let textElement = $('<div class="message-text"></div>');
        textElement.text(message.text);
        item.append(header, textElement);
        return item;
    }

    let updateMessages = function(){
        $('.message-list').html('<i>Сообщений нет</i>');
        $.get('/message',{}, function(response){
            if (response.length == 0) {
            return;
            }
            $('.message-list').html('');
            for(i in response){
                let element = getMessageElement(response[i]);
                $('.message-list').append(element);
            }
        });
    }


    let updateUsers = function(){
        $('.users-list').html('<i>Пользователей нет</i>');
        $.get('/user', {}, function(response){
            if (response.length == 0) {
            return;
            }
            $('.users-list').html('');
            for (i in response){
                $('.users-list').append($('<div class="user-item">' + response[i] + '</div>'));
            }
        });
    }



    let initApplication = function(){
        $('.messages-and-users').css({display: 'flex'});
        $('.controls').css({display: 'flex'});

        $('.send-button').on('click', function(){
            let message = $('.new-message').val();
            $.post('/message', {message: message}, function(response){
                if(response.result){
                $('.new-message').val('');
                } else {
                    alert('Ошибка отправления сообщения. Повторите попытку позже');
                }
            })
        });

        setInterval(updateMessages, 10000);
        setInterval(updateUsers, 10000)
    };

    let registerUser = function(name){
        $.post("/auth", {name: name}, function(response){
            if (response.result){
                initApplication();
            }
        });
    };


    $.get('/init', {}, function(response){
        if(!response.result){
        let name = prompt('Введите Ваше имя:');
        registerUser(name);
        return;
        }
        initApplication();
        });
});