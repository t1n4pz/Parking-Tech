import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email = '';
  password = '';

  constructor(private router: Router) {}

  login() {
    // Usuario administrador fijo
    if (this.email === 'admin@parking.com' && this.password === 'admin123') {
      localStorage.setItem('user', JSON.stringify({
        nombre: 'Administrador',
        cedula: '0000000000',
        tipoVehiculo: 'N/A',
        placa: 'N/A',
        email: this.email,
        role: 'admin'
      }));
      this.router.navigate(['/dashboard']);
      return;
    }

    // Usuario registrado normal
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      const userData = JSON.parse(storedUser);
      if (userData.email === this.email && userData.password === this.password) {
        this.router.navigate(['/dashboard']);
        return;
      }
    }

    alert('Credenciales incorrectas');
  }
}
