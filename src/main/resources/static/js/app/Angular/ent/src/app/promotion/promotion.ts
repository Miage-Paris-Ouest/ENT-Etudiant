import {Etudiant} from "../etudiant/etudiant";

export class Promotion {
  id: number;
  nom_promo: string;
  annee: string;
  etudiants: Etudiant[] = [];
}
