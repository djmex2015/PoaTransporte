export class Itinerary {
  itineraryId: Object;
  latitud: string;
  longitud: string;

  constructor(itineraryId: Object, latitud: string, longitud: string) {
    this.itineraryId = itineraryId;
    this.latitud = latitud;
    this.longitud = longitud;
  }

}
