import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZakazivanjeTerminaComponent } from './zakazivanje-termina.component';

describe('ZakazivanjeTerminaComponent', () => {
  let component: ZakazivanjeTerminaComponent;
  let fixture: ComponentFixture<ZakazivanjeTerminaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZakazivanjeTerminaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ZakazivanjeTerminaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
