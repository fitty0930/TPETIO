document.addEventListener("DOMContentLoaded", function () {

    "use strict";

    let cuerpoTabla = document.querySelector("#autos-tabla");

    let tablaSugerencias = [
        { "Maqueta": "Ford Falcon", "Año": "1962" },
        { "Maqueta": "Chevrolet Chevy", "Año": "1971" },
        { "Maqueta": "GMC Coach TDH 3610", "Año": "1948" }
    ];

    MostrarTabla();

    let btnBorrar = document.getElementById('borrar');
    btnBorrar.addEventListener("click", borrarTabla);

    let btnEnviar = document.getElementById('enviarSugerencia');
    btnEnviar.addEventListener("click", nuevaMaqueta);

    function MostrarTabla() {
        cuerpoTabla.innerHTML = "";
        for (let i = 0; i < tablaSugerencias.length; i++) {
            cuerpoTabla.innerHTML += "<tr>" +
                "<td>" + tablaSugerencias[i].Maqueta + "</td>" +
                "<td>" + tablaSugerencias[i].Año + "</td>" +
                "</tr>";
        }
        
    };

    function nuevaMaqueta(e) {
        e.preventDefault();
        let autoIntroducidoPorUsuario = document.getElementById('Auto').value;
        let añoIntroducidoPorUsuario = document.getElementById('Año').value;
        let verificacionAuto = autoIntroducidoPorUsuario.trim();

        if (añoIntroducidoPorUsuario > 1886 && añoIntroducidoPorUsuario < 2020 && verificacionAuto != "") {



            let nuevoAuto = {
                "Maqueta": autoIntroducidoPorUsuario,
                "Año": añoIntroducidoPorUsuario
            };

            tablaSugerencias.push(nuevoAuto);
        } else {
            alert("No ingresó un dato válido");
        }

        MostrarTabla();
    };

    function borrarTabla() {
        tablaSugerencias = [];
        cuerpoTabla.innerHTML = "";
    }
});