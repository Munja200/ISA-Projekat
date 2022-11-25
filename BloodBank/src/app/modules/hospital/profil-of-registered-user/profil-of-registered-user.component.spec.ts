import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilOfRegisteredUserComponent } from './profil-of-registered-user.component';

describe('ProfilOfRegisteredUserComponent', () => {
  let component: ProfilOfRegisteredUserComponent;
  let fixture: ComponentFixture<ProfilOfRegisteredUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfilOfRegisteredUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfilOfRegisteredUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
