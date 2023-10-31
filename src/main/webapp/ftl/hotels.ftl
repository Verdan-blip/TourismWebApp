<#import "navbars.ftl" as navbars>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hotels</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>

    <@navbars.navbars user></@navbars.navbars>

    <!-- Modal -->
    <div class="modal fade" id="hotel-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="modal-name"></h4>
                    <h6 class="modal-title" id="modal-star-rating"></h6>
                    <br/>
                </div>
                <div id="modal-body" class="modal-body">
                    <img id="modal-image" src="" alt="image" width=100% height="75%">
                    <h5 class="modal-title" id="modal-location"></h5>
                    <h5 class="text-muted" id="modal-price-per-night"></h5>

                    <br/>

                    <!-- Comments -->
                    <div class="form-outline mb-4" style="margin: 32px 0;">
                        <input type="text" id="modal-add-comment" class="form-control" placeholder="Напишите комментарий" required />
                        <input type="button" id="modal-add-comment-button" class="form-control" value="Отправить" style="margin: 16px 0;" />
                    </div>

                </div>
            </div>
        </div>
    </div>

    <h1 class="display-1" style="text-align: center; margin-bottom: 48px">Отели</h1>

    <div class="form-row justify-content-center">
        <div class="input-group mx-auto mb-3" style="width: 25%">
            <div class="input-group">
                <input id="search-input" type="search" class="form-control rounded" placeholder="Введите название города" aria-label="Search" aria-describedby="search-addon" />
                <button id="search-button" type="button" class="btn btn-outline-primary">Найти отели</button>
            </div>
        </div>
    </div>

    <div id="filter" class="form-row justify-content-center">
        <div class="input-group mx-auto mb-3" style="width: 25%">
            <label for="filter-by-price" style="margin: 8px 8px;">Фильтровать по</label>
            <select id="filter-by-price" class="form-select">
                <option disabled selected>Выберите</option>
                <option value="by-ascending">По возрастанию цены</option>
                <option value="by-descending">По убыванию цены</option>
                <option value="by-rating">По рейтингу</option>
            </select>
        </div>
    </div>

    <div id="search-result">
        <div class="container mx-auto mt-4">
            <div id="cards-row" class="row text-center"></div>
        </div>
    </div>

    <script type="text/javascript" src="../js/hotels.js"></script>

</body>
</html>