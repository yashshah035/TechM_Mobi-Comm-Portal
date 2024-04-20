import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListPaymentComponent } from './admin-list-payment.component';

describe('AdminListPaymentComponent', () => {
  let component: AdminListPaymentComponent;
  let fixture: ComponentFixture<AdminListPaymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListPaymentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
