import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LinesComponent } from './lines/lines.component';
import { ItineraryComponent } from './itinerary/itinerary.component';
import { InputSearchComponent } from './input-search/input-search.component';
import { CreateLineComponent } from './create-line/create-line.component';
import { InputDataComponent } from './input-data/input-data.component';
import { CreateItinComponent } from './create-itin/create-itin.component';
import { FilterRaioComponent } from './filter-raio/filter-raio.component';

@NgModule({
  declarations: [
    AppComponent,
    LinesComponent,
    ItineraryComponent,
    InputSearchComponent,
    CreateLineComponent,
    InputDataComponent,
    CreateItinComponent,
    FilterRaioComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'lines', component: LinesComponent },
      { path: 'createLines', component: CreateLineComponent },
      { path: 'itinerary', component: ItineraryComponent },
      { path: 'createItin', component: CreateItinComponent },
      { path: 'filterRaio', component: FilterRaioComponent },
      { path: '', redirectTo: 'lines', pathMatch: 'full' },
      { path: '**', redirectTo: 'lines', pathMatch: 'full' }
    ], { useHash: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
