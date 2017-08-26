import { TestBed, inject } from '@angular/core/testing';

import { AlertHistoyAllService } from './alert-histoy-all.service';

describe('AlertHistoyAllService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AlertHistoyAllService]
    });
  });

  it('should be created', inject([AlertHistoyAllService], (service: AlertHistoyAllService) => {
    expect(service).toBeTruthy();
  }));
});
