import { Injectable } from '@angular/core';
import { ParkingSlot, Reservation } from '../models/parking.model';

@Injectable({ providedIn: 'root' })
export class ParkingService {
  private slotsKey = 'parking-slots';
  private reservationsKey = 'parking-reservations';

  constructor() {
    this.seed();
  }

  private seed() {
    if (!localStorage.getItem(this.slotsKey)) {
      const slots: ParkingSlot[] = [];
      for (let i = 1; i <= 12; i++) {
        slots.push({ id: i, number: `P-${i}`, reserved: false, currentReservation: null });
      }
      localStorage.setItem(this.slotsKey, JSON.stringify(slots));
      localStorage.setItem(this.reservationsKey, JSON.stringify([]));
    }
  }

  getSlots(): ParkingSlot[] {
    return JSON.parse(localStorage.getItem(this.slotsKey) || '[]');
  }

  getReservations(): Reservation[] {
    return JSON.parse(localStorage.getItem(this.reservationsKey) || '[]');
  }

  reserveSlot(userId: number, slotId: number, from: string, to: string, price: number): Reservation {
    const reservations: Reservation[] = this.getReservations();
    const newRes: Reservation = {
      id: reservations.length + 1,
      userId,
      slotId,
      from,
      to,
      price
    };
    reservations.push(newRes);
    localStorage.setItem(this.reservationsKey, JSON.stringify(reservations));

    const slots = this.getSlots();
    const slot = slots.find(s => s.id === slotId);
    if (slot) {
      slot.reserved = true;
      slot.currentReservation = newRes;
      localStorage.setItem(this.slotsKey, JSON.stringify(slots));
    }

    return newRes;
  }

  cancelReservation(reservationId: number) {
    let reservations: Reservation[] = this.getReservations();
    const res = reservations.find(r => r.id === reservationId);
    if (!res) return;
    reservations = reservations.filter(r => r.id !== reservationId);
    localStorage.setItem(this.reservationsKey, JSON.stringify(reservations));

    const slots = this.getSlots();
    const slot = slots.find(s => s.id === res.slotId);
    if (slot) {
      slot.reserved = false;
      slot.currentReservation = null;
      localStorage.setItem(this.slotsKey, JSON.stringify(slots));
    }
  }
}
