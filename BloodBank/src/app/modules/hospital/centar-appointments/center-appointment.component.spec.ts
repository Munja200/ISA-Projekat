import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterAppointmentComponent } from './center-appointment.component';

describe('CenterAppointmentComponent', () => {
  let component: CenterAppointmentComponent;
  let fixture: ComponentFixture<CenterAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CenterAppointmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CenterAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
