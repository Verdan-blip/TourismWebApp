const searchButton = $('#search-button')
const cardsRow = $('#cards-row')
let jsonResults = null

function setJsonToHtml() {
    cardsRow.empty()

    if (jsonResults.length === 0) {
        jQuery('<h5>', {
            class: 'text-muted',
            text: 'Результаты не найдены',
            align: 'center'
        }).appendTo(cardsRow);
    }

    for (let i in jsonResults) {

        let cardId = '#card-' + i
        let cardBodyId = '#card-body-' + i

        let cardCol = jQuery('<div>', {
            id: 'card-col-' + i,
            class: 'col',
            style: 'margin-bottom: 24px;'
        }).appendTo(cardsRow);

        let cardElement = jQuery('<div>', {
            class: 'card',
            style: 'height: 368px; width: 296px',
            id: cardId,
        }).appendTo(cardCol);

        //Card image
        let cardImage = jQuery('<img>', {
            class: 'card-img-top',
            id: 'card-image-' + i,
            src: jsonResults[i].image,
            alt: 'place image',
            width: '100%',
        }).appendTo(cardElement)

        //Card body
        let cardBody = jQuery('<div>', {
            class: 'card-body',
            id: cardBodyId
        }).appendTo(cardElement)

        //Name
        jQuery('<h6>', {
            class: 'card-title',
            text: 'Название: ' + jsonResults[i].name
        }).appendTo(cardBody)

        //City
        jQuery('<h6>', {
            class: 'text-muted',
            text: 'Город: ' + jsonResults[i].city
        }).appendTo(cardBody)

        //Location
        jQuery('<h6>', {
            class: 'text-muted',
            text: 'Адрес: ' + jsonResults[i].location
        }).appendTo(cardBody)

        cardsRow.append(cardCol)

        $(document).on('click', '#card-image-' + i, function () {
            $('#modal-image').attr('src', jsonResults[i].image)
            $('#modal-text').html(jsonResults[i].description)
            $('#modal-title').html(jsonResults[i].name)
            $('#modal-location').html(jsonResults[i].location)
            $('#image-modal').modal('show')
        })

    }
}

searchButton.click(function () {
    $.ajax({
        url: 'places',
        method: 'POST',
        dataType: 'json',
        data: {
            'city': $('#search-input').val(),
        },
        success: function (places) {
            jsonResults = places
            setJsonToHtml()
        },
    })
})