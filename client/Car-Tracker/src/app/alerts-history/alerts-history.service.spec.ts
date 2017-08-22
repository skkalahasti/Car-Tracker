import { TestBed, inject } from '@angular/core/testing';

import { AlertsHistoryService } from './alerts-history.service';

describe('AlertsHistoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AlertsHistoryService]
    });
  });

  it('should be created', inject([AlertsHistoryService], (service: AlertsHistoryService) => {
    expect(service).toBeTruthy();
  }));
});
