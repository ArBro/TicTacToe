<table class="tictactoeBoard">
    <c:set var="count" value="0" scope="page" />
    <c:forEach var="row" items="${game.getGame().getBoard().getBoard()}">
        <tr class="tictactoeBoard">
            <c:forEach var="col" items="${row}">
                <c:set var="count" value="${count + 1}" scope="page"/>
                <td class="tictactoeBoard">
                    <form method="post">
                        <label hidden><input hidden name="input" value=${count} /></label>
                        <c:choose>
                            <c:when test="${col.length() == 0}">
                                <input class="tictactoeboardfield" type="submit" placeholder="" value="">
                            </c:when>
                            <c:otherwise>
                                <input class="tictactoeboardfield" type="submit" placeholder="" value=${col}>
                            </c:otherwise>
                        </c:choose>
                    </form>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
