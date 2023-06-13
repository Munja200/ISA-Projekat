import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OccupiedCalendarAdminComponent } from './occupied-calendar-admin.component';

describe('OccupiedCalendarAdminComponent', () => {
  let component: OccupiedCalendarAdminComponent;
  let fixture: ComponentFixture<OccupiedCalendarAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OccupiedCalendarAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OccupiedCalendarAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
