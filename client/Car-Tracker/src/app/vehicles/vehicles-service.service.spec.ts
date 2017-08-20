import { TestBed, inject } from '@angular/core/testing';

import { VehiclesService } from './vehicles-service.service';

describe('VehiclesServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VehiclesService]
    });
  });

  it('should be created', inject([VehiclesService], (service: VehiclesService) => {
    expect(service).toBeTruthy();
  }));
});
