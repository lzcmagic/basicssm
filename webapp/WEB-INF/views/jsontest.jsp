<%--
  Created by IntelliJ IDEA.
  User: lzc
  Date: 2018/7/20
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
    <title>json</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/json2.js"></script>

</head>
<body>
<script>
    // $(document).ready(function () {
    //     console.log('lllsssssl:')
    //     testRequestBody();
    // });

    function testRequestBody() {
        console.log('llll:' + "${pageContext.request.contextPath}");
        $.ajax("${pageContext.request.contextPath}/json/testRequestBody", {
            dataType: "json",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify({id: 1, name: "aaa", author: "lll"}),
            async: true,
            success: function (data) {
                $("#id").html(data.id);
                $("#name").html(data.name);
                $("#author").html(data.author)
            },
            error: function () {
                alert("failed lallala")
            }
        });
    }

    function testFastBody() {
        console.log('hhhh:' + "${pageContext.request.contextPath}");
        $.ajax("${pageContext.request.contextPath}/json/testfastBody", {
            dataType: "json",
            type: "post",
            contentType: "application/json",
            async: true,
            success: function (data) {
                console.log("lzc",data);
                // $("#id").html(data.id);
                // $("#name").html(data.name);
                // $("#author").html(data.author)
            },
            error: function () {
                alert("failed lallala")
            }
        });
    }
</script>
编号：<span id="id"></span><br>
书名：<span id="name"></span><br>
作者：<span id="author"></span><br>
<input type="button" value="立即登录" onclick="testRequestBody();"/>

<button onclick="testFastBody();">test</button>
</body>
</html>
