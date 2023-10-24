const submitButton = $('#submit-button')
const containerLog = $('#container-log')
const inputEmail = $('#email')
const inputPassword = $('#password')

submitButton.click(function () {
    $.ajax({
        url: 'login',
        method: 'POST',
        dataType: 'json',
        data: {
            'email': $('#email').val(),
            'password': $('#password').val(),
            'remember_me': $('#remember-me').val()
        },
        success: function (response) {
            switch (response.status) {
                case 'success':
                    window.location.replace('profile')
                    break
                case 'failure':
                    containerLog.html('Неверный электронный адрес или пароль')
                    break
            }
        }
    });
});

inputEmail.change(function () {
    containerLog.html('')
})

inputPassword.change(function () {
    containerLog.html('')
})