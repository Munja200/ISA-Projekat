import { TestBed } from '@angular/core/testing';

import { AuthAdminGuard } from './authAdmin.guard';

describe('AuthAdminGuard', () => {
  let service: AuthAdminGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthAdminGuard);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
