import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmailService } from 'src/app/services/email.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  contactForm: FormGroup;

  constructor(private fb: FormBuilder,private emailService:EmailService) {
    this.contactForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      subject: ['', Validators.required],
      message: ['', Validators.required],
    });
  }

  ngOnInit(): void {

  }

  onSubmit() {
    if (this.contactForm.valid) {
      const formData = this.contactForm.value;

  
      this.emailService.sendEmail(formData).subscribe(
        response => {
          console.log('Email sent successfully', response);
    
        },
        error => {
          console.error('Error sending email', error);
      
        }
      );
    }
  }


}
