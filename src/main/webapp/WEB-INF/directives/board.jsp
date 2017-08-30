<table class="board">
    <c:forEach var="row" items="${game.getGame().getBoard().getBoard()}">
        <tr class="board">
            <c:forEach var="col" items="${row}">
                <td class="board">${col}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>