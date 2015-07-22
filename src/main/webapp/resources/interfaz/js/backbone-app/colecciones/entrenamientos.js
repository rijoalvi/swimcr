window.Asistente = window.Asistente || {};
window.Asistente.entrenamientos = Backbone.Collection.extend({
    model: Asistente.entrenamiento,
    setParams: function (equipoId) {
    	this.equipoId = entrenamientoId;
    },
    url: function() {
    	var url = '/entrenamientos';
    	if(this.equipoId ) {
    		url += '/' + this.equipoId;
    		this.equipoId = "";
    	}
        return url;
    },
    parse: function (response) {
        return response;
    },
    initialize: function () {

    }
});