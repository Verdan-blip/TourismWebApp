<#import "navbars.ftl" as navbars>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <link rel="stylesheet" href="../css/button-style.css"/>
</head>
<body>

<@navbars.navbars user></@navbars.navbars>

<div class="modal fade" id="image-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-body">
                <img class="modal-content" id="large-image" src="" alt="larged-image"/>
            </div>
        </div>
    </div>
</div>

<h1 class="display-1" style="text-align: center; margin-bottom: 48px">Пользователи</h1>

<div class="form-row justify-content-center">
    <div class="input-group mx-auto mb-3" style="width: 25%">
        <input id="search-input" type="search" class="form-control rounded" placeholder="Введите имя пользователя"
               aria-label="Search" aria-describedby="search-addon" />
        <button id="search-button" type="button" class="btn btn-outline-primary">Найти пользователя</button>
    </div>
</div>

<div id="search-result">
    <div class="container mx-auto mt-4">
        <div id="cards-row" class="row text-center">
            <#list users as list_user>
            <div id=${"col-card-" + list_user.id} class="col" style="margin-bottom: 24px;">
                <div class="card testimonial-card" style="width: 176px; height: 232px;">
                    <div class="avatar mx-auto bg-white" style="margin: 8px 8px">
                        <img class="rounded-circle" src="${list_user.avatar}" alt="avatar" width="116px" height="116px">
                    </div>
                    <div class="card-body">
                        <h6 class="mb-4">${list_user.name}</h6>
                        <h6 class="card-subtitle mb-2 text-muted">${list_user.lastname}</h6>
                    </div>
                </div>
            </div>
            </#list>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="../js/users.js"></script>

</body>
</html>