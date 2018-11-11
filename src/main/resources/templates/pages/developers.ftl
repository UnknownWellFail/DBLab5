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
            <th scope="col">Profiles</th>
            <th></th>

        </tr>
        </thead>
        <tbody>
            <#list developers as developer>

            <tr>
                <th scope="row">${developer.id}</th>
                <td>${developer.name}</td>
                <td>${developer.lastName}</td>
                <td>${developer.middleName}</td>
                <td>${developer.phoneNumber}</td>
                <td>${developer.email}</td>
                <td><#list developer.profiles as profile>
                    <p>${profile.name}</p>
                </#list>
                </td>
                <td><a class="btn btn-primary" href="/developers/remove/${developer.id}" role="button">Remove</a></td>

            </tr>


            </#list>
        </tbody>
    </table>




<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role=button" aria-expanded="false">
    Add new developer
</a>
<div class="collapse <#if developer??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form action = "/developers" method="post">
            <div class="form-group">

                <input type="text" class="form-control ${(nameError??)?string('is-invalid', '')}"
                       value="<#if developer??>${developer.name}</#if>" name="name" placeholder="Введите имя"/>
                <#if nameError??>
                <div class="invalid-feedback">
                    ${nameError}
                </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control ${(lastnameError??)?string('is-invalid', '')}"
                       value="<#if developer??>${developer.lastName}</#if>" name="lastName" placeholder="Фамилия">
                <#if lastnameError??>
                    <div class="invalid-feedback">
                        ${lastnameError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="text" class="form-control ${(middlenameError??)?string('is-invalid', '')}"
                       value="<#if developer??>${developer.middleName}</#if>" name="middleName" placeholder="Отчество">
                <#if middlenameError??>
                    <div class="invalid-feedback">
                        ${middlenameError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="text" class="form-control ${(emailError??)?string('is-invalid', '')}"
                       value="<#if developer??>${developer.email}</#if>" name="email" placeholder="E-mail">
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="text" class="form-control ${(phoneNumberError??)?string('is-invalid', '')}"
                       value="<#if developer??>${developer.phoneNumber}</#if>" name="phoneNumber" placeholder="Телефон">
                <#if phoneNumberError??>
                    <div class="invalid-feedback">
                        ${phoneNumberError}
                    </div>
                </#if>
            </div>
             <#list profiles as profile>
    <div>
        <label><input type="checkbox" name="${profile.name}" <#if developer??>${developer.profiles?seq_contains(profile)?string("checked","")}</#if>>${profile.name}
        </label>
    </div>
             </#list>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>



</@c.page>