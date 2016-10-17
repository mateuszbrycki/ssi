var customTags = [ '<%', '%>' ];

$(document).ready(function () {

    //form validation
    $('#user-register-form').validate({
        rules: {
            username: {
                required: true,
                minlength: 3
            },
            mail: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 3
            },
            passwordRepeat: {
                required: true,
                minlength: 3,
                equalTo: "#password"
            }
        }
    });

    $(document).on('submit', "#user-register-form", function (e) {

        var frm = $('#user-register-form');

        e.preventDefault();
        var data = {};

        $.each(this, function (i, v) {
            var input = $(v);
            data[input.attr("name")] = input.val();
            delete data["undefined"];
        });

        $.ajax({
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: frm.attr('method'),
            url: frm.attr('action'),
            data: JSON.stringify(data),
            success: function (callback) {
                // renderSuccessAlert(callback.message);
                refreshForm(frm);
                refreshUsersTable();

            },
            error: function (xhr) {
                renderFailureAlert(JSON.parse(xhr.responseText).message);
            }
        });

    });
});

function refreshForm(form) {
    form.trigger("reset");
    form.validate().resetForm();
}


function refreshUsersTable() {
    $.when(getUsersList()).done(function (usersList) {
        var template = $('#users_list_template').html();

        Mustache.parse(template, customTags);
        var output = Mustache.render(template, usersList);

        $('#users-table').html(output);
    });
}

function getUsersList() {
    return $.ajax({
        type: "GET",
        url: "http://localhost:8080/user"
    });
}

function renderSuccessAlert(callback) {
    BootstrapDialog.show({
        type: BootstrapDialog.TYPE_SUCCESS,
        title: "Registration",
        message: callback,
        buttons: [{
            label: 'Ok',
            action: function(dialogRef) {
                dialogRef.close();
            }
        }]
    });

}

function renderFailureAlert(callback) {
    BootstrapDialog.show({
        type: BootstrapDialog.TYPE_DANGER,
        title: "Registration",
        message: callback,
        buttons: [{
            label: 'Ok',
            action: function(dialogRef) {
                dialogRef.close();
            }
        }]
    });
}



