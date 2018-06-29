import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplyingExamComponent } from './applying-exam.component';

describe('ApplyingExamComponent', () => {
  let component: ApplyingExamComponent;
  let fixture: ComponentFixture<ApplyingExamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplyingExamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplyingExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
