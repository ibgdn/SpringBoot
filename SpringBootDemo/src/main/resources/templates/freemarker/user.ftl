<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
    <#include './header.ftl'/>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>用户名</td>
            <td>用户地址</td>
            <td>用户性别</td>
        </tr>
        <#list users as u>
            <tr>
                <td>${u.id}</td>
                <td>${u.userName}</td>
                <td>${u.userAddress}</td>
                <td>
<#--
                    <#if u.gender == 0>
                    男
                    <#elseif u.gender == 1>
                    女
                    <#else>
                    未知
                   </#if>
-->
                    <#switch u.gender>
                        <#case 0>男<#break >
                        <#case 1>女<#break >
                        <#default >未知
                    </#switch>
                </td>
            </tr>
        </#list>
    </table>
</body>
</html>