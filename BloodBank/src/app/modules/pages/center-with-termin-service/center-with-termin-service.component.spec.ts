import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterWithTerminServiceComponent } from './center-with-termin-service.component';

describe('CenterWithTerminServiceComponent', () => {
  let component: CenterWithTerminServiceComponent;
  let fixture: ComponentFixture<CenterWithTerminServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CenterWithTerminServiceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CenterWithTerminServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
