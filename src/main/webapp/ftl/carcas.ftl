<#macro carcas title>
    <html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
    <header>
        <ul>
            <li><a href="login">Войти</a></li>
            <li><a href="registration">Зарегистрироваться</a></li>
        </ul>
    </header>
    <nav>
        <ul>
            <li><a href="#">Отели</a></li>
            <li><a href="#">Развлечение</a></li>
            <li><a href="#">Рестораны</a></li>
            <li><a href="#">Отызывы о путешествиях</a></li>
            <li><a href="#">Авиабилеты</a></li>
        </ul>
    </nav>
    <main>
        <@content/>
    </main>
    </body>
</#macro>