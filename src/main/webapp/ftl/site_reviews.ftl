<#import "navbars.ftl" as navbars>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reviews</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <link href="../css/button-style.css" rel="stylesheet">
</head>
<body>

    <@navbars.navbars user></@navbars.navbars>

    <div class="row d-flex justify-content-center" style="margin-top: 32px">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow-0 border" style="background-color: #f0f2f5;">

                <div class="form-outline mb-4">

                    <form method="post" action="reviews">

                        <div class="form-outline mb-4">
                            <textarea name="review-text" class="form-control" rows="3" placeholder="Напишите сюда текст отзыва" required></textarea>
                        </div>

                        <div class="row">

                            <div class="col-sm">
                                <input id="leave-review-button" type="submit" class="form-control" value="Оставить отзыв" />
                            </div>

                            <div class="col-sm">
                                <select name="star-rate" class="form-select" required>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>

                        </div>
                    </form>

                </div>


                <#list reviews as review>

                    <div class="card-body p-4">

                        <div class="card mb-4">
                            <div class="card-body">
                                <p>${review.text}</p>
                                <div class="d-flex justify-content-between">
                                    <div class="d-flex flex-row align-items-center">
                                        <img src="${review.userAvatar}" alt="avatar" width="25" height="25" />
                                        <p class="small mb-0 ms-2">${review.userName}</p>
                                    </div>
                                    <div class="d-flex flex-row align-items-center">
                                        <p class="small text-muted mb-0">${review.date}</p>
                                        <i class="far fa-thumbs-up mx-2 fa-xs text-black" style="margin-top: -0.16rem;"></i>
                                        <p class="small text-muted mb-0">${review.starRate} звёзд</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </#list>
            </div>
        </div>
    </div>

</body>
</html>