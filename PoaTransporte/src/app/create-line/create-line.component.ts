import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { Line } from '../lines/line';

@Component({
  selector: 'app-create-line',
  templateUrl: './create-line.component.html',
  styleUrls: ['./create-line.component.css']
})
export class CreateLineComponent implements OnInit {

  errorMessage: string;
  createLines: FormGroup;
  isSubmitted = false;
  line: Line;

  constructor(private formBuilder: FormBuilder, protected apiService: ApiService) { }

  ngOnInit() {
    this.createLines = this.formBuilder.group({
      id: [''],
      nome: [''],
      codigo: [''],
    });
  }

  createLine() {
    this.apiService.createLine(new Line(this.createLines.value.id, this.createLines.value.nome, this.createLines.value.codigo)).subscribe(
      line => {
        alert("CRIADO LINHA: " + this.createLines.value.id);
        this.line = line;
      },
      error => this.errorMessage = <any>error
    );
  }
}
