window.Asistente = window.Asistente || {};
window.Asistente.entrenamientos = Backbone.Collection.extend({
    model: Asistente.entrenamiento,
    url: "http://localhost:8080/consulta/entrenamiento",
    parse: function (response) {
        return response;
    },
    initialize: function () {

    }
});