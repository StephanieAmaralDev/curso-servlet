<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
      <form action="${linkServletNovaEmpresa}" method="post">
        Nome: <input type="text" name="nome"/>
        Data abertura: <input type="text" name="data"/>
        <input TYPE="submit"/>
    </form>
</body>
</html>