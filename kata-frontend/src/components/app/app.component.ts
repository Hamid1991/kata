import { Component } from '@angular/core';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';
import {TransformerService} from '../../services/transformer.service';

interface TransformedNumber {
  transformedNumber: string;
}

interface NumberToTransform {
  numberToTransform: number;
}

@Component({
  selector: 'app-root',
  imports: [RouterModule, FormsModule, NgIf],
  templateUrl: './app.component.html',
  standalone: true
})

export class AppComponent {
  title = 'kata-frontend';

  numberToTransform: NumberToTransform;

  transformedNumber: TransformedNumber;


  constructor(private transformerService: TransformerService) {}


  transformNumber() {
    this.transformerService.transformNumber(this.numberToTransform)
      .subscribe(
        (response) => {
          this.transformedNumber = response;
        }
      );
  }
}
