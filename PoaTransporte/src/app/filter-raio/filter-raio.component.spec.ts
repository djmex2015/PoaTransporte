import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterRaioComponent } from './filter-raio.component';

describe('FilterRaioComponent', () => {
  let component: FilterRaioComponent;
  let fixture: ComponentFixture<FilterRaioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilterRaioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterRaioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
