import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ApiService } from '../services/api.service';
import { Line } from './line';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lines',
  templateUrl: './lines.component.html',
  styleUrls: ['./lines.component.css']
})
export class LinesComponent implements OnInit {

  lines: Line[];
  errorMessage: string;
  tableRef: HTMLTableElement;

  constructor(private router: Router, protected apiService: ApiService) { }

  ngOnInit() {
    this.apiService.getLines().subscribe(
      response => this.lines = response['_embedded']['line'],
      error => this.errorMessage = <any>error);
  }

  goToItinerary(id: string, nome: string, codigo: string) {
    this.router.navigate(['/itinerary'], { queryParams: { id: id, nome: nome, codigo: codigo } });
  }

  delete(line: Line) {
    this.apiService.deleteLine(line.id).subscribe(
      data => {
        this.lines.splice(this.lines.indexOf(line), 1);
        alert('LINHA ' + line.id + ' DELETED');
      },
      error => this.errorMessage = <any>error);
  }
}

