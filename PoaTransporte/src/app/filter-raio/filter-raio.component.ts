import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { Line } from '../lines/line';
import { Router } from '@angular/router';

@Component({
  selector: 'app-filter-raio',
  templateUrl: './filter-raio.component.html',
  styleUrls: ['./filter-raio.component.css']
})
export class FilterRaioComponent implements OnInit {

  errorMessage: string;
  linesByRaio: FormGroup;
  isSubmitted = false;
  lines: Line[];

  constructor(private router: Router, private formBuilder: FormBuilder, protected apiService: ApiService) { }

  ngOnInit() {
    this.linesByRaio = this.formBuilder.group({
      latitud: [''],
      longitud: [''],
      raio: [''],
    });
  }

  getLinesByRaio() {
    this.apiService.getLinesByRaio(this.linesByRaio.value.latitud, this.linesByRaio.value.longitud, this.linesByRaio.value.raio).subscribe(
      lines => this.lines = lines,
      error => this.errorMessage = <any>error
    );
  }

  goToItinerary(id: string, nome: string, codigo: string) {
    this.router.navigate(['/itinerary'], { queryParams: { id: id, nome: nome, codigo: codigo } });
  }
}
