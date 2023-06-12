import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulingAppointmentComponent } from './scheduling-appointment.component';

describe('SchedulingAppointmentComponent', () => {
  let component: SchedulingAppointmentComponent;
  let fixture: ComponentFixture<SchedulingAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SchedulingAppointmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SchedulingAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
