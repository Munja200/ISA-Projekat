import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProfilRegisteredUserComponent } from './edit-profil-registered-user.component';

describe('EditProfilRegisteredUserComponent', () => {
  let component: EditProfilRegisteredUserComponent;
  let fixture: ComponentFixture<EditProfilRegisteredUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditProfilRegisteredUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditProfilRegisteredUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
