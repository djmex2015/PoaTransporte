import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { inlineInterpolate } from '@angular/core/src/view';
import { Line } from '../lines/line';
import { Itinerary } from '../itinerary/itinerary';

@Component({
  selector: 'app-create-itin',
  templateUrl: './create-itin.component.html',
  styleUrls: ['./create-itin.component.css']
})
export class CreateItinComponent implements OnInit {

  errorMessage: string;
  createItin: FormGroup;
  isSubmitted = false;
  itin: Itinerary;
  idLines: Line[];

  constructor(private formBuilder: FormBuilder, protected apiService: ApiService) { }

  ngOnInit() {
    this.createItin = this.formBuilder.group({
      idLine: [''],
      index: [''],
      latitud: [''],
      longitud: ['']
    });
    this.apiService.getIdLines().subscribe(
      idLines => this.idLines= idLines['_embedded']['line'].sort(),
      error => this.errorMessage = <any>error
    )
  }

  createItinerary() {
    this.apiService.createItinerary(new Itinerary({ 'idLine': this.createItin.value.idLine, 'index': this.createItin.value.index }, this.createItin.value.latitud, this.createItin.value.longitud)).subscribe(
      itin => {
        alert("CRIADO ITINERARIO: " + this.createItin.value.idLine);
        this.itin = itin;
        this.createItin.reset();
      },
      error => this.errorMessage = <any>error
    );
  }
}
