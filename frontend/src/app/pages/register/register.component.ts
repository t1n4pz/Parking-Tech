import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  nombre = '';
  cedula = '';
  tipoVehiculo = '';
  placa = '';
  email = '';
  password = '';

  constructor(private router: Router) {}

  register() {
    if (!this.nombre || !this.cedula || !this.tipoVehiculo || !this.placa || !this.email || !this.password) {
      alert('Por favor completa todos los campos');
      return;
    }

    const userData = {
      nombre: this.nombre,
      cedula: this.cedula,
      tipoVehiculo: this.tipoVehiculo,
      placa: this.placa,
      email: this.email,
      password: this.password
    };

    // Guardar datos en localStorage
    localStorage.setItem('user', JSON.stringify(userData));

    alert('Usuario registrado con éxito');
    this.router.navigate(['/login']);
  }
}
