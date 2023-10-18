$('#search-button').click(function () {
    let searchResult = $('#search-result')
    searchResult.empty()
    $.ajax({
        url: 'http://engine.hotellook.com/api/v2/lookup.json',
        method: 'GET',
        dataType: 'json',
        data: {
            'query': $('#search-input').val(),
            'lang': 'ru',
            'lookFor': 'hotel'
        },
        success: function (json) {
            let arr = json.results.hotels
            arr.forEach(function (element) {
                const cardElement = document.createElement('div')
                const cardBodyElement = document.createElement('div')

                cardElement.className = 'card'

                cardBodyElement.className = 'card-body'
                cardBodyElement.innerText = element.fullName

                cardElement.append(cardBodyElement)
                searchResult.append(cardBodyElement)
            })
        },
    })
})