const searchInput = $('#search-input')
const searchButton = $('#search-button')
const rowsCard = $('#cards-row')

function usersJsonArrayToHtml(jsonArray) {
    for (let i in jsonArray) {

        let colCard = jQuery('<div>', {
            id: 'col-card-' + i,
            class: 'col',
            style: 'style="margin-bottom: 24px;"'
        }).appendTo(rowsCard)

        let testimonialCard = jQuery('<div>', {
            class: "card testimonial-card",
            style: "width: 176px; height: 232px;"
        }).appendTo(colCard)

        let avatarContainer = jQuery('<div>', {
            class: "avatar mx-auto bg-white",
            style: "margin: 8px 8px"
        }).appendTo(testimonialCard)

        jQuery('<img>', {
            class: "rounded-circle",
            src: jsonArray[i].avatar,
            alt: "avatar",
            width: "116px",
            height: "116px"
        }).appendTo(avatarContainer)

        let cardBody = jQuery('<div>', {
            class: "card-body"
        }).appendTo(testimonialCard)

        jQuery('<h6>', {
            class: "mb-4",
            text: jsonArray[i].name,
        }).appendTo(cardBody)

        jQuery('<h6>', {
            class: "card-subtitle mb-2 text-muted",
            text: jsonArray[i].lastname,
        }).appendTo(cardBody)

        colCard.appendTo(rowsCard)
    }
}

searchButton.click(function () {

    $('#cards-row').empty()

    $.ajax({
        url: 'users',
        method: 'POST',
        data: {
            'name': searchInput.val()
        },
        dataType: 'json',
        success: function (jsonArray) {
            usersJsonArrayToHtml(jsonArray)
        }
    })

})