import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignalplotComponent } from './signalplot.component';

describe('SignalplotComponent', () => {
  let component: SignalplotComponent;
  let fixture: ComponentFixture<SignalplotComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignalplotComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignalplotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
