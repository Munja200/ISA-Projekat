import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterCenterAdministratorComponent } from './register-centerAdministrator.component';

describe('RegisterCenterAdministratorComponent', () => {
  let component: RegisterCenterAdministratorComponent;
  let fixture: ComponentFixture<RegisterCenterAdministratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterCenterAdministratorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterCenterAdministratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
