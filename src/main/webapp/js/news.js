$.each($('input[id^="open-news-modal"]'), function () {
    $(this).click(function () {
        $.ajax({
            url: 'news',
            method: 'POST',
            dataType: 'json',
            data: {
                'news_id': $(this).attr('id').replace('open-news-modal-', '')
            },
            success: function (json) {
                $('#modal-image').attr('src', json.image)
                $('#modal-title').html(json.title)
                $('#modal-text').html(json.text)
                $('#modal-posting-time').html(json.posting_time)
                $('#modal-author').html(json.author)
                $('#news-modal').modal('show')
            }
        })
    })
})