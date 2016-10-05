/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { PageDataMockService } from './article-data-mock.service.ts';

describe('Service: PageDataMock', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PageDataMockService]
    });
  });

  it('should ...', inject([PageDataMockService], (service: PageDataMockService) => {
    expect(service).toBeTruthy();
  }));
});
