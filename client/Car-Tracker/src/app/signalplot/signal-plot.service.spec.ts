import { TestBed, inject } from '@angular/core/testing';

import { SignalPlotService } from './signal-plot.service';

describe('SignalPlotService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SignalPlotService]
    });
  });

  it('should be created', inject([SignalPlotService], (service: SignalPlotService) => {
    expect(service).toBeTruthy();
  }));
});
