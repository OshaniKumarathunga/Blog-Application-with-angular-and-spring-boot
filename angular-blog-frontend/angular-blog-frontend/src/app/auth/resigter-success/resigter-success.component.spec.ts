import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResigterSuccessComponent } from './resigter-success.component';

describe('ResigterSuccessComponent', () => {
  let component: ResigterSuccessComponent;
  let fixture: ComponentFixture<ResigterSuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResigterSuccessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResigterSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
