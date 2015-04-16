window.Asistente = window.Asistente || {};
window.Asistente.equipos = Backbone.Collection.extend({
    model: Asistente.equipo,
    url: "http://localhost:8080/consulta/equipos",
    parse: function (response) {
        return response;
    },
    initialize: function () {

    }
});