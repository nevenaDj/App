import { TestBed, inject } from '@angular/core/testing';

import { ExaminationPeriodService } from './examination-period.service';

describe('ExaminationPeriodService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExaminationPeriodService]
    });
  });

  it('should be created', inject([ExaminationPeriodService], (service: ExaminationPeriodService) => {
    expect(service).toBeTruthy();
  }));
});
