
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-doctorcreate',
  templateUrl: './doctorcreate.component.html',
  styleUrls: ['./doctorcreate.component.scss']
})
export class DoctorCreateComponent implements OnInit {
  doctorForm!: FormGroup;

  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm(): void {
    this.doctorForm = this.formBuilder.group({
      doctorId: [null, [Validators.required, Validators.min(1)]],
      fullName: ['', [Validators.required, Validators.minLength(2)]],
      specialty: ['', Validators.required],
      contactNumber: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      email: ['', [Validators.required, Validators.email]],
      yearsOfExperience: [null, [Validators.required, Validators.min(1)]]
    });
  }

  onSubmit(): void {
    if (this.doctorForm.valid) {
      this.successMessage = 'Doctor has been successfully created!';
      this.errorMessage = null;

      console.log('Doctor Created:', this.doctorForm.value);

      this.resetForm();
    } else {
      this.errorMessage = 'Please fill out all required fields correctly.';
      this.successMessage = null;

      this.doctorForm.markAllAsTouched();
    }
  }

  resetForm(): void {
    this.doctorForm.reset({
      doctorId: null,
      fullName: '',
      specialty: '',
      contactNumber: '',
      email: '',
      yearsOfExperience: null
    });

    // this.successMessage = null;
    // this.errorMessage = null;
  }

  get doctorId() {
    return this.doctorForm.get('doctorId');
  }

  get fullName() {
    return this.doctorForm.get('fullName');
  }

  get specialty() {
    return this.doctorForm.get('specialty');
  }

  get contactNumber() {
    return this.doctorForm.get('contactNumber');
  }

  get email() {
    return this.doctorForm.get('email');
  }

  get yearsOfExperience() {
    return this.doctorForm.get('yearsOfExperience');
  }
}