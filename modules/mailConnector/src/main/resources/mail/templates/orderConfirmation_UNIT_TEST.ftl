<html>
<body>
Hallo ${(cart.invoiceAddress.salutation)!} ${(cart.invoiceAddress.lastName)!},

<p style='color:green;'>Vielen Dank für Ihre Bestellung.</p>

Warenkorb<br/>

Bestellnummer: ${(cart.id)!}<br/>

<table>
    <tr>
        <td>Artikelnummer</td><td>Name</td><td>Beschreibung</td><td>Menge</td><td>Einzelpreis</td><td>Gesamtpreis</td>
    </tr>
    <#list cart.orderPositionJbos as position>
        <tr>
            <td>${(position.productId)!}</td><td>${(position.name)!}</td><td>${(position.description)!}</td><td>${(position.amount)!}</td><td>${(position.price)!}</td><td>${(position.totalWithTax)!}</td>
        </tr>
    </#list>
    <tr>
        <td colspan="5">Gesamtpreis mit Steuern</td><td>${(cart.totalWithTax)!}</td>
    </tr>
    <tr>
        <td colspan="5">Steuern</td><td>${(cart.taxValue)!}</td>
    </tr>

</table>
 <br>
Rechnungsadresse<br/>
${(cart.invoiceAddress.salutation)!} ${(cart.invoiceAddress.firstName)!} ${(cart.invoiceAddress.lastName)!} <br/>
${(cart.invoiceAddress.street)!} <br/>
${(cart.invoiceAddress.zip)!} ${(cart.invoiceAddress.city)!} <br/>
<br/>
Lieferadresse<br/>
${(cart.deliveryAddress.salutation)!} ${(cart.deliveryAddress.firstName)!} ${(cart.deliveryAddress.lastName)!} <br/>
${(cart.deliveryAddress.street)!} <br/>
${(cart.deliveryAddress.zip)!} ${(cart.deliveryAddress.city)!} <br/>
<br/>
Blabla,<br/>
Ihr Shop Team<br/>

</body>
</html>