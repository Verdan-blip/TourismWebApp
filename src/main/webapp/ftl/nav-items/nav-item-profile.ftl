<#macro nav_item_profile user>
    <div class="collapse navbar-collapse justify-content-end" id="navbarCollapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <img class="rounded-circle" src="${user.avatar}"
                     width="32px" height="32px" style="margin: 4px 16px">
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout">Выйти</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="profile">Профиль</a>
            </li>
        </ul>
    </div>
</#macro>