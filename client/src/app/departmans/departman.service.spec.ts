import { TestBed, inject } from '@angular/core/testing';

import { DepartmanService } from './departman.service';

describe('DepartmanService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DepartmanService]
    });
  });

  it('should be created', inject([DepartmanService], (service: DepartmanService) => {
    expect(service).toBeTruthy();
  }));
});
