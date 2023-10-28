const selectFilter = $('#filter-by-price')
const searchButton = $('#search-button')
const searchResult = $('#search-result')
let jsonResults = null

function setJsonToSearchResults() {
    searchResult.empty()
    for (let i in jsonResults) {
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
        cardPrice.id = 'hotel-price'
        let cardStarRating = document.createElement('p')
        cardStarRating.className = 'card-text'
        cardStarRating.id = 'hotel-star-rating'
        let cardImage = document.createElement('img')
        cardImage.className = 'card-image-top'
        cardImage.style.width = '32rem'

        cardTitle.innerHTML = 'Название: ' + jsonResults[i].name
        cardSubtitle.innerHTML = 'Город: ' + jsonResults[i].city
        cardDescription.innerHTML = 'Описание: ' + jsonResults[i].location
        cardPrice.innerHTML = 'Цена за ночь: ' + jsonResults[i].price_per_night + 'рублей за ночь'
        cardStarRating.innerHTML = 'Рейтинг: ' + jsonResults[i].star_rating + ' звёзд'
        cardImage.src = jsonResults[i].image
        cardImage.alt = 'Hotel image'

        cardElement.append(cardBody)
        cardBody.append(cardTitle)
        cardBody.append(cardImage)
        cardBody.append(cardSubtitle)
        cardBody.append(cardPrice)
        cardBody.append(cardStarRating)
        cardBody.append(cardDescription)

        searchResult.append(cardElement)
    }
}

searchButton.click(function () {
    $.ajax({
        url: 'search',
        method: 'POST',
        dataType: 'json',
        data: {
            'city': $('#search-input').val(),
        },
        success: function (hotels) {
            jsonResults = hotels
            setJsonToSearchResults()
        },
    })
})

selectFilter.change(function () {
    switch (selectFilter.val()) {
        case 'by-ascending':
            jsonResults.sort(function (a, b) {
                return a.price_per_night - b.price_per_night
            })
            break
        case 'by-descending':
            jsonResults.sort(function (a, b) {
                return b.price_per_night - a.price_per_night
            })
            break
        case 'by-rating':
            jsonResults.sort(function (a, b) {
                return b.star_rating - a.star_rating
            })
            break
        case 'by-descending':
            jsonResults.sort(function (a, b) {
                return a.price_per_night - b.price_per_night
            })
            break
    }
    setJsonToSearchResults()
})