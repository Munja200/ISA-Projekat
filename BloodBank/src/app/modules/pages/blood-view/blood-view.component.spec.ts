import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodViewComponent } from './blood-view.component';

describe('BloodViewComponent', () => {
  let component: BloodViewComponent;
  let fixture: ComponentFixture<BloodViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloodViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloodViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
