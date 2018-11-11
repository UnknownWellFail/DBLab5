<#import "../parts/common.ftl"as c>
<@c.page>


    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Last name</th>
            <th scope="col">Middle name</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <#list clients as client>

            <tr>
                <th scope="row">${client.id}</th>
                <td>${client.name}</td>
                <td>${client.lastName}</td>
                <td>${client.middleName}</td>
                <td>${client.phoneNumber}</td>
                <td>${client.email}</td>
            </tr>

            </#list>
        </tbody>
    </table>




<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role=button" aria-expanded="false">
    Add new client
</a>
<div class="collapse <#if client??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" >
            <div class="form-group">
                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if client??>${client.text}</#if>" name="text" placeholder="Введите сообщение"/>
                <#if textError??>
                <div class="invalid-feedback">
                    ${textError}
                </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control ${(tagError??)?string('is-invalid', '')}"
                       value="<#if message??>${message.tag}</#if>" name="tag" placeholder="Тэг">
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${tagError}
                    </div>
                </#if>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>



</@c.page>