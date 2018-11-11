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
                <td><a class="btn btn-primary" href="/clients/remove/${client.id}" role="button">Remove</a></td>
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
                <input type="text" class="form-control ${(nameError??)?string('is-invalid', '')}"
                       value="<#if client??>${client.name}</#if>" name="name" placeholder="Введите имя"/>
                <#if nameError??>
                <div class="invalid-feedback">
                    ${nameError}
                </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control ${(lastNameError??)?string('is-invalid', '')}"
                       value="<#if client??>${client.lastName}</#if>" name="lastName" placeholder="Фамилия">
                <#if lastNameError??>
                    <div class="invalid-feedback">
                        ${lastNameError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="text" class="form-control ${(middleNameError??)?string('is-invalid', '')}"
                       value="<#if client??>${client.middleName}</#if>" name="middleName" placeholder="Отчество">
                <#if middleNameError??>
                    <div class="invalid-feedback">
                        ${middleNameError}
                    </div>
                </#if>
            </div>


            <div class="form-group">
                <input type="text" class="form-control ${(phoneNumberError??)?string('is-invalid', '')}"
                       value="<#if client??>${client.phoneNumber}</#if>" name="phoneNumber" placeholder="Номер телефона">
                <#if phoneNumberError??>
                    <div class="invalid-feedback">
                        ${phoneNumberError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="text" class="form-control ${(emailError??)?string('is-invalid', '')}"
                       value="<#if client??>${client.email}</#if>" name="email" placeholder="E-mail">
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
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