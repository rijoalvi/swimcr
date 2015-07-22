window.Asistente = window.Asistente || {};
window.Asistente.pruebas = Backbone.Collection.extend({
    model: Asistente.prueba,
    setParams: function (entrenamientoId, fechaEntrenamiento) {
    	this.entrenamientoId = entrenamientoId;
		this.fechaEntrenamiento = fechaEntrenamiento;
    },
    url: function() {
    	var url = '/pruebas';
    	if(this.entrenamientoId && this.fechaEntrenamiento) {
    		url += '/' + this.entrenamientoId + '/' + this.fechaEntrenamiento;
    		this.entrenamientoId = "";
    		this.fechaEntrenamiento = "";
    	}
        return url;
    },
    parse: function (response) {
        return response;
    },
    initialize: function () {

    }
});