import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Etudiant} from "./etudiant";
import "rxjs/add/operator/toPromise";

@Injectable()
export class EtudiantService {

  private etudiantUrl = 'http://localhost:8080/etudiant';
  // private headers = new Headers({'Content-Type': 'application.json'});

  constructor(private http: Http) {
  }

  getEtudiants(): Promise<Etudiant[]> {
    return this.http.get(this.etudiantUrl + '/index')
      .toPromise()
      .then(response => response.json() as Etudiant[])
      .catch(this.errorHandler);
  }

  private errorHandler(error: any): Promise<any> {
    console.error('An error occured', error);
    return Promise.reject(error.message || error);
  }

  getEtudiantsByPromotionId(id: number) {
    return this.http.get(this.etudiantUrl + '/byPromoId/' + id)
      .toPromise()
      .then(response => response.json() as Etudiant[])
      .catch(this.errorHandler);
  }
}
