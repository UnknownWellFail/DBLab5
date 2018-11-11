<#import "../parts/common.ftl"as c>
<@c.page>


    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <#list profiles as profile>
            <tr>
                <th scope="row">${profile.id}</th>
                <td>${profile.name}</td>
                <td>${profile.description}</td>
                <td><a class="btn btn-primary" href="/profiles/remove/${profile.id}" role="button">Remove</a></td>
            </tr>
            </#list>
        </tbody>
    </table>




<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role=button" aria-expanded="false">
    Add new profile
</a>
<div class="collapse <#if profile??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" >
            <div class="form-group">
                <input type="text" class="form-control ${(nameError??)?string('is-invalid', '')}"
                       value="<#if profile??>${profile.name}</#if>" name="name" placeholder="Введите название"/>
                <#if nameError??>
                <div class="invalid-feedback">
                    ${nameError}
                </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control ${(descriptionError??)?string('is-invalid', '')}"
                       value="<#if profile??>${profile.description}</#if>" name="description" placeholder="Описание">
                <#if descriptionError??>
                    <div class="invalid-feedback">
                        ${descriptionError}
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