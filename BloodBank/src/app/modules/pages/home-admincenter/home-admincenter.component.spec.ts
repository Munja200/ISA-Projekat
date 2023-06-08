import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeADMINCENTERComponent } from './home-admincenter.component';

describe('HomeADMINCENTERComponent', () => {
  let component: HomeADMINCENTERComponent;
  let fixture: ComponentFixture<HomeADMINCENTERComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeADMINCENTERComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeADMINCENTERComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
