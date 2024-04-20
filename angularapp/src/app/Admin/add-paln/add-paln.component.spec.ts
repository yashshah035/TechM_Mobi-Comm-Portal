import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPalnComponent } from './add-paln.component';

describe('AddPalnComponent', () => {
  let component: AddPalnComponent;
  let fixture: ComponentFixture<AddPalnComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPalnComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPalnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
