import { TestBed, inject } from '@angular/core/testing';

import { LogoServiceService } from './logo-service.service';

describe('LogoServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LogoServiceService]
    });
  });

  it('should be created', inject([LogoServiceService], (service: LogoServiceService) => {
    expect(service).toBeTruthy();
  }));
});
