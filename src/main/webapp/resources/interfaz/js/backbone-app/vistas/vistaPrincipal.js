var Asistente = Asistente || {};
Asistente.vistaPrincipal = Backbone.View.extend({
    el: "#contenedor-aplicacion",
    events: {
        "click .nav-tabs a"									: "mostrarEntrenamientos",
        "eventselected .entrenamientos a"					: "cargarPruebas",
        "click #boton-volver-entrenamientos"				: "mostrarEntrenamientos",
        "click .entrenamientos .boton-borrar-entrenamiento"	: "borrarEntrenamiento",
        "click .pruebas .boton-borrar-prueba"				: "borrarPrueba",
        "click .nuevo-entrenamiento"						: "abrirModalEntrenamiento",
        "click .modal-background"							: "cerrarModalEntrenamiento",
        "click .form-guardar-entrenamiento .cerrar"			: "cerrarModalEntrenamiento",
        "click .pruebas .boton-agregar-prueba"				: "agregarFilaPruebas",
        "submit .form-guardar-entrenamiento"				: "cerrarModalEntrenamiento",
        "click .pruebas .boton-guardar-prueba"				: "guardarPrueba"
    },
    initialize: function () {
    	this.templatePruebas = _.template($("#templatePruebas").html());
    },
    
    render: function () {
    	this.entrenamientos = new Asistente.entrenamientos();
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
            url: '/entrenamientos',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json'
        }).done(function(data) {
        	var evento = {
        			id: parseInt(data.id[0]),
                    start: new Date(fecha.year(), fecha.month(), fecha.date(), fecha.hour(), fecha.minutes()),
                    allDay: false,
                    title: fecha.hour() + ':' + fecha.minutes()
                };
        	if (idEntrenamiento) {
        		that.$el.find('.tab-pane.active .calendar').fullCalendar('removeEvents', idEntrenamiento);
        	}
        	that.$el.find('.tab-pane.active .calendar').fullCalendar( 'renderEvent', evento);
        	if (!idEntrenamiento) {
        		that.cerrarModalEntrenamiento();
        	}
        }).fail(function() {
        	that.$el.find('#modal-agregar-entrenamiento .error').show();
        });
    },
    guardarPrueba: function (e) {
        e.preventDefault();
        var dataContainer = $(e.target).parents('tr');
        var data = {
            'id_entrenamiento': this.idEntrenamiento,
            'distancia': parseInt(dataContainer.find('.distancia').val()),
            'estilo': parseInt(dataContainer.find('.estilo').val()),
            'consecutivo': dataContainer.index(),
            'tipo': dataContainer.find('.tipoPrueba').val()
        };
        console.log(data);
        $(e.target).parent().html('<button style="color:#C00; opacity: 2;" type="button" class="close boton-borrar-prueba">&times;</button>');
    },
    borrarEntrenamiento: function(e) {
        e.preventDefault();
        $(e.target).parent().parent().remove();
    },
    borrarPrueba: function(e) {
        e.preventDefault();
        $(e.target).parents('tr').remove();
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
        $modal.find('.datetimepicker').data("DateTimePicker").date(date);
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
        nuevaFila.removeAttr('id');
        nuevaFila.find('.distancia').val(25);
        nuevaFila.find('.estilo').val(1);
        nuevaFila.find('.tipoPrueba').val("");
        nuevaFila.find('.boton-borrar-prueba').addClass('boton-guardar-prueba').removeClass('boton-borrar-prueba');
        nuevaFila.find('.boton-guardar-prueba').css({'color':'#0000FF'});
        nuevaFila.find('.boton-guardar-prueba').text("\u2713");
        $(e.target).parent().parent().parent().append(nuevaFila);
    },
    mostrarEntrenamientos: function () {
    	if(this.$el.find('.pruebas .datos-entrenamiento').length) {
    		this.$el.find('.pruebas .datos-entrenamiento').data("DateTimePicker").destroy();
    	}
    	$('.active .pruebas').fadeOut(400, function () {
            $('#boton-volver-entrenamientos').addClass('hidden')
            $('.active .entrenamientos').fadeIn(400);
        });
    },
    cargarPruebas: function (e, dia, mes, ano, hora, minutos, idEntrenamiento) {
        e.preventDefault();
        var that = this;
        var idEquipo = parseInt($(e.target).parents('.tab-pane').attr("id").split("-")[1]);
        //var fechaOriginal = $(e.target).text().split("-");
        var fechaParseada = dia + '-' + mes + '-' + ano + ',' + hora + ':' + minutos;
        var template = this.templatePruebas;
        this.$currentEl = $(e.target).parents('.tab-pane');
        this.pruebas.setParams(idEquipo, fechaParseada);
        this.pruebas.fetch({
            success: function (collection, response, options) {
            	if(idEntrenamiento) {
            		that.idEntrenamiento = parseInt(idEntrenamiento);
            	}
            	that.idEquipo = idEquipo;
            	
        		var fecha = new Date(ano, (mes-1), dia, hora, minutos);
            	that.$currentEl.find('.pruebas').fadeOut(400, function () {
                    $(this).html(template({
                        pruebas: collection.toJSON()
                    }));
                    $(this).find('.datos-entrenamiento').datetimepicker({locale: 'es'});
                    $(this).find('.datos-entrenamiento').data("DateTimePicker").date(fecha);
                    $(this).find('.datos-entrenamiento').on('dp.change', function (e) {
                        e.preventDefault();
                        var nuevaFecha = $(e.target).data("DateTimePicker").date()
                        that.guardarEntrenamiento(nuevaFecha, that.idEntrenamiento);
                    });
                    var self = $(this);
                    
                    $('.active .entrenamientos').fadeOut(400, function () {
                    	self.fadeIn(400);
                        $('#boton-volver-entrenamientos').removeClass('hidden');
                    });
                });
            },
            error: function (collection, xhr, options) {
                console.log("Error: ", xhr);
            },
            type: 'GET'
            /*type: 'POST',
            contentType: 'application/json',
            dataType: 'json'*/
        });
    }
});