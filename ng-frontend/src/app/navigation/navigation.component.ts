import { Component } from '@angular/core';
import { MatIcon, MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';

@Component({
  selector: 'app-navigation',
  standalone: true,
  imports: [
    MatToolbarModule,
    MatIconModule,
  ],
  templateUrl: './navigation.component.html',
  styles: [`
    .example-spacer {
      flex: 1 1 auto;
    }`]
})
export class NavigationComponent {

}
