window.Asistente = window.Asistente || {};
window.Asistente.entrenamiento = Backbone.Model.extend({
    defaults: {
        id: -1,
        id_equipo: -1,
        fecha: ""
    },
    parse: function (response, options) {
        var fechaOriginal = response.fecha;
        var fechaTmp = fechaOriginal.split('-');
        var fechaParseada = "";
        if (fechaTmp.length == 3) {
            fechaParseada = fechaTmp[2] + "-" + fechaTmp[1] + "-" + fechaTmp[0];
        }
        return {
            id: response.id,
            id_equipo: response.id_equipo,
            fecha: fechaParseada
        };
    }
});