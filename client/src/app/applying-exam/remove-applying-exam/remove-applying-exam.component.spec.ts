import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveApplyingExamComponent } from './remove-applying-exam.component';

describe('RemoveApplyingExamComponent', () => {
  let component: RemoveApplyingExamComponent;
  let fixture: ComponentFixture<RemoveApplyingExamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemoveApplyingExamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoveApplyingExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
