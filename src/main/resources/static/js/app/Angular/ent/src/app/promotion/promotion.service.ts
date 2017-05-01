import {Http} from "@angular/http";
import {Promotion} from "./promotion";
import {Injectable} from "@angular/core";
import "rxjs/add/operator/toPromise";

@Injectable()
export class PromotionService {

  promotionUrl = 'http://localhost:8080/promotion';

  constructor(private http: Http) {
  }

  getPromotions(): Promise<Promotion[]> {
    return this.http.get(this.promotionUrl + '/index')
      .toPromise()
      .then(response => response.json() as Promotion[])
      .catch(this.errorHandler);
  }

  private errorHandler(error: any): Promise<any> {
    console.error('An error occured', error);
    return Promise.reject(error.message || error);
  }
}
