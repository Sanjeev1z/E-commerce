import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  AbstractControl,
  ValidatorFn,
  Validators,
} from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from 'src/app/core/services/user.service';

// function notEmptyValidator(): ValidatorFn {
//   return (control: AbstractControl): { [key: string]: any } | null => {
//     const value = control.value;
//     console.log('Value:', value); // Logging the value

//     if (!value || value.trim().length === 0) {
//       console.log('Validation Error: Value is empty');
//       return { notEmpty: true };
//     }

//     if (value.trim().length !== value.length) {
//       console.log('Validation Error: Value contains whitespace only');
//       return { whitespaceOnly: true };
//     }

//     console.log('Validation Passed');
//     return null;
//   };
// }

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  // user = {
  //   userName: '',
  //   password: '',
  //   firstName: '',
  //   lastName: '',
  //   email: '',
  //   phone: '',
  //   profile: '',
  // }

  signUpForm = this.fb.group({
    username: ['', Validators.required],
    password: ['', [Validators.required, Validators.minLength(6)]],
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    email: [
      '',
      [
        Validators.required,
        Validators.pattern(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/),
      ],
    ],
    phone: ['', [Validators.required, Validators.pattern(/^[0-9]{10}$/)]],
    profile: [''],
  });

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private snackBar: MatSnackBar,
    private router: Router
  ) {}

  ngOnInit(): void {}

  submitForm() {
    if (this.signUpForm.valid) {
      console.log('Password value:', this.signUpForm.value.password);
      this.signUp(this.signUpForm.value);
    }
  }

  isFieldInvalid(fieldName: string) {
    const field = this.signUpForm.get(fieldName);
    return field?.invalid && (field?.dirty || field?.touched);
  }

  signUp(data: any) {
    this.userService.signUp(data).subscribe({
      next: (data) => {
        console.log(data);
        this.router.navigate(['/login']);
      },
      error: (error) => {
        this.snackBar.open(error.error['message'], '', {
          duration: 3000,
        });
      },
    });
  }
}
