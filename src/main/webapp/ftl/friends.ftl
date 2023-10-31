<#import "navbars.ftl" as navbars>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User profile</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <link href = "../css/button-style.css" rel="stylesheet">
</head>
<body>

<@navbars.navbars user></@navbars.navbars>

<h1 class="display-1" style="text-align: center; margin-bottom: 48px">Ваши друзья</h1>

<div id="search-result">
    <div class="container mx-auto mt-4">
        <div id="cards-row" class="row text-center">
            <#list friends as friend>
                <div id=${"col-card-" + friend} class="col" style="margin-bottom: 24px;">
                    <div class="card testimonial-card" style="width: 176px; height: 232px;">
                        <div class="avatar mx-auto bg-white" style="margin: 8px 8px">
                            <img class="rounded-circle" src="${friend.avatar}" alt="avatar" width="116px" height="116px">
                        </div>
                        <div class="card-body">
                            <h6 class="mb-4">${friend.name}</h6>
                            <h6 class="card-subtitle mb-2 text-muted">${friend.lastname}</h6>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</div>

</body>
</html>