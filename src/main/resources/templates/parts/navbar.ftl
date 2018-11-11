<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">DSTU</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home </a>
            </li>

        <#--            <li class="nav-item">
                        <a class="nav-link" href="/index">Messages</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/user-messages/${currentUserId}">My Messages</a>
                    </li>-->



            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/developers">Developer list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/clients">Client list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/profiles">Profiles list</a>
            </li>
            <#else >
            <li class="nav-item">
                <a class="nav-link" href="/createOrder">Orders list</a>
            </li>

            </#if>

                <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile">Profile</a>
            </li>
                </#if>

        </ul>
        <div class="navbar-text mr-3">${name}</div>
                <@l.logout />

    </div>
</nav>