import { Component, OnInit, Input } from '@angular/core';
import { ApiService } from '../services/api.service';

@Component({
  selector: "input-data",
  template: `
  <label class="searchInfo">{{label}}:</label>
  <input class="form-control input-sm" [(ngModel)]="externalValue" (ngModelChange)="updateData($event)">
  `,
})
export class InputDataComponent implements OnInit {

  errorMessage: string;

  label: string;

  ngOnInit(): void {
  }

  constructor(protected apiService: ApiService) { }

  @Input('externalValue') externalValue: any;

  updateData(newValue: string): void {
    // this.apiService.getLinesByNome(newValue).subscribe(
      // lines => this.linesComponent.lines = lines['_embedded']['line'],
      // error => this.errorMessage = <any>error);
  }
}
