import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateItinComponent } from './create-itin.component';

describe('CreateItinComponent', () => {
  let component: CreateItinComponent;
  let fixture: ComponentFixture<CreateItinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateItinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateItinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
