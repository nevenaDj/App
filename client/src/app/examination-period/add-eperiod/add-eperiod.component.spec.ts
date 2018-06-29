import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEperiodComponent } from './add-eperiod.component';

describe('AddEperiodComponent', () => {
  let component: AddEperiodComponent;
  let fixture: ComponentFixture<AddEperiodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddEperiodComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEperiodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
