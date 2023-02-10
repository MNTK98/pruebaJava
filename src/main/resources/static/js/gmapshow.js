 	[(${works})]
   	
   	
   		let map;
   		let marker;
		//Geolocalization
		let myLatLng;
		var lati="${works.latitud}"
		
		 function initMap(){
			 myLatLng = {lat: 19.4193404 , lng:-99.1788412};
				map=new google.maps.Map(document.getElementById("map"),{
				 zoom: 16,
				 center:myLatLng,
				 });
			 	marker= new google.maps.Marker ({
				 position: myLatLng, 
				 map: map,		
				 title: "Coordenadas",
				 icon:{url:"/imagen/iconmap.png", scaledSize: new google.maps.Size(35, 55)},
				 });
			 	console.log(myLatLng,lati);
		}
/*]]>*/