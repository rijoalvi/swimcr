window.Asistente = window.Asistente || {};
window.Asistente.usuario = Backbone.Model.extend({
    defaults: {
        id: -1
    },
    parse: function (response, options) {
        var id = -1;
        if (response.id.length > 0) {
            valorId = response.id[0];
        }
        return {
            id: valorId
        };
    }
});