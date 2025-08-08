import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from "../../components/navbar/navbar.component";
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

interface Alquiler {
  placa: string;
  horaEntrada: string;
  horaSalida?: string;
}

@Component({
  selector: 'app-parking',
  imports: [NavbarComponent, FormsModule, CommonModule],
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css'],
})
export class ParkingComponent implements OnInit {
  placa = '';
  alquileres: Alquiler[] = [];

  ngOnInit() {
    const data = localStorage.getItem('alquileres');
    if (data) {
      this.alquileres = JSON.parse(data);
    }
  }

  registrarEntrada() {
    if (!this.placa.trim()) {
      alert('Por favor ingresa la placa.');
      return;
    }

    const nuevo: Alquiler = {
      placa: this.placa.toUpperCase(),
      horaEntrada: new Date().toLocaleString()
    };

    this.alquileres.push(nuevo);
    this.placa = '';
    this.guardar();
  }

  registrarSalida(index: number) {
    this.alquileres[index].horaSalida = new Date().toLocaleString();
    this.guardar();
  }

  guardar() {
    localStorage.setItem('alquileres', JSON.stringify(this.alquileres));
  }
}
