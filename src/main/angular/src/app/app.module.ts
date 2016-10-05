import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

//import { InMemoryWebApiModule } from 'angular2-in-memory-web-api';
//import { PageDataMock } from "./page/page-data-mock.service.ts";
//import { ArticleDataMock } from "./article/article-data-mock.service";

import { routing } from './app.routing';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';

import { PageService } from "./page/page.service";
import { PageComponent } from "./page/page.component";

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    PageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    //InMemoryWebApiModule.forRoot(PageDataMock),
    //InMemoryWebApiModule.forRoot(ArticleDataMock)
  ],
  providers: [PageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
