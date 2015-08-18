var idUsuario = -1;
var vistaPrincipal;
$(document).ready(
		function() {
			$.ajaxPrefilter(function(options, originalOptions, jqXHR) {
				var token;
				if (!options.crossDomain) {
					token = csrfToken;
					if (token) {
						return jqXHR.setRequestHeader('X-CSRF-Token', token);
					}
				}
			});
			$('.nav-tabs a').click(function(e) {
						e.preventDefault();
						var $selectedElement = $(this);
						$selectedElement.tab('show');
						$('#tab-' + $selectedElement.attr('data-id-equipo') + ' .calendar').fullCalendar('render');
					});
			$.get("/recursos/interfaz/template.html", function(data) {
				$('body').append(data);
				window.vistaPrincipal = new window.Asistente.vistaPrincipal()
						.render();
			}, "html");
			var entrenamientosEquipo = [],
				dayCounter = 1,
				currentDay; 
			Swimcr.listaEntrenamientos.forEach(function(arregloEntrenamientos) {
				var eventosCalendario = [];
				arregloEntrenamientos.entrenamientos.forEach(function(
						entrenamiento) {
					var splittedDate = entrenamiento.fecha.split(' ');
					if(splittedDate.length > 1) {
						if (currentDay === splittedDate[0]) {
							dayCounter++;
						} else {
							currentDay = splittedDate[0];
							dayCounter = 1;
						}
						var date = splittedDate[0].split('-')
						var hours = splittedDate[1].split(':')
						var dateElements = date.concat(hours);
						eventosCalendario.push({
							id : entrenamiento.id,
							title : 'Entrenamiento ' + dayCounter,
							start : new Date(dateElements[0], (dateElements[1] - 1),
									dateElements[2], dateElements[3], dateElements[4]),
							allDay : false
						});
					}
				});
				$('#tab-' + arregloEntrenamientos.idEquipo + ' .calendar').fullCalendar({
					header : {
						left : 'prev,next',
						center : 'title',
						right : 'today, month,agendaWeek,agendaDay'
					},
					editable : true,
					events : eventosCalendario,
					eventClick : function(calEvent, jsEvent, view) {
						$(this).trigger('eventselected', [calEvent.start.date(), (calEvent.start.month() + 1), calEvent.start.year(), calEvent.start.hour(), calEvent.start.minutes(), calEvent.id]);
						//alert('Event: ' + calEvent.title);
						//alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
						//alert('View: ' + view.name);

						// change the border color just for fun
						$(this).css('border-color', 'red');

					},
					timeFormat: 'h(:mm)t',
					buttonText : {
						prev : "anterior",
						next : "siguiente",
						prevYear : "año anterior",
						nextYear : "siguiente año",
						year : 'año', // TODO: locale files
						// need to
						// specify this
						today : 'hoy',
						month : 'mes',
						week : 'semana',
						day : 'dia'
					}
				});
			});
			$('.fc-left').append('<button type="button" class="nuevo-entrenamiento fc-button fc-state-default fc-corner-left fc-corner-right">Nuevo Entrenamiento</button>');
		});