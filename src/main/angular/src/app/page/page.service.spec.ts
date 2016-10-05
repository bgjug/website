/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { PageService } from './page.service.ts';

describe('Service: Page', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PageService]
    });
  });

  it('should ...', inject([PageService], (service: PageService) => {
    expect(service).toBeTruthy();
  }));
});
