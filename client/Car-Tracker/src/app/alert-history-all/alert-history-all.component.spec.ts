import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlertHistoryAllComponent } from './alert-history-all.component';

describe('AlertHistoryAllComponent', () => {
  let component: AlertHistoryAllComponent;
  let fixture: ComponentFixture<AlertHistoryAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlertHistoryAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlertHistoryAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
