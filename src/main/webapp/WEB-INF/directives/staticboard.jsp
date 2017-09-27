<table class="tictactoeBoard">
    <c:forEach var="row" items="${game.getGame().getBoard().getBoard()}">
        <tr class="tictactoeBoard">
            <c:forEach var="col" items="${row}">
                <td class="tictactoeBoard">${col}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>