import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Com323Component } from './com323.component';

describe('Com323Component', () => {
  let component: Com323Component;
  let fixture: ComponentFixture<Com323Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Com323Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Com323Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
