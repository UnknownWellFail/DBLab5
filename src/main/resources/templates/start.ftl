<#import "parts/common.ftl"as c>
<@c.page>

    <#if !client??>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role=button" aria-expanded="false">
    Оформить заказ
</a>
<div class="collapse <#if client??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post">
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
                       value="<#if client??>${client.phoneNumber}</#if>" name="phoneNumber"
                       placeholder="Номер телефона">
                <#if phoneNumberError??>
                    <div class="invalid-feedback">
                        ${phoneNumberError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="hidden"
                       value="" name="email" placeholder="E-mail">

            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>
    <#else >
<a class="btn btn-primary" href="/createOrder" role=button">
    Список заказов
</a>
    </#if>

</@c.page>