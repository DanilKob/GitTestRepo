window.setInterval(onClick, 5000);

function onClick() {
    $.ajax({
        url : '/checker/servlet?command=getResult',
        method: 'POST',
        success : function(responseJson) {

            var serverResultsArray = responseJson.result;

            $.each(serverResultsArray, function(index, serverResult) {

                var div = $( "#ajaxGetUserServletResponse");
                div.empty();

                var agentIp = serverResult.agentIp;
                $("<p>").text("Information from agent " + agentIp).appendTo(div);
                var $table = $("<table>").appendTo(div);
                var $tr = $("<tr>");

                $("<th>").text("#").appendTo($tr);
                $("<th>").text("Url").appendTo($tr);
                $("<th>").text("Response code").appendTo($tr);
                $("<th>").text("Response time").appendTo($tr);
                $("<th>").text("Status").appendTo($tr);
                $("<th>").text("Critical timeout").appendTo($tr);
                $("<th>").text("Error timeout").appendTo($tr);

                $tr.appendTo($table);

                var agentResultItem = serverResult.agentResults;

                $.each(agentResultItem, function(ind, agentResultItem) {
                    $tr = $("<tr>");
                    $("<td>").text(ind).appendTo($tr);
                    $("<td>").text(agentResultItem.url).appendTo($tr);
                    $("<td>").text(agentResultItem.responseCode).appendTo($tr);
                    $("<td>").text(agentResultItem.responseTime).appendTo($tr);
                    $("<td>").text(agentResultItem.status).appendTo($tr);
                    $("<td>").text(agentResultItem.critical_timeout).appendTo($tr);
                    $("<td>").text(agentResultItem.error_timeout).appendTo($tr);

                    $tr.appendTo($table);
                });
            });
        }
    });
}