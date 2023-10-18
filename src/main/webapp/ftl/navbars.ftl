<#import "nav-items/nav-item-log-or-reg.ftl" as log_or_reg />
<#import "nav-items/nav-item-profile.ftl" as profile />

<#macro navbars user>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Young Traveller</a>
        <#if user??>
            <@profile.nav_item_profile />
            <#else>
                <@log_or_reg.nav_item_log_or_reg />
        </#if>
    </nav>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a class="nav-link" href="hotels">Отели</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Развлечение</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Рестораны</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Отзывы о путешествиях</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Авиабилеты</a></li>
            </ul>
        </div>
    </nav>
</#macro>