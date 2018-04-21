import { Component, OnInit } from '@angular/core';

import { routerTransition } from '../router.animations';
import { EquipmentModelsService } from './equipment-models.service';
import { EquipmentModel } from './../models/equipment-model.model';

@Component({
  selector: 'app-equipment-models',
  templateUrl: './equipment-models.component.html',
  animations: [routerTransition()]
})
export class EquipmentModelsComponent implements OnInit {

  equipmentModels: EquipmentModel[]

  constructor(private equipmentModelsService: EquipmentModelsService) { }

  ngOnInit() {
    this.equipmentModelsService.getItems().subscribe(
      res => this.equipmentModels = res);
  }

  deleteItem(item) {
    if (confirm("Do you really want to delete the item: " + item.name + "?")) {
      var index = this.equipmentModels.indexOf(item);
      this.equipmentModels.splice(index, 1);

      this.equipmentModelsService.deleteItem(item.id)
        .subscribe(null,
          err => {
            alert("Could not delete the item.");
            this.equipmentModels.splice(index, 0, item);
          });
    }
  }

}
