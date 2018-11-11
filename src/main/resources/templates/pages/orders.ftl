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
            <#list orders as order>
            <tr>
                <th scope="row">${order.id}</th>
                <td>${order.name}</td>
                <td>${order.description}</td>
                <td><a class="btn btn-primary" href="/orders/remove/${order.id}" role="button">Remove</a></td>
            </tr>
            </#list>
        </tbody>
    </table>




<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role=button" aria-expanded="false">
    Add new order
</a>
<div class="collapse <#if order??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" >
            <div class="form-group">
                <input type="text" class="form-control ${(nameError??)?string('is-invalid', '')}"
                       value="<#if order??>${profile.name}</#if>" name="name" placeholder="Введите название"/>
                <#if nameError??>
                <div class="invalid-feedback">
                    ${nameError}
                </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control ${(descriptionError??)?string('is-invalid', '')}"
                       value="<#if order??>${order.description}</#if>" name="description" placeholder="Описание">
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