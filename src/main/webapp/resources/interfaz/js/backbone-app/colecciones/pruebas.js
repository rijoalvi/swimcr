window.Asistente = window.Asistente || {};
window.Asistente.pruebas = Backbone.Collection.extend({
    model: Asistente.prueba,
    url: "http://localhost:8080/consulta/entrenamiento/fecha",
    parse: function (response) {
        return response;
    },
    initialize: function () {

    }
});