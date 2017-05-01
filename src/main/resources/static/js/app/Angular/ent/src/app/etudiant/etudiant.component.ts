import {Component, OnInit} from "@angular/core";
import {Etudiant} from "./etudiant";
import {EtudiantService} from "./etudiant.service";
import {Promotion} from "../promotion/promotion";
import {PromotionService} from "../promotion/promotion.service";

@Component({
  selector: 'app-etudiant',
  templateUrl: '../../templates/gestionClasses.html',
  styleUrls: ['./etudiant.component.css', './../../css/gestionClasses.css']
})
export class EtudiantComponent implements OnInit {

  etudiants: Etudiant[] = [];
  promotions: Promotion[] = [];

  constructor(private eService: EtudiantService, private pService: PromotionService) {
  }

  ngOnInit(): void {
    this.getEtudiants();
    this.pService.getPromotions().then(promotions => this.promotions = promotions);
  }

  getEtudiants() {
    this.eService.getEtudiants().then(etudiants => this.etudiants = etudiants);
  }

  choosePromotion(id: number): void {
    this.eService.getEtudiantsByPromotionId(id).then(etudiants => this.etudiants = etudiants);
  }
}
