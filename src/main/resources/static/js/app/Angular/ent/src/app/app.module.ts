import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";

import {AppComponent} from "./app.component";
import {EtudiantComponent} from "./etudiant/etudiant.component";
import {EtudiantService} from "./etudiant/etudiant.service";

@NgModule({
  declarations: [
    AppComponent,
    EtudiantComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [EtudiantService],
  bootstrap: [AppComponent, EtudiantComponent]
})
export class AppModule {
}
