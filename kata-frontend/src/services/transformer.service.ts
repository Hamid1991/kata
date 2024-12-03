import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransformerService {

  private apiUrl = 'http://localhost:8080/api/transform';

  constructor(private http: HttpClient) { }

  transformNumber(numberToTransform: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json' ,
      'Access-Control-Allow-Origin':'http://localhost:4200' ,
      'Access-Control-Allow-Methods' : 'OPTIONS, POST, GET',
      'Access-Control-Allow-Headers': 'Content-Type, Accept'
    });
    let body = JSON.stringify({ numberToTransform: numberToTransform })
    return this.http.post<any>(this.apiUrl, body, { headers });
  }

}
