import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Line } from '../lines/line';
import { Itinerary } from '../itinerary/itinerary';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private urlBase = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getLines(): Observable<Line[]> {
    return this.http.get<Line[]>(this.urlBase + '/line');
  }

  getIdLines(): Observable<Line[]> {
    return this.http.get<Line[]>(this.urlBase + '/line/search/idlinhas');
  }

  getLinesByRaio(latitud: string, longitud: string, raio: string): Observable<Line[]> {
    let params = new HttpParams().set("latitud", latitud).set("longitud", longitud).set("raio", raio);
    return this.http.get<Line[]>(this.urlBase + '/lineraio/raio', { params: params });
  }

  getLinesByNome(nome: string): Observable<Line[]> {
    let params = new HttpParams().set("nome", nome);
    return this.http.get<Line[]>(this.urlBase + '/line/search/nome', { params: params });
  }

  createLine(line: Line): Observable<Line> {
    return this.http.post<Line>(this.urlBase + '/line', line);
  }

  deleteLine(id: string): Observable<Line> {
    return this.http.delete<Line>(this.urlBase + '/line/' + id);
  }

  getItinerary(id: string): Observable<Object> {
    let params = new HttpParams().set("linha", id);
    return this.http.get<Object>(this.urlBase + '/itinerary/search/linha', { params: params });
  }

  createItinerary(itinerary: Itinerary): Observable<Itinerary> {
    return this.http.post<Itinerary>(this.urlBase + '/itinerary', itinerary);
  }
}
