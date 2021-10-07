import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Post } from '../models/post';
import { AuthService } from './auth.service';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PostsService {
  private baseUrl = 'http://localhost:8099/';
  // private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient, private auth: AuthService) { }

  index() : Observable<Post[]> {
    return this.http.get<Post[]>(this.baseUrl + "posts")
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error getting posts ' + err);
      })
    );
  }

  getHttpOptions(){
    const credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'X-Requested-With': 'XMLHttpRequest',
        'Authorization': `Basic ${credentials}`
      })
    };
    return httpOptions;
  }

}
