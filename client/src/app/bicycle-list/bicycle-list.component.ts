import { Component, OnInit } from '@angular/core';
import { BicycleService } from '../shared/bicycle/bicycle.service';
import {GiphyService} from '../shared/giphy/giphy.service';

@Component({
  selector: 'app-bicycle-list',
  templateUrl: './bicycle-list.component.html',
  styleUrls: ['./bicycle-list.component.css']
})
export class BicycleListComponent implements OnInit {
  bicycles: Array<any>;

  constructor(private bicycleService: BicycleService, private giphyService: GiphyService) { }

  ngOnInit() {
    this.bicycleService.getAll().subscribe(data => {
      this.bicycles = data;
      for (const bicycle of this.bicycles) {
        this.giphyService.get(bicycle.name + ' ' + 'bicycle').subscribe(url => bicycle.giphyUrl = url);
      }
    });
  }
}
