import {Component, OnInit} from "@angular/core";
import {Etudiant} from "./etudiant";
import {EtudiantService} from "./etudiant.service";

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.css']
})
export class EtudiantComponent implements OnInit {

  text = 'Mon texte !';
  etudiants: Etudiant[] = [];

  constructor(private eService: EtudiantService) {
  }

  ngOnInit(): void {
    this.eService.getEtudiants().then(etudiants => this.etudiants = etudiants);
    console.error(this.etudiants);
  }
}
