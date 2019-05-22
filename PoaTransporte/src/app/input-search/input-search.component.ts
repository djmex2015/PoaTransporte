import { Component, OnInit, Input } from '@angular/core';
import { ApiService } from '../services/api.service';
import { LinesComponent } from '../lines/lines.component';

@Component({
  selector: "input-search",
  template: `
  <label class="searchInfo">Search:</label>
  <input class="form-control input-sm" [(ngModel)]="externalValue" (ngModelChange)="updateData($event)">
  `,
})
export class InputSearchComponent implements OnInit {

  errorMessage: string;

  ngOnInit(): void {
  }

  constructor(protected apiService: ApiService, protected linesComponent: LinesComponent) { }

  @Input('externalValue') externalValue: any;

  updateData(newValue: string): void {
    this.apiService.getLinesByNome(newValue).subscribe(
      lines => this.linesComponent.lines = lines['_embedded']['line'],
      error => this.errorMessage = <any>error);
  }
}

