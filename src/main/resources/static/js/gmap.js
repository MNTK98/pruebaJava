 function initMap(){
   	let map;
   	let marker;
   	//Geolocalization
   	let watchId;
   	let geoLoc;
   	let myLatLng;	 
   	myLatLng = {lat: 19.4193404 , lng:-99.1788412};
   	map=new google.maps.Map(document.getElementById("map"),{
   				 zoom: 16,
   				 center:myLatLng,
   				 });
   			 	marker= new google.maps.Marker ({
   				 position: myLatLng, 
   				 map: map,
   				draggable: true,
   				 title: "Coordenadas",
   				 icon:{url:"/imagen/iconmap.png", scaledSize: new google.maps.Size(35, 55)},
   				 });
   				markerCoords(marker);
   			 	getPosition();
			}
   		 
   		function markerCoords(markerobject){
   		    google.maps.event.addListener(markerobject, 'dragend', function(evt){
   		        infoWindow.setOptions({
   		            content: '<p>Marker dropped: Current Lat: ' + evt.myLatLng.lat().toFixed(3) + ' Current Lng: ' + evt.myLatLng.lng().toFixed(3) + '</p>'
   		        });
   		     	latitud=position.coords.latitude;
			 	 longitud=position.coords.longitude;
			 	 console.log("Latitud: ", latitud ," Longitud: " ,longitud);
				  marker.getPosition();
   		        infoWindow.open(map, markerobject);
   		    });

   		    google.maps.event.addListener(markerobject, 'drag', function(evt){
   		        console.log("marker is being dragged");
   		    });     
   		}
   			  function getPosition(){
   				  if(navigator.geolocation){
   					 let options={timeout:60000};
   					 geoLoc=navigator.geolocation;
   					 wacthId=geoLoc.watchPosition(showLocationOnMap, errorHnadler, options);
   				 
   				  } else {
   					  alert("Lo sentimos, el exploador no soporta golacalizacion");
   				  }
   			  }
   			  
   			 
   			  function showLocationOnMap(position){
   				  let latitud=position.coords.latitude;
   				  let longitud=position.coords.longitude;
   				  console.log("Latitud: ", latitud ," Longitud: " ,longitud);
   				  let myLatLng= {lat: latitud, lng: longitud };
   				  marker.setPosition(myLatLng);
   				  map.setCenter(myLatLng);
				  /*google.maps.event.addListener( marker ,  'dragend', function() {
					  latitud=position.coords.latitude;
					  longitud=position.coords.longitude;
					  console.log("Latitud: ", latitud ," Longitud: " ,longitud);
					  marker.getPosition();
    			  }*/
   			  }
   			  function errorHnadler(err){
   				  if(err.code==1){
   					  alert("Error: Acceso denegado!");
   				  } else if( err.code == 2){
   					  alert("Error: Position no existe o no se encuentra!");
   				  }
   			  }
   			  
   			