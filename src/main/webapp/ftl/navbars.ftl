<#import "nav-items/nav-item-log-or-reg.ftl" as log_or_reg />
<#import "nav-items/nav-item-profile.ftl" as profile />

<#macro navbars user = 'not-authorized'>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" style="padding-left: 8px;" href="#">Young Traveller</a>
        <#if user == 'not-authorized'>
            <@log_or_reg.nav_item_log_or_reg />
            <#else>
                <@profile.nav_item_profile user />
        </#if>
    </nav>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a class="nav-link" href="news">Новости</a></li>
                <li class="nav-item active"><a class="nav-link" href="places">Туристические места</a></li>
                <li class="nav-item active"><a class="nav-link" href="hotels">Отели</a></li>
                <li class="nav-item"><a class="nav-link" href="users">Найти людей</a></li>
                <li class="nav-item"><a class="nav-link" href="reviews">Отзывы о сайте</a></li>
            </ul>
        </div>
    </nav>
</#macro>