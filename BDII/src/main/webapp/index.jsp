
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gerador de Geometrias</title>
    <meta charset="UTF-8"/>
    <link href="css/materialize.css" rel="stylesheet"/>
    <link href="css/index.css" rel="stylesheet">
</head>
<body>
    <div class="row" id="formBox">
        <form class="col s4" action="geom" method="post">
            <label>Geometria A:</label>
            <input name="geomA" type="text" class="validate">
            <label>Geometria B:</label>
            <input name="geomB" type="text" class="validate"><br>
            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                <i class="material-icons right">cloud</i>
            </button>
        </form>

        <svg  viewBox="${vb}" class="col s8">
            <path d="${geom1}" stroke="red" fill="none" stroke-width="0.2" />
            <path d="${geom2}" stroke="blue" fill="none" stroke-width="0.2" />
        </svg>
    </div>

<script src="js/materialize.js"/>
</body>
</html>
