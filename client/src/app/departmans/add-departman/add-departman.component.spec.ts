import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDepartmanComponent } from './add-departman.component';

describe('AddDepartmanComponent', () => {
  let component: AddDepartmanComponent;
  let fixture: ComponentFixture<AddDepartmanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDepartmanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDepartmanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
