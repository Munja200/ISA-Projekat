import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeCenterAdminComponent } from './homeCenterAdmin.component';

describe('HomeCenterAdminComponent', () => {
  let component: HomeCenterAdminComponent;
  let fixture: ComponentFixture<HomeCenterAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeCenterAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeCenterAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
