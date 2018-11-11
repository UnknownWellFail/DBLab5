<#import "parts/common.ftl"as c>
<#import "parts/login.ftl" as l>

<@c.page>

List of users

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
    </thead>

    <tbody>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href ="/user/${user.id}">Edit</a> </td>
        </tr>
     </#list>
    </tbody>

</@c.page>