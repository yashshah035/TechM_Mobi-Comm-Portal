import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowNotifyComponent } from './show-notify.component';

describe('ShowNotifyComponent', () => {
  let component: ShowNotifyComponent;
  let fixture: ComponentFixture<ShowNotifyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowNotifyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowNotifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
