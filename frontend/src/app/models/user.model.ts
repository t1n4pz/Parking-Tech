export interface User {
  id: number;
  email: string;
  password?: string; // solo local, no almacenar en claro en prod
  name?: string;
}
