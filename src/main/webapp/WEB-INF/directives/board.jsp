<table>
    <c:forEach var="row" items="${game.getGame().getBoard().getBoard()}">
        <tr>
            <c:forEach var="col" items="${row}">
                <td>${col}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>