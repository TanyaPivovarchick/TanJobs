import { Component } from '@angular/core';

import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/operator/switchMap';
import { Subscription } from 'rxjs/Subscription';
import { Observable } from 'rxjs/Observable';
import { Observer } from 'rxjs/Observer';

@Component({
  selector   : 'header',
  templateUrl: './header.component.html'
})

export class HeaderComponent { }