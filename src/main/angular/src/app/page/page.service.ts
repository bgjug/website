import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';

import { Page } from './page';

@Injectable()
export class PageService {
  //private pagesUrl = 'app/pages';  // URL to web api

  constructor(private http: Http) { }
  getPages(): Promise<Page[]> {
    return this.http.get(`api/page`, {headers: new Headers({'Accept': 'application/json'})})
        .toPromise()
        .then(
            response => response.json().pageInfo as Page[]
        );
        //.map((r: Response) => r.json().page as Page[]);
  }
  getPage(id: number): Promise<Page> {
    return this.http.get(`api/page/`+id, {headers: new Headers({'Accept': 'application/json'})})
        .toPromise()
        .then(
            response => response.json().page as Page
        );
    //.map((r: Response) => r.json().page as Page[]);
  }

  testPages(): Promise<Page[]> {
    let pages = [
      {id:1,title: 'Home', content: 'Home', isPublished: true, subPages: undefined},
      {id:1,title: 'Page1', content: 'page 1 wahaa', isPublished: true, subPages: undefined},
      {id:1,title: 'Page2', content: 'page 2 wahaa', isPublished: true, subPages: undefined},
      {id:1,title: 'About', content: 'about', isPublished: true, subPages: undefined},
      {id:1,title: 'ComplexPage', content: '', isPublished: true, subPages: [
        {id:1,title: 'SubPage1', content: 'article 1 wahaa', isPublished: true, subPages: undefined},
        {id:1,title: 'SubPage2', content: 'article 2 wahaa', isPublished: true, subPages: undefined},
      ]},
      {id:1,title: 'Page should not be visible ', isPublished: false, content: 'page 2 SHOULD NOT BE VISIBLE - because it\'s not published', subPages: undefined},
    ];

    return Promise.resolve(pages);
  }

  testPage(title: string): Page {
    let pages = [
      {id:1,title: 'Home', content: 'Home', isPublished: true},
      {id:1,title: 'Page1', content: 'page 1 wahaa', isPublished: true},
      {id:1,title: 'Page2', content: 'page 2 wahaa', isPublished: true},
      {id:1,title: 'About', content: 'about', isPublished: true},
      {id:1,title: 'ComplexPage', content: '', isPublished: true, subPages: [
        {id:1,title: 'SubPage1', content: 'SubPage1 1 wahaa', isPublished: true},
        {id:1,title: 'SubPage2', content: 'SubPage2 2 wahaa', isPublished: true},
      ]},
      {id:1,title: 'Page should not be visible ', isPublished: false, content: 'page 2 SHOULD NOT BE VISIBLE - because it\'s not published'},
    ];

    console.log('getPage('+title);
    return this.flatten(pages).find(page => page.title === title);
  }

  flatten(pages: Page[]): Page[] {
    return pages.reduce(
        (previous, current) =>
            Array.isArray(current.subPages)
                ? [...previous, current, ...this.flatten(current.subPages)]
                : [...previous, current]
        , []
    );
  }

  //private handleError(error: any): Promise<any> {
  //  console.error('An error occurred', error); // for demo purposes only
  //  return Promise.reject(error.message || error);
  //}
}