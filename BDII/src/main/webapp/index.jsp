
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gerador de Geometrias</title>
    <meta charset="UTF-8"/>
    <link href="css/materialize.css" rel="stylesheet"/>
    <link href="css/index.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
    <div class="row" id="formBox">
        <div class="col s4">
            <form  action="geom" method="post" id="formulario">
                <label>Geometria A:</label>
                <input name="geomA" type="text" class="validate">
                <label>Geometria B:</label>
                <input name="geomB" type="text" class="validate"><br>
                <button class="btn waves-effect waves-light" type="submit" name="action">Enviar
                    <i class="material-icons right">send</i>
                </button>
            </form>

            <div class="row options col s12">
                    <p><a href="areaA">Área da Geometria A</a></p>
                    <p><a href="areaB">Área da Geometria B</a></p>
                    <p><a>Distância entre as centroids A e B</a></p>
                    <p><a>Contains</a></p>
                    <p><a>Covers</a></p>
                    <p><a>Overlaps</a></p>
                    <p><a>Touches</a></p>
                    <p><a>Within</a></p>
            </div>
        </div>



        <svg  viewBox="${vb}" class="col s8">
            <path d="${geom1}" stroke="red" fill="${corA}" stroke-width="0.2" id="geomA"/>
            <path d="${geom2}" stroke="blue" fill="${corB}" stroke-width="0.2" />
            <path d="" stroke="black" stroke-width="0.2" />

        </svg>
    </div>




<script src="js/materialize.js"/>
</body>
</html>
