import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Line } from '../lines/line';

@Injectable({
  providedIn: 'root'
})
export class LinesService {
  private linesUrl = 'http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o';

  private itineraryUrl = 'http://www.poatransporte.com.br/php/facades/process.php?a=il&p=';

  constructor(private http: HttpClient) { }

  getLines(): Observable<Line[]> {
    return this.http.get<Line[]>(this.linesUrl);
  }

  getItinerary(id: string): Observable<Object> {
    return this.http.get<Object>(this.itineraryUrl + id);
  }
}
