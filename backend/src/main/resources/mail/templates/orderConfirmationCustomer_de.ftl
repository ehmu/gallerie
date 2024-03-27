<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
Hallo ${(cart.vorname)!},<br>
<br>
Deine Anfrage wurde erfolgreich übermittelt.<br>
Es freut mich das Du Interesse an folgenden Bildern hast: <br>
<br>
<table cellpadding="5" border="1">
    <#list cart.products as product>
        <tr>
            <td>
                <img src="${baseUrl}${product.imagePaths[0]}" width="200px" alt="${product.name}"/><br>
            </td>
            <td>
                Name: ${product.name}<br>
                Größe: ${product.size}
            </td>
        </tr>
    </#list>
</table>
<br>
Ich werde mich schnellstmöglich mit Dir in Verbindung setzen.<br>

<br>
Viele Grüße<br>
<br>
Tina Ehmann-Rick<br>
<br>
trick-manufaktur<br>
Ginsterweg 3<br>
51107 Köln<br>
Tel.: 0221/98556174<br>
Web: www.trick-manufaktur.de<br>

</body>
</html>