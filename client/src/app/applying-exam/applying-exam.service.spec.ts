import { TestBed, inject } from '@angular/core/testing';

import { ApplyingExamService } from './applying-exam.service';

describe('ApplyingExamService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ApplyingExamService]
    });
  });

  it('should be created', inject([ApplyingExamService], (service: ApplyingExamService) => {
    expect(service).toBeTruthy();
  }));
});
