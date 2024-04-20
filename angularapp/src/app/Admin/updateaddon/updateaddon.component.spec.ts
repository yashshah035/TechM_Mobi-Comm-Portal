import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateaddonComponent } from './updateaddon.component';

describe('UpdateaddonComponent', () => {
  let component: UpdateaddonComponent;
  let fixture: ComponentFixture<UpdateaddonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateaddonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateaddonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
