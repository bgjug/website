import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {PageComponent} from "./page/page.component";
import {ArticleComponent} from "./article/article.component";
const appRoutes : Routes = [
    {path: '', redirectTo: '/page/1', pathMatch: 'full'},
    {path: 'page/:id', component : PageComponent},
    //{path: 'articles', component : ArticlesMenuComponent},
    //{path: 'article/:id', component : ArticleComponent},
]
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);