import { InMemoryDbService } from 'angular2-in-memory-web-api';
export class ArticleDataMock implements InMemoryDbService {
  createDb() {
    let articles = [
      {title: 'Article1', isPublished: true, content: 'article 1 wahaa', author: 'Mihail'},
      {title: 'Article2', isPublished: true, content: 'article 2 wahaa', author: 'Mihail'},
      {title: 'Article should not be visible ', isPublished: false, content: 'article SHOULD NOT BE VISIBLE - because it\'s not published', author: 'Mihail'},
    ];
    return {articles};
  }
}
//let menuItems = [
//  {title: 'Home', link: '/', content: 'Home'},
//  {title: 'Articles', link: '/articles', subMenus: [
//    {title: 'Article1', link: '/article/1', content: 'article 1 wahaa'},
//    {title: 'Article2', link: '/article/2', content: 'article 2 wahaa'},
//  ]},
//  {title: 'Page1', link: '/page/1', content: 'page 1 wahaa'},
//  {title: 'Page2', link: '/page/2', content: 'page 2 wahaa'},
//  {title: 'About', link: '/about' , content: 'about'}
//];
//return {menuItems};
