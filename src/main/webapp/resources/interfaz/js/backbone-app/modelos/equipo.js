window.Asistente = window.Asistente || {};
window.Asistente.equipo = Backbone.Model.extend({
    defaults: {
        id: -1,
        nombre: "",
        id_usuario: -1
    },
    parse: function (response, options) {
        return response;
    }
});