const inputPhone = $('#phone')
const inputEmail = $('#email')
const logPhone = $('#container-log-phone')
const logEmail = $('#container-log-email')
$('#register-button').click(function () {
    $.ajax({
        url: "register",
        method: 'POST',
        dataType: 'json',
        data: {
            'name': $('#name').val(),
            'lastname': $('#lastname').val(),
            'gender': $('#gender').val(),
            'phone': $('#phone').val(),
            'email': $('#email').val(),
            'password': $('#password').val()
        },
        success: function (response) {
            if (response.status == 'success') {
                window.location.replace('login')
            } else if (response.status == 'failure') {
                if (response.phone_exists == true) {
                    logPhone.html('Пользователь с таким номером телефона уже существует')
                }
                if (response.email_exists == true) {
                    logEmail.html('Пользователь с такой электонной почтой уже существует')
                }
            }
        }
    })
})

inputPhone.change(function () {
    logPhone.html('')
})

inputEmail.change(function () {
    logEmail.html('')
})