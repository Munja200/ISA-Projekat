import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SearchRegisteredPersons } from './search-RegisteredPersons.component';

describe('SearchRegisteredUsers', () => {
  let component: SearchRegisteredPersons;
  let fixture: ComponentFixture<SearchRegisteredPersons>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchRegisteredPersons ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchRegisteredPersons);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
