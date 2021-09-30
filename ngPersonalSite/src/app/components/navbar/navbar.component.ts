import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  megaManAction: Boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  shoot() {

    this.megaManAction = true;

    }

  }
