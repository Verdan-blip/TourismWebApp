$('#search-button').click(function () {
    let searchResult = $('#search-result')
    searchResult.empty()
    $.ajax({
        url: 'search',
        method: 'POST',
        dataType: 'json',
        data: {
            'city': $('#search-input').val(),
        },
        success: function (hotels) {
            for (let i in hotels) {
                let cardElement = document.createElement('div')
                cardElement.className = 'card'
                cardElement.style.padding = '12px 12px'
                let cardBody = document.createElement('div')
                cardBody.className = 'cardBody'
                let cardTitle = document.createElement('h5')
                cardTitle.className = 'cardTitle'
                let cardSubtitle = document.createElement('h6')
                cardTitle.className = 'card-subtitle mb-2 text-muted'
                let cardDescription = document.createElement('p')
                cardDescription.className = 'card-text'
                let cardPrice = document.createElement('p')
                cardPrice.className = 'card-text'
                let cardImage = document.createElement('img')
                cardImage.className = 'card-image-top'
                cardImage.style.width = '32rem'

                cardTitle.innerHTML = hotels[i].name
                cardSubtitle.innerHTML = hotels[i].city
                cardDescription.innerHTML = hotels[i].location
                cardPrice.innerHTML = hotels[i].price_per_night + ' рублей за ночь'
                cardImage.src = hotels[i].image
                cardImage.alt = 'Hotel image'

                cardElement.append(cardBody)
                cardBody.append(cardTitle)
                cardBody.append(cardImage)
                cardBody.append(cardSubtitle)
                cardBody.append(cardPrice)
                cardBody.append(cardDescription)

                searchResult.append(cardElement)
            }
        },
    })
})