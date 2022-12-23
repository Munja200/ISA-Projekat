import { TestBed } from '@angular/core/testing';

import { AuthCenterAdminGuard } from './authCenterAdmin.guard';

describe('AuthCenterAdminGuard', () => {
  let service: AuthCenterAdminGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthCenterAdminGuard);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
