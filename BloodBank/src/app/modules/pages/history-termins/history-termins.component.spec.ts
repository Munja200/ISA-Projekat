import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoryTerminsComponent } from './history-termins.component';

describe('HistoryTerminsComponent', () => {
  let component: HistoryTerminsComponent;
  let fixture: ComponentFixture<HistoryTerminsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistoryTerminsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HistoryTerminsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
