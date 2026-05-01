import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-patientcreate',
  templateUrl: './patientcreate.component.html',
  styleUrls: ['./patientcreate.component.scss']
})
export class PatientCreateComponent implements OnInit {
  patientForm!: FormGroup;

  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm(): void {
    this.patientForm = this.formBuilder.group({
      patientId: [null, [Validators.required, Validators.min(1)]],
      fullName: ['', [Validators.required, Validators.minLength(2)]],
      dateOfBirth: ['', Validators.required],
      contactNumber: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', [Validators.required, Validators.minLength(5)]]
    });
  }

  onSubmit(): void {
    if (this.patientForm.valid) {
      this.successMessage = 'Patient has been successfully created!';
      this.errorMessage = null;

      console.log('Patient Created:', this.patientForm.value);

      this.resetForm();
    } else {
      this.errorMessage = 'Please fill out all required fields correctly.';
      this.successMessage = null;

      this.patientForm.markAllAsTouched();
    }
  }

  resetForm(): void {
    this.patientForm.reset({
      patientId: null,
      fullName: '',
      dateOfBirth: '',
      contactNumber: '',
      email: '',
      address: ''
    });

    this.successMessage = null;
    this.errorMessage = null;
  }

  get patientId() {
    return this.patientForm.get('patientId');
  }

  get fullName() {
    return this.patientForm.get('fullName');
  }

  get dateOfBirth() {
    return this.patientForm.get('dateOfBirth');
  }

  get contactNumber() {
    return this.patientForm.get('contactNumber');
  }

  get email() {
    return this.patientForm.get('email');
  }

  get address() {
    return this.patientForm.get('address');
  }
}