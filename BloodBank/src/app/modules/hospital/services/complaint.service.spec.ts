import { TestBed } from '@angular/core/testing';

import { RegisterComplaintService } from './complaint.service';

describe('RegisterComplaintService', () => {
  let service: RegisterComplaintService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterComplaintService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
