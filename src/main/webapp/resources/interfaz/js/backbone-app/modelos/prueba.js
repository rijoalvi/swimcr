window.Asistente = window.Asistente || {};
window.Asistente.prueba = Backbone.Model.extend({
    defaults: {
        id: 1,
        id_entrenamiento: 1,
        distancia: 200,
        estilo: 1,
        consecutivo: 1,
        tipo: "Calentamiento"
    },
    parse: function (response, options) {
        return response
    }
});