<#import "navbars.ftl" as navbars>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>News</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <link href="../css/button-style.css" type="text/css" rel="stylesheet">
</head>
<body>

<@navbars.navbars user></@navbars.navbars>

<h1 class="display-1" style="text-align: center; margin-bottom: 48px">Новости</h1>

<!-- Modal -->
<div class="modal fade" id="news-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modal-title"></h4>
                <h6 class="modal-author" id="modal-author"></h6>
                <br/>
            </div>
            <div class="modal-body">
                <h6 class="modal-title" id="modal-location"></h6>
                <img id="modal-image" src="" alt="image" width=100% height="75%">
                <p id="modal-text"></p>
            </div>
        </div>
    </div>
</div>

<div id="search-result">
    <div class="container mx-auto mt-4">
        <div id="cards-row" class="row text-center">
            <#list news as list_news>
                <div class="col" style="margin-bottom: 24px;">
                    <div class="card" style="height: 432px">
                        <img class="card-img-top" src="${list_news.imageUrl}" alt="news image" width=100% height="75%">
                        <div class="card-body">
                            <h4 class="card-title">${list_news.title}</h4>
                            <h6 class="text-muted">${list_news.postingTime}</h6>
                            <input id="${"open-news-modal-" + list_news.id}" class="button-black" style="margin-top: 8px;" type="button" value="Прочитать"/>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</div>

<div id="search-result"></div>

<script src="../js/news.js" type="text/javascript"></script>

</body>
</html>