function doctor_authorization() {
    jQuery.ajax({
        type: 'GET',
        url: '/doctor/authorization',
        data: {
            email: jQuery('#doctor_email').val(),
            password: jQuery('#doctor_password').val()
        },
        success: function (response) {
            jQuery('#email').val(''),
                jQuery('#password').val('')
            if (response) {
                location.href = "/doctorPage.html"
            } else {
                jQuery('#doctor_service_message')
                    .empty()
                    .append('Доктор с заданным логином и паролем не зарегистрирован')
            }
        }
    })
}

// function doctor_registration_button() {
//     var xhttp = new XMLHttpRequest();
//     xhttp.onreadystatechange = function () {
//         if (this.readyState == 4 && this.status == 200) {
//             document.getElementById('demo')
//                 .innerHTML = this.responseText;
//         }
//     };
//     xhttp.open("GET", "/doctorRegistration.html", true);
//     xhttp.send();
//
// }


function doctor_registration() {
    $.ajax('/doctor/registration', {
        type: 'POST',
        data: {
            email: jQuery('#doctor_email_for_registration').val(),
            password: jQuery('#doctor_password_for_registration').val(),
            name: jQuery('#doctor_name_for_registration').val(),
            surname: jQuery('#doctor_surname_for_registration').val(),
            doctorType: jQuery('#doctor_specialization_for_registration').val(),
            phoneNumber: jQuery('#doctor_phoneNumber_for_registration').val()
        },
        success: function () {
            location.href = '/doctorPage.html'
        }
    })
}

function getCardById() {
    $('#output_info_window')
        .empty()
        .append('Card id: <input id="card_id" type="number"/>')
        .append('<input type="button" value="Get card" onclick="find_card()"/>')
}

function find_card() {
    $.ajax('/doctor/get/card', {
        type: 'GET',
        data: {
            id: $('#card_id').val()
        },
        success: function (response) {

            $('#output_info_window')
                .empty()
                .append('<div id="card">');
            $('#card')
                .append('<h3>Card info</h3>')
                .append('Card id: ' + response.id + '<br/>')
                .append('Patient name: ' + response.name + '<br/>')
                .append('Patient surname: ' + response.surname + '<br/>')
                .append('Patient gender: ' + response.gender + '<br/>')
                .append('Patient birthday: ' + response.birthday + '<br/>')
                .append('Patient height: ' + response.height + '<br/>')
                .append('Patient weight: ' + response.weight + '<br/>')
        }
    })
}

function getAllCards() {
    $.ajax({
        type: 'GET',
        url: '/doctor/get/all/cards',

        success: function (response) {
            console.log(response);
            console.log(response.length);
            console.log(response[0].id);
            $('#output_info_window')
                .empty()
                .append('<h3>Cards info</h3>');

            for (var i = 0; i < response.length; i++) {
                $('#output_info_window')
                    .append('<div id="card' + i + '">');
                $('#card' + i)
                    .append('Card id: ' + response[i].id + '<br/>')
                    .append('Patient name: ' + response[i].name + '<br/>')
                    .append('Patient surname: ' + response[i].surname + '<br/>')
                    .append('Patient gender: ' + response[i].gender + '<br/>')
                    .append('Patient birthday: ' + response[i].birthday + '<br/>')
                    .append('Patient height: ' + response[i].height + '<br/>')
                    .append('Patient weight: ' + response[i].weight + '<br/>')
                    .append('<br/>');
            }
        }
    })
}
