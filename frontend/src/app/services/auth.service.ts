import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user.model';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private storageKey = 'parking-token';

  constructor(private router: Router) {}

  login(email: string, password: string): boolean {
    // Demo: credenciales fijas. En producción, llamar a API.
    if (email === 'admin@example.com' && password === '123456') {
      const mockToken = JSON.stringify({ userId: 1, email });
      localStorage.setItem(this.storageKey, mockToken);
      return true;
    }
    return false;
  }

  register(user: User): boolean {
    // Demo: guarda en localStorage (no seguro)
    const users = this.getUsers();
    const exists = users.find(u => u.email === user.email);
    if (exists) return false;
    user.id = users.length + 1;
    users.push(user);
    localStorage.setItem('parking-users', JSON.stringify(users));
    return true;
  }

  logout() {
    localStorage.removeItem(this.storageKey);
    this.router.navigate(['/login']);
  }

  isAuthenticated(): boolean {
    return !!localStorage.getItem(this.storageKey);
  }

  getUser(): User | null {
    const token = localStorage.getItem(this.storageKey);
    return token ? JSON.parse(token) : null;
  }

  private getUsers(): User[] {
    const raw = localStorage.getItem('parking-users');
    return raw ? JSON.parse(raw) : [];
  }
}
