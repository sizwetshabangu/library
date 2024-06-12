import { Component } from '@angular/core';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-category',
  standalone: true,
  imports: [
    MatTableModule,

  ],
  templateUrl: './category.component.html',
  styles: [`
    .demo-table {
     width: 100%;
    }

    .mat-mdc-row .mat-mdc-cell {
      border-bottom: 1px solid transparent;
      border-top: 1px solid transparent;
      cursor: pointer;
    }

    .mat-mdc-row:hover .mat-mdc-cell {
      border-color: currentColor;
    }

    .demo-row-is-clicked {
      font-weight: bold;
    }
  `]
})

export class CategoryComponent {
  categories: Category[] = [
    { name: 'Horror', description: 'Dark and eerie tales designed to evoke fear, dread, and terror.' },
    { name: 'Comedy', description: 'Humorous and entertaining narratives that evoke laughter and amusement.' },
    { name: 'Thriller', description: 'Fast-paced, suspenseful stories with high stakes and unexpected twists.' },
  ];
  displayedColumns: string[] = ['name', 'description'];
}

type Category = {
  name: string;
  description: string;
}; 
