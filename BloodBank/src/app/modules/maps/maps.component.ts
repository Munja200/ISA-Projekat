import { Component, OnInit, ViewChild } from '@angular/core';
import { MapInfoWindow, MapMarker } from '@angular/google-maps';


@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.css']
})
export class MapsComponent implements OnInit {
  constructor() {}
  ngOnInit(): void {}
  @ViewChild(MapInfoWindow) infoWindow: MapInfoWindow | undefined;

  display: any;
  center: google.maps.LatLngLiteral = {
      lat: 24,
      lng: 12
  };

  center1: google.maps.LatLngLiteral = {
    lat: 24,
    lng: 18
};
  zoom = 4;
  moveMap(event: google.maps.MapMouseEvent) {
      if (event.latLng != null) this.center = (event.latLng.toJSON());
  }
  move(event: google.maps.MapMouseEvent) {
      if (event.latLng != null) this.display = event.latLng.toJSON();
  }

  markerOptions: google.maps.MarkerOptions = {
    draggable: false,
    icon: '../assets/images/icon.png'
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

}
