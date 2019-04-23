import { Component, OnInit } from '@angular/core';
import { BicycleService } from '../shared/bicycle/bicycle.service';

@Component({
  selector: 'app-bicycle-list',
  templateUrl: './bicycle-list.component.html',
  styleUrls: ['./bicycle-list.component.css']
})
export class BicycleListComponent implements OnInit {
  bicycles: Array<any>;

  constructor(private bicycleService: BicycleService) { }

  ngOnInit() {
    this.bicycleService.getAll().subscribe(data => {
      this.bicycles = data;
    });
  }
}
