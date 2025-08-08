import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  user: any = null;
  reservas: any[] = [];
  nuevaReserva = { fecha: '', hora: '', lugar: '' };
  editando: number | null = null;
  esAdmin = false;

  ngOnInit() {
    const userData = localStorage.getItem('user');
    if (userData) {
      this.user = JSON.parse(userData);
      this.esAdmin = this.user.email === 'admin@admin.com';
    }
    this.cargarReservas();
  }

  cargarReservas() {
    const reservasGuardadas = localStorage.getItem('reservas');
    if (reservasGuardadas) {
      const todas = JSON.parse(reservasGuardadas);
      this.reservas = this.esAdmin
        ? todas // Admin ve todas
        : todas.filter((r: any) => r.usuario === this.user.nombre);
    }
  }

  guardarReservasGlobal() {
    localStorage.setItem('reservas', JSON.stringify(this.reservas));
  }

  reservar() {
    if (this.nuevaReserva.fecha && this.nuevaReserva.hora && this.nuevaReserva.lugar) {
      if (this.editando !== null) {
        this.reservas[this.editando] = {
          ...this.nuevaReserva,
          usuario: this.user.nombre
        };
        this.editando = null;
      } else {
        this.reservas.push({
          ...this.nuevaReserva,
          usuario: this.user.nombre
        });
      }
      this.guardarReservasGlobal();
      this.nuevaReserva = { fecha: '', hora: '', lugar: '' };
      this.cargarReservas();
      alert('Reserva guardada con éxito ✅');
    } else {
      alert('Por favor completa todos los campos');
    }
  }

  editarReserva(index: number) {
    const r = this.reservas[index];
    this.nuevaReserva = { fecha: r.fecha, hora: r.hora, lugar: r.lugar };
    this.editando = index;
  }

  eliminarReserva(index: number) {
    if (confirm('¿Seguro que quieres eliminar esta reserva?')) {
      this.reservas.splice(index, 1);
      this.guardarReservasGlobal();
      this.cargarReservas();
    }
  }
}
