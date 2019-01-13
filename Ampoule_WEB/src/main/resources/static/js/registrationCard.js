function create() {

    // if(email.value == '' ||
    //    password.value == '' ||
    //     passwordConfirm == ''    ){
    //
    // }
    if (password.value !== passwordConfirm.value) {
        jQuery('#password').val('');
        jQuery('#passwordConfirm').val('');
        alert("Пароли не совпадают")
    }else {
        if(login.value != '')
            createCard();
    }
}

function createCard() {
    jQuery.ajax({
            type: 'POST',
            url: '/card/create',
            data:{
                email: jQuery ('#email').val(),
                password: jQuery('#password').val(),
                password: jQuery('#name').val(),
                password: jQuery('#surname').val(),
                password: jQuery('#gender').val(),
                password: jQuery('#birthday').val(),
                password: jQuery('#height').val(),
                password: jQuery('#weight').val(),
            },
            success: function () {
                jQuery('#login').val('');
                jQuery('#password').val('');
                jQuery('#passwordConfirm').val('');

            },
            error: function  () {
                jQuery('#login').val('');
                jQuery('#password').val('');
                jQuery('#passwordConfirm').val('');
                alert("Этот логин уже существует")

            }
        }
    )



}
