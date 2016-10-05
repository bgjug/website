import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import {Page} from "./page";
import {PageService} from "./page.service";

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {
  page: Page;

  constructor(private route: ActivatedRoute, private pageService: PageService) { }

  goBack(): void {
    window.history.back();
  }
  ngOnInit(): void {
    this.route.params.forEach((params: Params) => {
      let id  = params['id'];
      console.log('id: '+id);
      //this.page =
      this.pageService.getPage(id).then(
        page => this.page = page
      );
      //console.log('this.page:: '+this.page.id);
    });
  }
}
