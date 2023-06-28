import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
  Validators
} from "@angular/forms";
import {Router} from "@angular/router";
import {RegisterPayload} from "../registerPayload";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  registerForm = FormGroup;
  registerPayload = RegisterPayload;

  constructor(private formBuilder: FormBuilder,
              private router: Router) {
    // @ts-ignore
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', {
        validators: [
          Validators.required,
          Validators.email
        ],
        updateOn: 'blur'
      }],
      password: [
        '',
        [Validators.required,
          Validators.minLength(8),
          //this.createPasswordStrengthValidator()
        ]
      ]
    });


  }

  // createPasswordStrengthValidator(): ValidatorFn {
  //   return (control: AbstractControl): ValidationErrors | null => {
  //
  //     const value = control.value;
  //
  //     if (!value) {
  //       return null;
  //     }
  //
  //     const hasUpperCase = /[A-Z]+/.test(value);
  //
  //     const hasLowerCase = /[a-z]+/.test(value);
  //
  //     const hasNumeric = /[0-9]+/.test(value);
  //
  //     const passwordValid = hasUpperCase && hasLowerCase && hasNumeric;
  //
  //     return !passwordValid ? {passwordStrength: true} : null;
  //   }
  // }
  // onSubmit() {
  //   this.registerPayload.username = this.registerForm.get('username').value;
  //   this.registerPayload.email = this.registerForm.get('email').value;
  //   this.registerPayload.password = this.registerForm.get('password').value;
  //   this.registerPayload.confirmPassword = this.registerForm.get('confirmPassword').value;
  //
  //   this.authService.register(this.registerPayload).subscribe(data => {
  //     console.log('register succes');
  //     this.router.navigateByUrl('/register-success');
  //   }, error => {
  //     console.log('register failed');
  //   });
  // }

}
