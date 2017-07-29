<!-- TODO: Does not render well on Chromium -->
<table>
    <c:forEach var="row" items="${game.getBoard().getBoard()}">
        <tr>
            <c:forEach var="col" items="${row}">
                <td>${col}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>