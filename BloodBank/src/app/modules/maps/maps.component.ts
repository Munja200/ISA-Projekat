import { Component, OnInit, ViewChild } from '@angular/core';
import { MapInfoWindow, MapMarker } from '@angular/google-maps';

import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { MapsService } from '../hospital/services/maps.service';


@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.css']
})
export class MapsComponent implements OnInit {
  private serverUrl = "http://localhost:8080/" +"socket";
  private stompClient: any;
  isLoaded: boolean = false;
  public button : boolean =false;
  private pom: string ="";

  constructor(private mapService: MapsService) {}
  ngOnInit(): void {

    this.initializeWebSocketConnection();

  }
  @ViewChild(MapInfoWindow) infoWindow: MapInfoWindow | undefined;

  display: any;
  center: google.maps.LatLngLiteral = {
      lat: 8.681495,
      lng: 49.4146124
  };

  center1: google.maps.LatLngLiteral = {
    lat: 8.687872,
    lng: 49.980318
};

center2: google.maps.LatLngLiteral = {
  lat: 8.681495,
  lng: 49.346124
};

  zoom = 10;
  Dugme() {
    
    this.pom = this.center1.lat+","+this.center1.lng;
    console.log(this.pom)
    this.mapService.generateCords(this.pom).subscribe(res => {
      console.log(this.pom)
    });
    
}

  moveMap(event: google.maps.MapMouseEvent) {
      if (event.latLng != null) this.center = (event.latLng.toJSON());
  }
  move(event: google.maps.MapMouseEvent) {
      if (event.latLng != null) this.display = event.latLng.toJSON();
  }

  markerOptions: google.maps.MarkerOptions = {
    draggable: false,
 //   icon: '../assets/images/icon.png'
  };
  text:String = '';
  markerPositions: google.maps.LatLngLiteral[] = [];
    addMarker(event: google.maps.MapMouseEvent) {
    if (event.latLng != null) this.markerPositions.push(event.latLng.toJSON());
  }

  openInfoWindow(marker: MapMarker,pom : String) {
    this.text = pom;
    if (this.infoWindow != undefined) this.infoWindow.open(marker);
}



initializeWebSocketConnection() {
  // serverUrl je vrednost koju smo definisali u registerStompEndpoints() metodi na serveru
  let ws = new SockJS(this.serverUrl);
  this.stompClient = Stomp.over(ws);
  let that = this;
console.log(
  "radis"
)
  this.stompClient.connect({}, function () {
    that.isLoaded = true;
    that.openGlobalSocket()
  });

}
markers = []  as  any;

// Funckija za pretplatu na topic /socket-publisher (definise se u configureMessageBroker() metodi)
// Globalni socket se otvara prilikom inicijalizacije klijentske aplikacije
openGlobalSocket() {
  if (this.isLoaded) {
    this.stompClient.subscribe("/socket-publisher",(message: { body: string; }) => {
      let str = message.body.split(",");
      
      let lata = parseFloat(str[0]); 
      let lnga = parseFloat(str[1]);
      
      if(this.center1.lat == lata && this.center1.lng == lnga)
      {
          this.markers == [] as any;        
          this.button = false;
      } 
      this.button = true;

      this.markers.push({
        position: {
          lat:lata,
          lng: lnga
        },
        label: {
          color: 'blue',
          
        },

        options: {
          animation: google.maps.Animation.DROP,
        },
      })
        console.log(message.body)
        console.log(str[0],str[1])
        console.log(this.center2)
        });
  }
}
/* let str = message.split(",");
        this.center2.lat = parseFloat(str[0]);
        this.center2.lng = parseFloat(str[1]);*/

// Funkcija za pretplatu na topic /socket-publisher/user-id
// CustomSocket se otvara kada korisnik unese svoj ID u polje 'fromId' u submit callback-u forme 'userForm'
/*openSocket() {
  if (this.isLoaded) {
    this.isCustomSocketOpened = true;
    this.stompClient.subscribe("/socket-publisher/" + this.userForm.value.fromId, (message: { body: string; }) => {
      this.handleResult(message);
    });
  }
}
*/
// Funkcija koja se poziva kada server posalje poruku na topic na koji se klijent pretplatio
handleResult(message: { body: string; }) {
  if (message.body) {
    let str: string = JSON.parse(message.body);
    this.center2.lat = parseFloat(str[0]);
    this.center2.lng = parseFloat(str[1]);
  }
}



}
