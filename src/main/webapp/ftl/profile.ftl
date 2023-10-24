<#import "navbars.ftl" as navbars>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <link href = "../css/button-style.css" rel="stylesheet">
</head>
<body>

    <@navbars.navbars user></@navbars.navbars>

    <div class="d-flex justify-content-center">

        <form action="upload" method="post" enctype="multipart/form-data">

            <div class="mt-5 text-center">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                    <img class="rounded-circle mt-5" width="150px" height="150px" id="avatar" src="${user.getAvatar()}">
                    <br>
                    <input class="button-black" type="file" name="file"/>
                    <br>
                    <input class="button-black" type="submit" name="submit" value="Загрузить аватарку"/>
                </div>
            </div>

            <div class="row mt-2">
                <div class="col-md-6">
                    <label for="name">Имя:</label>
                    <input id="name" class="form-control" placeholder="${user.getName()}" disabled></div>
                <div class="col-md-6">
                    <label for="lastname">Фамилия:</label>
                    <input id="lastname" class="form-control" placeholder="${user.getLastname()}" disabled></div>
            </div>

            <div class="row mt-3">
                <div class="col-md-12">
                    <label for="phone" class="labels">Контактный телефон:</label>
                    <input id="phone" type="tel" class="form-control" placeholder="${user.getPhone()}" disabled>
                </div>
                <div class="col-md-12">
                    <label for="email" class="labels">Почта:</label>
                    <input id="email" type="email" class="form-control" placeholder="${user.getEmail()}" disabled>
                </div>
            </div>

        </form>
</div>
</body>
</html>