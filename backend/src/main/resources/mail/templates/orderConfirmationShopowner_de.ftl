<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
Hallo Tina,<br>
<br>
Eine neue Anfrage für die folgenden Bilder wurde gestellt.<br>
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
Der Interessent hat folgende Angaben gemacht:<br><br>
Name: ${(cart.vorname)!} ${(cart.nachname)!}<br>
Telefon: ${(cart.telefon)!}<br>
E-Mail: ${(cart.email)!}<br>
Nachricht an dich: ${(cart.nachricht)!}<br>

<br>
Setze dich am Besten gleich mit dem Interessenten in Verbindung!<br>
<br>
Ihre trick-manufaktur<br>
<br>
trick-manufaktur<br>
Ginsterweg 3<br>
51107 Köln<br>
Tel.: 0221/98556174<br>
Web: www.trick-manufaktur.de<br>

</body>
</html>