import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListPlanComponent } from './admin-list-plan.component';

describe('AdminListPlanComponent', () => {
  let component: AdminListPlanComponent;
  let fixture: ComponentFixture<AdminListPlanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListPlanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListPlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
