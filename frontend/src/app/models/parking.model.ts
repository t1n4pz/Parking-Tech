export interface ParkingSlot {
  id: number;
  number: string;
  level?: string;
  reserved?: boolean;
  currentReservation?: Reservation | null;
}

export interface Reservation {
  id: number;
  userId: number;
  slotId: number;
  from: string; // ISO date
  to: string;   // ISO date
  price: number;
}
