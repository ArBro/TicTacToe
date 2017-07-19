<!-- TODO: Does not render well on Chromium -->
<table>
    <c:forEach var="row" items="${board}">
        <tr>
            <c:forEach var="col" items="${row}">
                <td>${col}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>