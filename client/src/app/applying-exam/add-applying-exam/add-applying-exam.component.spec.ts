import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddApplyingExamComponent } from './add-applying-exam.component';

describe('AddApplyingExamComponent', () => {
  let component: AddApplyingExamComponent;
  let fixture: ComponentFixture<AddApplyingExamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddApplyingExamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddApplyingExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
