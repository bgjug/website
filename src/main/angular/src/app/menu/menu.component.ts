import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { PageService } from "../page/page.service";
import { Page } from "../page/page";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  public pages: Page[];

  constructor(private router: Router, private pageService: PageService) { }
  ngOnInit() {
    this.pageService.getPages().then(pages => this.pages=pages);
  }

  navigateToPage(page: Page): void {
    this.router.navigate(['/page', page.id]);
  }
}
