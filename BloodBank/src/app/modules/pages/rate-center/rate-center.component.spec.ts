import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RateCenterComponent } from './rate-center.component';

describe('RateCenterComponent', () => {
  let component: RateCenterComponent;
  let fixture: ComponentFixture<RateCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RateCenterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RateCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
