Backbone.ajax = function () {
    var args = Array.prototype.slice.call(arguments, 0);
    _.extend(args[0], {
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json'
    });
    return Backbone.$.ajax.apply(Backbone.$, args);
};

window.Asistente = window.Asistente || {};
window.Asistente.vistaPrincipal = Backbone.View.extend({
    el: "#contenedor-aplicacion",
    events: {
        "click .nav-tabs a"									: "mostrarEntrenamientos",
        "eventselected .entrenamientos a"					: "cargarPruebas",
        "click #boton-volver-entrenamientos"				: "mostrarEntrenamientos",
        "click .entrenamientos .boton-borrar-entrenamiento"	: "borrarFilaEntrenamientos",
        "click .pruebas .boton-borrar-prueba"				: "borrarFilaPruebas",
        "click .nuevo-entrenamiento"						: "abrirModalEntrenamiento",
        "click .modal-background"							: "cerrarModalEntrenamiento",
        "click .form-guardar-entrenamiento .cerrar"			: "cerrarModalEntrenamiento",
        "click .pruebas .boton-agregar-prueba"				: "agregarFilaPruebas",
        "submit .form-guardar-entrenamiento"				: "cerrarModalEntrenamiento",
        "click .pruebas .boton-guardar-prueba"				: "guardarFilaPruebas"
    },
    initialize: function () {
    	this.templatePruebas = _.template($("#templatePruebas").html());
        this.templateEquipos = _.template($("#templateEquipos").html());
        this.templateEntrenamientos = _.template($("#templateEntrenamientos").html());
    },
    
    render: function () {
//        this.cargarTabs();
    	this.pruebas = new Asistente.pruebas();
        return this;
    },
    guardarEntrenamiento: function (fecha, idEntrenamiento) {
    	var that = this;
    	var stringFecha = fecha.year() + '-' + ('0' + (fecha.month() + 1)).slice(-2) + '-' + ('0' + fecha.date()).slice(-2) + ',' + ('0' + fecha.hour()).slice(-2) + ':' + ('0' + fecha.minutes()).slice(-2);
        var data = {
        		'id_equipo': this.idEquipo,
        	    'fecha': stringFecha
        };
        if(idEntrenamiento) {
        	data.id = idEntrenamiento;
        }
        $.ajax({
            type: 'POST',
            url: '/gestion/entrenamiento',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json'
        }).done(function(data) {
        	var evento = {
                    start: new Date(fecha.year(), fecha.month(), fecha.date(), fecha.hour(), fecha.minutes()),
                    allDay: false,
                    title: fecha.hour() + ':' + fecha.minutes()
                };
        	that.$el.find('.tab-pane.active .calendar').fullCalendar( 'renderEvent', evento);
        	that.cerrarModalEntrenamiento();
        }).fail(function() {
        	that.$el.find('#modal-agregar-entrenamiento .error').show();
        });
    },
    guardarFilaPruebas: function (e) {
        e.preventDefault();
        $(e.target).html('<button style="color:#C00; opacity: 2;" type="button" class="close boton-borrar-prueba">&times;</button>');
    },
    borrarFilaEntrenamientos: function(e) {
        e.preventDefault();
        $(e.target).parent().parent().remove();
    },
    borrarFilaPruebas: function(e) {
        e.preventDefault();
        $(e.target).parent().parent().parent().remove();
    },
    abrirModalEntrenamiento: function (e) {
        e.preventDefault();
        this.idEquipo = this.$el.find('.tab-pane.active').attr('id').split('-')[1];
        var now = moment().date() + '/' + (moment().month() + 1) + '/' + moment().year() + ' ' + moment().hour() + ':' + moment().minutes();
        var $modal = this.$el.find('#modal-agregar-entrenamiento');
        $modal.find('.datetime').text(now);
        $modal.show();
        $modal.find('.datetimepicker').datetimepicker({
            locale: 'es'
        });
        var date = new Date();
        $modal.find('.datetimepicker').data("DateTimePicker").date(date)
    },
    cerrarModalEntrenamiento: function (e) {
    	if(e) {
    		e.preventDefault();
    	}
        if (e && e.type === 'submit') {
        	var $dateTimePicker = $(e.target).find('.datetimepicker').data("DateTimePicker");
        	this.guardarEntrenamiento($dateTimePicker.date());
        } else {
        	this.$el.find('#modal-agregar-entrenamiento').hide();
            this.$el.find('#modal-agregar-entrenamiento .datetimepicker').data("DateTimePicker").destroy();
        }
        this.$el.find('#modal-agregar-entrenamiento .error').hide();
    },
    agregarFilaPruebas: function (e) {
        e.preventDefault();
        var nuevaFila = $('#placeholder-prueba').clone();
        nuevaFila.find('.distancia').val(25);
        nuevaFila.find('.estilo').val(1);
        nuevaFila.find('.tipoPrueba').val("");
        nuevaFila.find('.boton-borrar-prueba').addClass('boton-guardar-prueba').removeClass('boton-borrar-prueba');
        nuevaFila.find('.boton-guardar-prueba').css({'color':'#0000FF'});
        nuevaFila.find('.boton-guardar-prueba').text("\u2713");
        $(e.target).parent().parent().parent().append(nuevaFila);
    },
    mostrarEntrenamientos: function () {
        $('.active .pruebas').fadeOut(400, function () {
            $('#boton-volver-entrenamientos').addClass('hidden')
            $('.active .entrenamientos').fadeIn(400);
        });
    },
    cargarPruebas: function (e, dia, mes, ano) {
        e.preventDefault();
        var that = this;
        var idEquipo = parseInt($(e.target).parents('.tab-pane').attr("id").split("-")[1]);
        //var fechaOriginal = $(e.target).text().split("-");
        var fechaParseada = dia + "-" + mes + "-" + ano;
        var template = this.templatePruebas;
        this.$currentEl = $(e.target).parents('.tab-pane');
        var data = {
            'id_equipo': idEquipo,
            'fecha': fechaParseada
        };
        this.pruebas.fetch({
            data: JSON.stringify(data),
            success: function (collection, response, options) {
            	that.$currentEl.find('.pruebas').fadeOut(400, function () {
                    $(this).html(template({
                        pruebas: collection.toJSON()
                    }));
                    var that = $(this);
                    $('.active .entrenamientos').fadeOut(400, function () {
                        that.fadeIn(400);
                        $('#boton-volver-entrenamientos').removeClass('hidden');
                    });
                });
            },
            error: function (collection, xhr, options) {
                console.log("Error: ", xhr);
            }
        });
    },
    cargarTabs: function () {
        var self = this;
        var equipos = new Asistente.equipos();
        var template = this.templateEquipos;
        var $el = this.$el;
        var primerEquipo;
        
        var data = {
            'id_usuario': idUsuario
        };
        equipos.fetch({
            data: JSON.stringify(data),
            success: function (collection, response, options) {
                $el.find('#tabs-container').fadeOut(400, function () {
                    $(this).html(template({
                        equipos: collection.toJSON()
                    })).fadeIn(400);
                });
                self.cargarPrimerEntrenamiento(collection.models[0].id);;
            },
            error: function (collection, xhr, options) {
                console.log("Error: ", xhr);
            }
        });
    }
});