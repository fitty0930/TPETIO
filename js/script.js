document.addEventListener("DOMContentLoaded", function () {

    "use strict";

    let cuerpoTabla = document.querySelector("#autos-tabla");

    let tablaSugerencias = [
        { "Maqueta": "Ford Falcon", "Año": "1962" },
        { "Maqueta": "Chevrolet Chevy", "Año": "1971" },
        { "Maqueta": "GMC Coach TDH 3610", "Año": "1948" }
    ];

    MostrarTabla();

    function MostrarTabla() {
        cuerpoTabla.innerHTML = "";
        for (let i = 0; i < tablaSugerencias.length; i++) {
            cuerpoTabla.innerHTML += "<tr>" +
                "<td>" + tablaSugerencias[i].Maqueta + "</td>" +
                "<td>" + tablaSugerencias[i].Año + "</td>" +
                "</tr>";
        }
        
    };
});