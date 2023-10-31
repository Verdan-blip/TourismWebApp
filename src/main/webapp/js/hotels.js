const filterByPrice = $('#filter-by-price')
const filter = $('#filter')
filter.hide()
const cardsRow = $('#cards-row')
const searchButton = $('#search-button')

let jsonArray = null

function jsonToHtml() {

    cardsRow.empty()

    if (jsonArray.length !== 0) {
        filter.show()
    } else {
        filter.hide()
        jQuery('<h5>', {
            class: 'text-muted',
            text: 'Результаты не найдены',
            align: 'center'
        }).appendTo(cardsRow);
    }

    for (let i in jsonArray) {

        let cardId = '#card-' + i
        let cardBodyId = '#card-body-' + i

        let cardCol = jQuery('<div>', {
            id: 'card-col-' + i,
            class: 'col',
            style: 'margin-bottom: 24px;'
        }).appendTo(cardsRow);

        let cardElement = jQuery('<div>', {
            class: 'card',
            style: 'height: 394px; width: 296px',
            id: cardId,
        }).appendTo(cardCol);

        //Card image
        let cardImage = jQuery('<img>', {
            class: 'card-img-top',
            id: 'card-image-' + i,
            src: jsonArray[i].image,
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
            id: 'name-' + i,
            text: 'Название: ' + jsonArray[i].name
        }).appendTo(cardBody)

        //City
        jQuery('<h6>', {
            class: 'text-muted',
            id: 'city-' + i,
            text: 'Город: ' + jsonArray[i].city
        }).appendTo(cardBody)

        //Location
        jQuery('<h6>', {
            class: 'text-muted',
            id: 'location-' + i,
            text: 'Адрес: ' + jsonArray[i].location
        }).appendTo(cardBody)

        //Price per night
        jQuery('<h6>', {
            class: 'text-muted',
            id: 'price-per-night-' + i,
            text: 'Цена за одну ночь: ' + jsonArray[i].price_per_night + ' рублей'
        }).appendTo(cardBody)

        //Star rating
        jQuery('<h6>', {
            class: 'text-muted',
            id: 'star-rating-' + i,
            text: 'Рейтинг: ' + jsonArray[i].star_rating
        }).appendTo(cardBody)

        cardCol.click(function () {

            $('#modal-name').html(jsonArray[i].name)
            $('#modal-star-rating').html('Оценка: ' + jsonArray[i].star_rating)
            $('#modal-image').attr('src', jsonArray[i].image)
            $('#modal-price-per-night').html(jsonArray[i].price_per_night + ' рублей за одну ночь')
            $('#modal-location').html(jsonArray[i].location)
            $('#hotel-modal').modal('show')

            $.ajax({
                url: 'reviews/hotel',
                data: {
                    "hotel_id": jsonArray[i].id
                },
                dataType: 'json',
                method: 'POST',
                success: function (jsonCommentsArray) {

                    $('div[id^="modal-card-"]').remove()

                    $('#modal-add-comment-button').click(function () {
                        $.ajax({
                            url: 'reviews/hotel/add',
                            method: 'POST',
                            data: {
                                'hotel_id': jsonArray[i].id,
                                'text': $('#modal-add-comment').val()
                            },
                            success: function () {
                                $('#hotel-modal').modal('hide')
                            },
                        })
                    })

                    for (let j in jsonCommentsArray) {

                        let modalCard = jQuery('<div>', {
                            class: 'card mb-4',
                            id: 'modal-card-' + i
                        }).appendTo($('#modal-body'))

                        let modalCardBody = jQuery('<div>', {
                            class: 'card-body'
                        }).appendTo(modalCard)

                        jQuery('<p>', {
                            class: 'modal-comment-text',
                            id: 'modal-comment-text-' + j
                        }).appendTo(modalCardBody)

                        let commentContainer1 = jQuery('<div>', {
                            class: 'd-flex justify-content-between'
                        }).appendTo(modalCardBody)

                        let commentContainer2 = jQuery('<div>', {
                            class: 'd-flex flex-row align-items-center'
                        }).appendTo(commentContainer1)

                        jQuery('<img>', {
                            src: jsonCommentsArray[j].avatar,
                            class: 'rounded-circle',
                            alt: 'avatar',
                            width: '25',
                            height: '25',
                            id: 'modal-comment-image-' + j
                        }).appendTo(commentContainer2)

                        jQuery('<p>', {
                            id: 'modal-comment-name-' + j,
                            class: 'small mb-0 ms-2',
                            text: jsonCommentsArray[j].name
                        }).appendTo(commentContainer2)


                        $('#modal-comment-image-' + j).attr('src', jsonCommentsArray[j].image)
                        $('#modal-comment-text-' + j).html(jsonCommentsArray[j].text)
                        $('#modal-comment-name-' + j).html(jsonCommentsArray[j].name)

                    }
                }
            })

        })

    }
}

searchButton.click(function () {
    $.ajax({
        url: 'hotels',
        method: 'POST',
        dataType: 'json',
        data: {
            'city': $('#search-input').val(),
        },
        success: function (hotelsJsonArray) {
            jsonArray = hotelsJsonArray
            jsonToHtml()
        },
    })
})

filterByPrice.change(function () {
    switch (filterByPrice.val()) {
        case 'by-ascending':
            jsonArray.sort(function (a, b) {
                return a.price_per_night - b.price_per_night
            })
            break
        case 'by-descending':
            jsonArray.sort(function (a, b) {
                return b.price_per_night - a.price_per_night
            })
            break
        case 'by-rating':
            jsonArray.sort(function (a, b) {
                return b.star_rating - a.star_rating
            })
            break
    }
    jsonToHtml()
})