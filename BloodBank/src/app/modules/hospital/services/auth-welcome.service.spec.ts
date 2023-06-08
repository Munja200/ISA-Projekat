import { TestBed } from '@angular/core/testing';

import { AuthWelcomeService } from './auth-welcome.service';

describe('AuthWelcomeService', () => {
  let service: AuthWelcomeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthWelcomeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
