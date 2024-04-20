import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListAddonComponent } from './admin-list-addon.component';

describe('AdminListAddonComponent', () => {
  let component: AdminListAddonComponent;
  let fixture: ComponentFixture<AdminListAddonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListAddonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListAddonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
