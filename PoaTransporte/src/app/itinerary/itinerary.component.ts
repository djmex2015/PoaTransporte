import { Component, OnInit, Input } from '@angular/core';
import { ApiService } from '../services/api.service';
import { ActivatedRoute } from '@angular/router';
import { Itinerary } from './itinerary';

@Component({
  selector: 'app-itinerary',
  templateUrl: './itinerary.component.html',
  styleUrls: ['./itinerary.component.css']
})
export class ItineraryComponent implements OnInit {

  @Input() id: string;
  itinerary: Itinerary[];
  errorMessage: string;
  nome: string;
  codigo: string;
  index: string;

  constructor(protected apiService: ApiService, private route: ActivatedRoute) { }

  ngOnInit() {
    let snap = this.route.snapshot;
    this.id = snap.queryParamMap.get('id');
    this.nome = snap.queryParamMap.get('nome');
    this.codigo = snap.queryParamMap.get('codigo');

    this.apiService.getItinerary(this.id).subscribe(
      itinerary => this.itinerary = this.getPositions(itinerary['_embedded']['itinerary']),
      error => this.errorMessage = <any>error
    )
  }

  getPositions(itinerary: Itinerary) {
    delete itinerary['idLine'];
    delete itinerary['index'];
    return Object.values(itinerary);
  }
}

